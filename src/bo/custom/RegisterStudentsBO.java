package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface RegisterStudentsBO extends SuperBO {
    public boolean addStudent(StudentDTO studentDTO);
    public ProgramDTO getProgram(String pId);
    //public ArrayList<ProgramDTO> getAll();
}
