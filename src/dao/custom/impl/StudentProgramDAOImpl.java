package dao.custom.impl;

import dao.custom.StudentProgramDAO;
import entity.StudentProgram;

import java.util.ArrayList;
import java.util.List;

public class StudentProgramDAOImpl implements StudentProgramDAO {

    @Override
    public boolean add(StudentProgram studentProgram) {
        return false;
    }

    @Override
    public boolean update(StudentProgram studentProgram) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public StudentProgram get(String id) {
        return null;
    }

    @Override
    public List<StudentProgram> getAll() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public List<String> getAllIds() {
        return null;
    }
}
