package com.cio.dao;

///**

// * @author Parshant :- check customdomainstatus from orgdetails table if it is processing or failed then again do dnsvalidation
// * if validation success then only add thier custom url org-name.demo-drive.datafrugal in route53 
// */

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.util.CollectionUtils;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.Type;

public class CustomDomainAdder implements Runnable
{
	@Autowired(required = true)
	private JdbcOperations jdbcTemplate;

	@Value("${SQL_DOMAIN_REQUEST_CHECK}")
	private String sql_custom_domain_status_check;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	private static final Logger log = LoggerFactory.getLogger(CustomDomainAdder.class);

	@Override
	public void run()
	{

		log.info("[ Started Custom Domain Adder service. ]");
		handleDomainValidation();

	}

	public void handleDomainValidation()
	{
		try
		{

			List<Map<String, Object>> result = jdbcTemplate.queryForList(sql_custom_domain_status_check, "firstinput",
					"secondInput", "thirdInput");
			if (!CollectionUtils.isEmpty(result))
			{
				for (Map<String, Object> orgDetails : result)
				{
					validateDomain(orgDetails);
				}
			}

		} catch (Exception ex)
		{
			log.warn("[ Error in validating domain record.]");
			throw new RuntimeException(ex);
		}
	}

	public void validateDomain(Map<String, Object> map) throws Exception
	{
		try
		{

			final String orgId = (String) map.get("orgid");
			final String txtrecords = (String) map.get("txtrecords");
			final String orgDomain = (String) map.get("orgdomain");

			final String orgWebDomain = "datafrugal." + orgDomain;
			log.info("[ Domain : {}]", orgWebDomain);

			final String resultRecorde = getTxtRecords(orgWebDomain);

			if (txtrecords.equals(resultRecorde))
			{
				log.info("TXT Record is valid , and domain is validated");
			} else
			{
				log.info("domain validation failed try again");
			}

		} catch (Exception ex)
		{
			throw new Exception(ex);
		}
	}

//	public void validatedomain() throws IOException
//	{
//
//		try
//		{
////			// Load the PostgreSQL JDBC driver
////			Connection connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
//////
//////			// Create a prepared statement with the SQL query
////			PreparedStatement preparedStatement = connection.prepareStatement(
////					"select orgid, orgdomain, txtrecords, customurl from orgdetails od where customdomainstatus='processing';");
////
////			// Execute the query and get the result set
////			ResultSet resultSet = preparedStatement.executeQuery();
//
//			
//			
//			Map<String, Object> orrgdetailsMap = jdbcTemplate.queryForMap(sql_custom_domain_status_check);
//
//
//			// Process the result set
//			while (String nextVal : orrgdetailsMap )
//			{
//
////				// Retrieve values from each column
//				Object orgid = orrgdetailsMap.get("orgid");
//				Object orgdomain = orrgdetailsMap.get("orgdomain");
//				Object txtrecords = orrgdetailsMap.get("txtrecords");
//				Object customurl = orrgdetailsMap.get("customurl");
//				
//				
////				int orgid = resultSet.getInt("orgid");
////				String orgdomain = "datafrugal." + resultSet.getString("orgdomain");
////				String txtrecords = resultSet.getString("txtrecords");
////				String customurl = resultSet.getString("customurl");
////				String validdomain = "datafrugal." + orgdomain;
//
//				String actualtxtrecord = getTxtRecords(orgdomain.toString());
//				System.out.println("actual txt record :- " + actualtxtrecord);
//
//				if (txtrecords.equals(actualtxtrecord))
//				{
//					log.info("TXT Record is valid , and domain is validated");
//
//				} else
//				{
//					log.info("domain validation failed try again");
//
//				}
//				// Perform further operations with these variables
//			}
//
//			resultSet.next();
//
//		} catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//
//	}

	private static String getTxtRecords(String domain) throws IOException
	{
		String txtString = null;
		try
		{
			SimpleResolver resolver = new SimpleResolver();
			org.xbill.DNS.Record[] records = new Lookup(domain, Type.TXT).run();

			if (records != null)
			{
				for (org.xbill.DNS.Record record : records)
				{
					if (record instanceof TXTRecord)
					{
						TXTRecord txtRecord = (TXTRecord) record;

						for (String txtString1 : txtRecord.getStrings())
						{
							log.info("TXT Record for " + domain + ": " + txtString1);
							txtString = txtString1;
//                            return txtString;
						}
					}
				}
			} else
			{
				log.info("No TXT records found for the domain: " + domain);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return txtString;

	}

}
