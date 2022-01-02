package bo.custom.impl;

import bo.custom.RegisterStudentsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.StudentDAO;
import dao.custom.StudentProgramDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;

public class RegisterStudentsBOImpl implements RegisterStudentsBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);
    StudentProgramDAO studentProgramDAO = (StudentProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTPROGRAM);

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
        return studentDAO.add(new Student(studentDTO.getsId(), studentDTO.getName(), studentDTO.getDob(), studentDTO.getNic(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getEmail()));
    }

    @Override
    public ProgramDTO getProgram(String pId) {
        Program program = programDAO.get(pId);
        return new ProgramDTO(program.getpId(), program.getName(), program.getDuration(), program.getFee());
    }
}
