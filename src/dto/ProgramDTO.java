package dto;

import entity.SuperEntity;

import java.util.List;

public class ProgramDTO implements SuperEntity {

    private String id;
    private String name;
    private String duration;
    private double fee;

    private List<StudentProgramDTO> details;

    public ProgramDTO() {
    }

    public ProgramDTO(String id, String name, String duration, double fee) {
        this.setId(id);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public ProgramDTO(String id, String name, String duration, double fee, List<StudentProgramDTO> details) {
        this.setId(id);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
        this.setDetails(details);
    }

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

    public List<StudentProgramDTO> getDetails() {
        return details;
    }
    public void setDetails(List<StudentProgramDTO> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", duration='" + getDuration() + '\'' +
                ", fee='" + getFee() + '\'' +
                '}';
    }
}
