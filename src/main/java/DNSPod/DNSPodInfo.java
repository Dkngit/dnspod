package DNSPod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DNSPodInfo {

    private String sub_domains;
    private String record_total;
    private String records_num;

    public String getSub_domains() {
        return sub_domains;
    }

    public void setSub_domains(String sub_domains) {
        this.sub_domains = sub_domains;
    }

    public String getRecord_total() {
        return record_total;
    }

    public void setRecord_total(String record_total) {
        this.record_total = record_total;
    }

    public String getRecords_num() {
        return records_num;
    }

    public void setRecords_num(String records_num) {
        this.records_num = records_num;
    }

    @Override
    public String toString() {
        return "DNSPodInfo{" +
                "sub_domains='" + sub_domains + '\'' +
                ", record_total='" + record_total + '\'' +
                ", records_num='" + records_num + '\'' +
                '}';
    }
}
