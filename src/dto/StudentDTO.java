package dto;

import entity.SuperEntity;

import java.util.List;

public class StudentDTO implements SuperEntity {

    private String sId;
    private String name;
    private String dob;
    private String nic;
    private String address;
    private String contact;
    private String email;

    private List<StudentProgramDTO> details;

    public StudentDTO() {
    }

    public StudentDTO(String sId, String name, String dob, String nic, String address, String contact, String email) {
        this.setsId(sId);
        this.setName(name);
        this.setDob(dob);
        this.setNic(nic);
        this.setAddress(address);
        this.setContact(contact);
        this.setEmail(email);
    }

    public StudentDTO(String sId, String name, String dob, String nic, String address, String contact, String email, List<StudentProgramDTO> details) {
        this.setsId(sId);
        this.setName(name);
        this.setDob(dob);
        this.setNic(nic);
        this.setAddress(address);
        this.setContact(contact);
        this.setEmail(email);
        this.setDetails(details);
    }

    public String getsId() {
        return sId;
    }
    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<StudentProgramDTO> getDetails() {
        return details;
    }
    public void setDetails(List<StudentProgramDTO> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + getsId() + '\'' +
                ", name='" + getName() + '\'' +
                ", dob='" + getDob() + '\'' +
                ", nic='" + getNic() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", contact='" + getContact() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
