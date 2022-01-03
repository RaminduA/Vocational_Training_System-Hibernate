package bo.custom.impl;

import bo.custom.ManageProgramsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.StudentProgramDAO;
import dto.ProgramDTO;
import entity.Program;
import entity.StudentProgram;

import java.util.ArrayList;
import java.util.List;

public class ManageProgramsBOImpl implements ManageProgramsBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);
    StudentProgramDAO studentProgramDAO = (StudentProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTPROGRAM);

    @Override
    public boolean updateProgram(ProgramDTO programDTO) {
        return programDAO.update(new Program(programDTO.getId(), programDTO.getName(), programDTO.getDuration(), programDTO.getFee()));
    }

    @Override
    public boolean deleteProgram(String pId) {
        return programDAO.delete(pId);
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
