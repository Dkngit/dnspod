package DNSPod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DNSPodDomain {

    private String id;
    private String name;
    private String punycode;
    private String grade;
    private String owner;
    private String ext_status;
    private int ttl;

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

    public String getPunycode() {
        return punycode;
    }

    public void setPunycode(String punycode) {
        this.punycode = punycode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getExt_status() {
        return ext_status;
    }

    public void setExt_status(String ext_status) {
        this.ext_status = ext_status;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "DNSPodDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", punycode='" + punycode + '\'' +
                ", grade='" + grade + '\'' +
                ", owner='" + owner + '\'' +
                ", ext_status='" + ext_status + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}
