package bo;

import bo.custom.impl.AddProgramsBOImpl;
import bo.custom.impl.ManageProgramsBOImpl;
import bo.custom.impl.RegisterStudentsBOImpl;
import bo.custom.impl.ViewStudentsBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory==null) ? (boFactory=new BOFactory()) : boFactory;
    }

    public enum BOType{
        REGISTERSTUDENTS, ADDPROGRAMS, VIEWSTUDENTS, MANAGEPROGRAMS
    }

    public SuperBO getBO(BOType boType){
        switch(boType){
            case REGISTERSTUDENTS:
                return new RegisterStudentsBOImpl();
            case ADDPROGRAMS:
                return new AddProgramsBOImpl();
            case VIEWSTUDENTS:
                return new ViewStudentsBOImpl();
            case MANAGEPROGRAMS:
                return new ManageProgramsBOImpl();
            default:
                return null;
        }
    }
}
