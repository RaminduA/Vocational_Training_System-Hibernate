package dao;

import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.StudentProgramDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){ }

    public static DAOFactory getInstance(){
        return (daoFactory==null) ? (daoFactory=new DAOFactory()) : daoFactory;
    }

    public enum DAOType{
        STUDENT, PROGRAM, STUDENTPROGRAM, QUERY
    }

    public SuperDAO getDAO(DAOType daoType){
        switch(daoType){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case STUDENTPROGRAM:
                return new StudentProgramDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
