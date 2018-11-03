package DNSPod.recordDdns;

import DNSPod.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordDDnsResponse {

    private ResponseStatus status;
    private RecordDDnsRecord record;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public RecordDDnsRecord getRecord() {
        return record;
    }

    public void setRecord(RecordDDnsRecord record) {
        this.record = record;
    }
}
