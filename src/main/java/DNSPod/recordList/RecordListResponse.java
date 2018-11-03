package DNSPod.recordList;

import DNSPod.DNSPodDomain;
import DNSPod.DNSPodRecord;
import DNSPod.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordListResponse {

    private ResponseStatus status;
    private DNSPodDomain domain;
    private List<DNSPodRecord> records;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public List<DNSPodRecord> getRecords() {
        return records;
    }

    public void setRecords(List<DNSPodRecord> records) {
        this.records = records;
    }

    public DNSPodDomain getDomain() {
        return domain;
    }

    public void setDomain(DNSPodDomain domain) {
        this.domain = domain;
    }
}
