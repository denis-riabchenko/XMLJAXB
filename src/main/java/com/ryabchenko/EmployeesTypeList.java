package com.ryabchenko;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "employees")
public class EmployeesTypeList {
    @XmlElement(name = "employee")
    List<EmployeeType> employees = new ArrayList<EmployeeType>();
    List<EmployeeType> getEmployeetype() {
        return employees;
    }
    public static class EmployeeType {
        @XmlAttribute(name = "id")  String id;
        String getId() {
            return id;
        }
        @XmlElement(name = "firstname") String firstName;
        String getFirstName() {
            return firstName;
        }
        @XmlElement(name = "lastname") String lastName;
        String getLastName() {
            return lastName;
        }
        @XmlElement(name = "title") String title;
        String getTitle() {
            return title;
        }
        @XmlElement(name = "hiredate") String hiredate;
        String getHiredate() {
            return hiredate;
        }
        @XmlElement(name = "phone") String phone;
        String getPhone() {
            return phone;
        }
        @XmlElement(name = "email") String email;
        String getEmail() {
            return email;
        }
    }

}
