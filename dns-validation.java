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








