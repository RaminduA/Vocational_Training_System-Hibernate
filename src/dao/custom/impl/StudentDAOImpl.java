package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean add(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.load(Student.class, id);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public String getId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*NativeQuery query=session.createSQLQuery("SELECT sId FROM Student");
        query.addEntity(Student.class);
        List<String> lastId = query.list();*/

        Query query=session.createSQLQuery("SELECT sId FROM Student");
        List<String> idList = query.list();

        transaction.commit();
        session.close();

        System.out.println(idList);
        return idList.size()==0? null:idList.get(idList.size()-1);
    }


    @Override
    public List<String> getAllIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createSQLQuery("SELECT sId FROM Student");
        List<String> idList = query.list();

        transaction.commit();
        session.close();

        System.out.println(idList);
        return idList.size()==0? null:idList;
    }
}
