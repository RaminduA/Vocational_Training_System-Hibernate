package dto;

import entity.SuperEntity;

import java.util.List;

public class ProgramDTO implements SuperEntity {

    private String pId;
    private String name;
    private String duration;
    private String fee;

    private List<StudentProgramDTO> details;

    public ProgramDTO() {
    }

    public ProgramDTO(String pId, String name, String duration, String fee) {
        this.setpId(pId);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public ProgramDTO(String pId, String name, String duration, String fee, List<StudentProgramDTO> details) {
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

    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
    }

    public List<StudentProgramDTO> getDetails() {
        return details;
    }
    public void setDetails(List<StudentProgramDTO> details) {
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
