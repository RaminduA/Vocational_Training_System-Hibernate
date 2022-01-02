package bo.custom.impl;

import bo.custom.AddProgramsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import entity.Program;

import java.util.ArrayList;
import java.util.List;


public class AddProgramsBOImpl implements AddProgramsBO {
    ProgramDAO programDAO = (ProgramDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public boolean addProgram(ProgramDTO programDTO) {
        return programDAO.add(new Program(programDTO.getId(), programDTO.getName(), programDTO.getDuration(), programDTO.getFee()));
    }

    @Override
    public ArrayList<ProgramDTO> getAllPrograms() {
        List<Program> programList=programDAO.getAll();
        ArrayList<ProgramDTO> programs=new ArrayList<>();
        for(Program program : programList){
            programs.add(new ProgramDTO(program.getpId(), program.getName(), program.getDuration(), program.getFee()));
        }
        return programs;
    }
}
