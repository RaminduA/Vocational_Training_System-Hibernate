package util;

import entity.Program;
import entity.Student;
import entity.StudentProgram;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfig;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        StandardServiceRegistry stg = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata = new MetadataSources(stg)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(StudentProgram.class).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfig==null) ? (factoryConfig=new FactoryConfiguration()) : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}