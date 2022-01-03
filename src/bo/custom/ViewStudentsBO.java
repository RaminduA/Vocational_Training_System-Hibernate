package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import model.StudentProgramTM;

import java.util.ArrayList;

public interface ViewStudentsBO extends SuperBO {
    public ArrayList<StudentDTO> getAllStudents();
    public ArrayList<StudentProgramTM> getAllStudentPrograms();
}
