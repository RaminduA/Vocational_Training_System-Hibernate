package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean add(Student student) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Student get(String id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
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
