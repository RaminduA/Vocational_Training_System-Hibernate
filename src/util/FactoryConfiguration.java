package util;

import entity.Program;
import entity.Student;
import entity.StudentProgram;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfig;
    private final SessionFactory factory;

    private FactoryConfiguration(){
        factory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(StudentProgram.class).buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfig==null) ? (factoryConfig=new FactoryConfiguration()) : factoryConfig;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
