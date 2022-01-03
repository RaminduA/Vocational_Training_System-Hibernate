package bo.custom.impl;

import bo.custom.ViewStudentsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.StudentDAO;
import dao.custom.StudentProgramDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import model.StudentProgramTM;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentsBOImpl implements ViewStudentsBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);
    StudentProgramDAO studentProgramDAO = (StudentProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTPROGRAM);

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        List<Student> studentList=studentDAO.getAll();
        ArrayList<StudentDTO> students=new ArrayList<>();
        if (studentList!=null) {
            for(Student student : studentList){
                students.add(new StudentDTO(student.getsId(), student.getName(), student.getDob(), student.getNic(), student.getAddress(), student.getContact(), student.getEmail()));
            }
            return students;
        }
        return null;
    }

    @Override
    public ArrayList<StudentProgramTM> getAllStudentPrograms() {
        return null;
    }
}
