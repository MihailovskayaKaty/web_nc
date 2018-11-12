package bean.employee;

import java.time.LocalDate;

public class Employee {
    private int idworkers;
    private String surname;
    private String name;
    private String lastName;
    private String sex;
    private String address;
    private String post;
    private LocalDate birthDate;

    public Employee() {
    }

    public int getIdworkers() {
        return idworkers;
    }

    public void setIdworkers(int idworkers) {
        this.idworkers = idworkers;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
