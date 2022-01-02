package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;

import java.util.ArrayList;

public interface AddProgramsBO extends SuperBO {
    public boolean addProgram(ProgramDTO programDTO);
    public ArrayList<ProgramDTO> getAllPrograms();
}
