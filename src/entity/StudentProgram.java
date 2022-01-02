package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentProgram implements SuperEntity{
    @Id
    private String spId;
    private String date;

    @ManyToOne
    private Program program;
    @ManyToOne
    private Student student;

    public StudentProgram() {
    }

    public StudentProgram(String spId, String date, Program program, Student student) {
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

    public Program getProgram() {
        return program;
    }
    public void setProgram(Program program) {
        this.program = program;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
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