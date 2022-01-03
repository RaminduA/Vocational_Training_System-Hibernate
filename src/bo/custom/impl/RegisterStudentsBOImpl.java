package bo.custom.impl;

import bo.custom.RegisterStudentsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.StudentDAO;
import dao.custom.StudentProgramDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import dto.StudentProgramDTO;
import entity.Program;
import entity.Student;
import entity.StudentProgram;

import java.util.ArrayList;
import java.util.List;

public class RegisterStudentsBOImpl implements RegisterStudentsBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);
    StudentProgramDAO studentProgramDAO = (StudentProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTPROGRAM);

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
        return studentDAO.add(new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getDob(), studentDTO.getNic(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getEmail()));
    }

    @Override
    public boolean isExistStudent(String studentId) {
        List<String> allIds = studentDAO.getAllIds();
        if (allIds!=null) {
            for (String id : allIds) {
                if (studentId.equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addStudentProgram(StudentProgramDTO studentProgramDTO) {
        return studentProgramDAO.add(new StudentProgram(studentProgramDTO.getDate(), programDAO.get(studentProgramDTO.getProgram().getId()), studentDAO.get(studentProgramDTO.getStudent().getId())));
    }

    @Override
    public StudentDTO getStudent(String sId) {
        Student student = studentDAO.get(sId);
        return new StudentDTO(student.getsId(), student.getName(), student.getDob(), student.getNic(), student.getAddress(), student.getContact(), student.getEmail());
    }

    @Override
    public ProgramDTO getProgram(String pId) {
        Program program = programDAO.get(pId);
        return new ProgramDTO(program.getpId(), program.getName(), program.getDuration(), program.getFee());
    }

    @Override
    public String getStudentId() {
        String lastId=studentDAO.getId();
        if (lastId!=null) {
            int index=Integer.parseInt(lastId.split("T")[1]);
            ++index;
            return (index<10)? "ST000"+index : (index<100)? "ST00"+index : (index<1000)? "ST0"+index : "ST"+index ;
        }else{
            return "ST0001";
        }
    }

    @Override
    public ArrayList<String> getProgramIds() {
        List<String> ids = programDAO.getAllIds();
        return new ArrayList<>(ids);
    }

    @Override
    public ArrayList<StudentProgramDTO> getStudentPrograms(String sId) {
        return null;
    }
}
