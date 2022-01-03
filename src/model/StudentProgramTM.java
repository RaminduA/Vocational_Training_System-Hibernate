package model;

public class StudentProgramTM {
    private String programId;
    private String name;
    private String regDate;
    private String duration;

    public StudentProgramTM() {
    }

    public StudentProgramTM(String programId, String name, String regDate, String duration) {
        this.setProgramId(programId);
        this.setName(name);
        this.setRegDate(regDate);
        this.setDuration(duration);
    }

    public String getProgramId() {
        return programId;
    }
    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "StudentProgramTM{" +
                "programId='" + getProgramId() + '\'' +
                ", name='" + getName() + '\'' +
                ", regDate='" + getRegDate() + '\'' +
                ", duration='" + getDuration() + '\'' +
                '}';
    }
}
