package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Program implements SuperEntity{
    @Id
    private String pId;
    private String name;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "program")
    private List<StudentProgram> details;

    public Program() {
    }

    public Program(String pId, String name, String duration, double fee) {
        this.setpId(pId);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public Program(String pId, String name, String duration, double fee, List<StudentProgram> details) {
        this.setpId(pId);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
        this.setDetails(details);
    }

    public String getpId() {
        return pId;
    }
    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }
    public void setName(String pName) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<StudentProgram> getDetails() {
        return details;
    }
    public void setDetails(List<StudentProgram> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Program{" +
                "pId='" + getpId() + '\'' +
                ", name='" + getName() + '\'' +
                ", duration='" + getDuration() + '\'' +
                ", fee='" + getFee() + '\'' +
                '}';
    }
}
