package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import dto.StudentProgramDTO;

import java.util.ArrayList;

public interface RegisterStudentsBO extends SuperBO {
    public boolean addStudent(StudentDTO studentDTO);
    public boolean addStudentProgram(StudentProgramDTO studentProgramDTO);
    public ProgramDTO getProgram(String pId);
    public String getStudentId();
    public ArrayList<String> getProgramIds();
    public ArrayList<StudentProgramDTO> getStudentPrograms(String sId);
}
