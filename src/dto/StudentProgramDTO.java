package dto;

import entity.SuperEntity;

public class StudentProgramDTO implements SuperEntity {

    private String spId;
    private String date;

    private ProgramDTO program;
    private StudentDTO student;

    public StudentProgramDTO() {
    }

    public StudentProgramDTO(String date, ProgramDTO program, StudentDTO student) {
        this.setDate(date);
        this.setProgram(program);
        this.setStudent(student);
    }

    public StudentProgramDTO(String spId, String date, ProgramDTO program, StudentDTO student) {
        this.setSpId(spId);
        this.setDate(date);
        this.setProgram(program);
        this.setStudent(student);
    }

    public String getSpId() {
        return spId;
    }
    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public ProgramDTO getProgram() {
        return program;
    }
    public void setProgram(ProgramDTO program) {
        this.program = program;
    }

    public StudentDTO getStudent() {
        return student;
    }
    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentProgram{" +
                "spId='" + getSpId() + '\'' +
                ", date='" + getDate() + '\'' +
                ", program=" + getProgram() +
                ", student=" + getStudent() +
                '}';
    }
}
