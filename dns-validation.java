package first_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.xbill.DNS.*;



public class ThirdClass  {
    public static void main(String[] args) throws IOException {
        // JDBC connection parameters for PostgreSQL
        String jdbcUrl = "jdbc:postgresql://localhost:5432/dfmmdbdemo";
        String username = "keycloak";
        String password = "ciodatabase";
        

        // SQL query
        String sqlQuery = "select orgid, orgdomain, txtrecords, customurl from orgdetails od where customdomainstatus='processing'";

        try (
            // Load the PostgreSQL JDBC driver
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a prepared statement with the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            // Process the result set
            while (resultSet.next()) {
                // Retrieve values from each column
                int orgid = resultSet.getInt("orgid");
                String orgdomain = resultSet.getString("orgdomain");
                String txtrecords = resultSet.getString("txtrecords");
                String customurl = resultSet.getString("customurl");
                
                String actualtxtrecord = getTxtRecords(orgdomain);
                System.out.println("actual txt record :- " + actualtxtrecord);
                
                if (txtrecords.equals(actualtxtrecord)) {
                	System.out.println("TXT Record is valid , and domain is validated");
                	
                }else {
                	System.out.println("domain validation failed try again");
                	
                }

                // Now you can use these variables for further operations
//                System.out.println("orgid: " + orgid);
//                System.out.println("orgdomain: " + orgdomain);
//                System.out.println("txtrecords: " + txtrecords);
//                System.out.println("customurl: " + customurl);

                // Perform further operations with these variables
            }
            
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
    }
    
    
    private static String getTxtRecords(String domain) throws IOException {
    	String txtString = null;
        try {
            SimpleResolver resolver = new SimpleResolver();
            org.xbill.DNS.Record[] records = new Lookup(domain, Type.TXT).run();

            if (records != null) {
                for (org.xbill.DNS.Record record : records) {
                    if (record instanceof TXTRecord) {
                        TXTRecord txtRecord = (TXTRecord) record;

                        for (String txtString1 : txtRecord.getStrings()) {
                            System.out.println("TXT Record for " + domain + ": " + txtString1);
                            txtString = txtString1;
//                            return txtString;
                        }
                    }
                }
            } else {
                System.out.println("No TXT records found for the domain: " + domain);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		return txtString;
		
    }

}





******************************* pom.xml *********************************************************************************
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>DnsValidation_apis</groupId>
  <artifactId>DnsValidation_apis</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <dependencies>
	<dependency>
	    <groupId>software.amazon.awssdk</groupId>
	    <artifactId>route53</artifactId>
	    <version>2.17.98</version> <!-- Use the latest version available -->
	</dependency>

	<!-- https://mvnrepository.com/artifact/dnsjava/dnsjava -->
	<dependency>
	    <groupId>dnsjava</groupId>
	    <artifactId>dnsjava</artifactId>
	    <version>3.5.3</version>
	</dependency>
	<dependency>
		<groupId>com.celeritio</groupId>
		<artifactId>ds-adaptor</artifactId>
		<version>1.0.1-SNAPSHOT</version>
	</dependency>
  </dependencies>
  
  
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>






