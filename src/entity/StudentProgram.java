package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentProgram implements SuperEntity{
    @Id
    @GeneratedValue
    private int spId;
    private String date;

    @ManyToOne
    private Program program;
    @ManyToOne
    private Student student;

    public StudentProgram() {
    }

    public StudentProgram(String date, Program program, Student student) {
        this.setDate(date);
        this.setProgram(program);
        this.setStudent(student);
    }
    public StudentProgram(int spId, String date, Program program, Student student) {
        this.setSpId(spId);
        this.setDate(date);
        this.setProgram(program);
        this.setStudent(student);
    }

    public int getSpId() {
        return spId;
    }
    public void setSpId(int spId) {
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
