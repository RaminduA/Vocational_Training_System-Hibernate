package dao.custom.impl;

import dao.custom.StudentProgramDAO;
import entity.Program;
import entity.Student;
import entity.StudentProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class StudentProgramDAOImpl implements StudentProgramDAO {

    @Override
    public boolean add(StudentProgram studentProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(studentProgram);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(StudentProgram studentProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(studentProgram);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        StudentProgram studentProgram = session.load(StudentProgram.class, id);
        session.delete(studentProgram);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public StudentProgram get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        StudentProgram studentProgram = session.get(StudentProgram.class, id);

        transaction.commit();
        session.close();
        return studentProgram;
    }

    @Override
    public List<StudentProgram> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createQuery("FROM StudentProgram ");
        List<StudentProgram> studentProgramList = query.list();

        transaction.commit();
        session.close();
        return studentProgramList;
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
