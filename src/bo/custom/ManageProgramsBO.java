package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;

import java.util.ArrayList;

public interface ManageProgramsBO extends SuperBO {
    public boolean updateProgram(ProgramDTO programDTO);
    public boolean deleteProgram(String pId);
    public ArrayList<ProgramDTO> getAllPrograms();
}
