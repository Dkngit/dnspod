package hello;

import DNSPod.DNSPodRecord;
import DNSPod.recordDdns.RecordDDnsResponse;
import DNSPod.recordList.RecordListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class Actuator implements Runnable {

    private static final String RECORD_LIST = "https://dnsapi.cn/Record.List";
    private static final String RECORD_DDNS = "https://dnsapi.cn/Record.Ddns";
    private static final Logger log = LoggerFactory.getLogger(Actuator.class);


    @Override
    public void run() {
        try {
            File configFile = new File("config.properties");
            FileInputStream fileInputStream = new FileInputStream(configFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);

            String login_token = properties.getProperty("login_token");
            String returnIPServer = properties.getProperty("returnIPServer");
            String domain = properties.getProperty("domain");
            String record_name = properties.getProperty("record_name");

            RestTemplate restTemplate = new RestTemplate();

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("login_token", login_token);
            params.add("format", "json");
            params.add("domain", domain);

            RecordListResponse recordListResponse = restTemplate.postForObject(RECORD_LIST, params, RecordListResponse.class);
            if ("1".equals(recordListResponse.getStatus().getCode())) {
                String domain_id = recordListResponse.getDomain().getId();
                String record_id = null;
                String address = null;

                List<DNSPodRecord> records = recordListResponse.getRecords();
                for (DNSPodRecord record : records) {
                    if (record_name.equals(record.getName())) {
                        record_id = record.getId();
                        address = record.getValue();
                        break;
                    }
                }
                if (isNotEmpty(domain_id) && isNotEmpty(record_id)) {
                    while (true) {
                        long sleepTime = 10000;
                        try {
                            log.info("oldAddress ... "+address);
                            String newAddress = restTemplate.getForObject(returnIPServer, String.class);
                            log.info("newAddress ... " + newAddress);
                            if (isNotEmpty(newAddress)) {
                                if (!address.equals(newAddress)) {
                                    MultiValueMap<String, String> params1 = new LinkedMultiValueMap<>();
                                    params1.add("login_token", login_token);
                                    params1.add("format", "json");
                                    params1.add("domain_id", domain_id);
                                    params1.add("record_id", record_id);
                                    params1.add("sub_domain", record_name);
                                    params1.add("record_line_id", "0");

                                    RecordDDnsResponse recordDDnsResponse = restTemplate.postForObject(RECORD_DDNS, params1, RecordDDnsResponse.class);
                                    if ("1".equals(recordDDnsResponse.getStatus().getCode())) {
                                        address = recordDDnsResponse.getRecord().getValue();
                                        log.info("update success, sleep 10 second");
                                        sleepTime = 10000;
                                    } else {
                                        log.info("update error, sleep one hour ... ");
                                        sleepTime = 3600000;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                            sleepTime = 600000;
                        } finally {
                            log.info("sleep " + sleepTime / 1000 + " second");
                            Thread.sleep(sleepTime);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }


    private static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    private static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
