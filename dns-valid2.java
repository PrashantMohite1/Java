
todays code - wed




package com.cio.dao;

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

import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.Type;


/**
 * @author Prashant -: here first we check weather we have any orgs which have orgdomainstatus = processing then for that 
 * orgs we do weather their domain are validated or not using txt record challenge
 * 
 */


public class CustomDomainAdder implements Runnable {
    @Autowired(required = true)
    private JdbcOperations jdbcTemplate;

    @Value("${SQL_DOMAIN_REQUEST_CHECK}")
    private String sql_custom_domain_status_check;

    private static final Logger log = LoggerFactory.getLogger(CustomDomainAdder.class);

    @Override
    public void run() {
        log.info("[ Started Custom Domain Adder service. ]");
        handleDomainValidation();
    }

    public void handleDomainValidation() {
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql_custom_domain_status_check);
            if (!CollectionUtils.isEmpty(result)) {
                for (Map<String, Object> orgDetails : result) {
                    validateDomain(orgDetails);
                }
            }
        } catch (Exception ex) {
            log.error("Error in validating domain record.", ex);
            throw new RuntimeException(ex);
        }
    }

    public void validateDomain(Map<String, Object> map) {
        try {
            final Integer orgId = (Integer) map.get("orgid");
            final String txtrecords = (String) map.get("txtrecords");
            final String orgDomain = (String) map.get("orgdomain");

            // Print orgid, txtrecords, and orgdomain
            log.info("[ OrgId: {}, TxtRecords: {}, OrgDomain: {}]", orgId, txtrecords, orgDomain);

            final String orgWebDomain =orgDomain;
            log.info("[ Domain : {}]", orgWebDomain);

//            final String resultRecord = getTxtRecords(orgWebDomain);
            
            List<List<String>> txtRecords = getTxtRecords(orgWebDomain);

//            if (txtrecords.equals(resultRecord)) {
//                log.info("TXT Record is valid, and domain is validated");
//            } else {
//                log.info("Domain validation failed. Try again.");
//            }
        } catch (Exception ex) {
            log.error("Error in validating domain.", ex);
        }
    }

//    private String getTxtRecords(String domain) throws IOException {
//        String txtString = null;
//        try {
//
//            org.xbill.DNS.Record[] records = new Lookup(domain, Type.TXT).run();
//
//            if (records != null) {
//                for (org.xbill.DNS.Record record : records) {
//                    if (record instanceof TXTRecord) {
//                        TXTRecord txtRecord = (TXTRecord) record;
//
//                        for (String txtString1 : txtRecord.getStrings()) {
//                            log.info("TXT Record for " + domain + ": " + txtString1);
//                            txtString = txtString1;
//                        }
//                    }
//                }
//            } else {
//                log.info("No TXT records found for the domain: " + domain);
//            }
//        } catch (IOException e) {
//            log.warn("Error in getting TXT records.", e);
//        }
//        return txtString;
//    }
//}
    
    
    private List<List<String>> getTxtRecords(String domain) {
        try {
            Lookup lookup = new Lookup(domain, Type.TXT);
            org.xbill.DNS.Record[] records = lookup.run();

            if (records != null) {
                for (org.xbill.DNS.Record record : records) {
                    if (record instanceof TXTRecord) {
                        TXTRecord txtRecord = (TXTRecord) record;
                        List<List<String>> txtStrings = List.of(txtRecord.getStrings());
                        log.info("TXT Records for {}: {}", domain, txtStrings);
                        return txtStrings;
                    }
                }
            } else {
                log.info("No TXT records found for the domain: " + domain);
            }
        } catch (IOException e) {
            log.warn("Error in getting TXT records.", e);
        }

        return List.of(); // Return an empty list if no TXT records are found
    }
}






























========================================================================================================================================================================================
package com.cio.dao;

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

public class CustomDomainAdder implements Runnable {
    @Autowired(required = true)
    private JdbcOperations jdbcTemplate;

    @Value("${SQL_DOMAIN_REQUEST_CHECK}")
    private String sql_custom_domain_status_check;

    private static final Logger log = LoggerFactory.getLogger(CustomDomainAdder.class);

    @Override
    public void run() {
        log.info("[ Started Custom Domain Adder service. ]");
        handleDomainValidation();
    }

    public void handleDomainValidation() {
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql_custom_domain_status_check);
            if (!CollectionUtils.isEmpty(result)) {
                for (Map<String, Object> orgDetails : result) {
                    validateDomain(orgDetails);
                }
            }
        } catch (Exception ex) {
            log.error("Error in validating domain record.", ex);
            throw new RuntimeException(ex);
        }
    }

    public void validateDomain(Map<String, Object> map) {
        try {
            final Integer orgId = (Integer) map.get("orgid");
            final String txtrecords = (String) map.get("txtrecords");
            final String orgDomain = (String) map.get("orgdomain");

            // Print orgid, txtrecords, and orgdomain
            log.info("[ OrgId: {}, TxtRecords: {}, OrgDomain: {}]", orgId, txtrecords, orgDomain);

            final String orgWebDomain = "datafrugal." + orgDomain;
            log.info("[ Domain : {}]", orgWebDomain);

            final String resultRecord = getTxtRecords(orgWebDomain);

            if (txtrecords.equals(resultRecord)) {
                log.info("TXT Record is valid, and domain is validated");
            } else {
                log.info("Domain validation failed. Try again.");
            }
        } catch (Exception ex) {
            log.error("Error in validating domain.", ex);
        }
    }

    private String getTxtRecords(String domain) throws IOException {
        String txtString = null;
        try {
            SimpleResolver resolver = new SimpleResolver();
            org.xbill.DNS.Record[] records = new Lookup(domain, Type.TXT).run();

            if (records != null) {
                for (org.xbill.DNS.Record record : records) {
                    if (record instanceof TXTRecord) {
                        TXTRecord txtRecord = (TXTRecord) record;

                        for (String txtString1 : txtRecord.getStrings()) {
                            log.info("TXT Record for " + domain + ": " + txtString1);
                            txtString = txtString1;
                        }
                    }
                }
            } else {
                log.info("No TXT records found for the domain: " + domain);
            }
        } catch (IOException e) {
            log.error("Error in getting TXT records.", e);
        }
        return txtString;
    }
}
