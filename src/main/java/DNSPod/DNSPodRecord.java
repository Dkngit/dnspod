package DNSPod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DNSPodRecord {

    private String id;
    private String name;
    private String line;
    private String line_id;
    private String type;
    private String value;
    private String weight;
    private String mx;
    private String enabled;
    private String status;
    private String monitor_status;
    private String remark;
    private String updated_on;
    private String use_aqb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMx() {
        return mx;
    }

    public void setMx(String mx) {
        this.mx = mx;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonitor_status() {
        return monitor_status;
    }

    public void setMonitor_status(String monitor_status) {
        this.monitor_status = monitor_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public String getUse_aqb() {
        return use_aqb;
    }

    public void setUse_aqb(String use_aqb) {
        this.use_aqb = use_aqb;
    }

    @Override
    public String toString() {
        return "DNSPodRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", line_id='" + line_id + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", weight='" + weight + '\'' +
                ", mx='" + mx + '\'' +
                ", enabled='" + enabled + '\'' +
                ", status='" + status + '\'' +
                ", monitor_status='" + monitor_status + '\'' +
                ", remark='" + remark + '\'' +
                ", updated_on='" + updated_on + '\'' +
                ", use_aqb='" + use_aqb + '\'' +
                '}';
    }
}
