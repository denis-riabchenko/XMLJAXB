package com.ryabchenko;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class EmployeesList {
    public static void main(String[] args) throws Exception {
        String xml = "http://alex.academy/xml/employees.xml";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xml);

        EmployeesTypeList employeesTypeList = (EmployeesTypeList)JAXBContext.newInstance(EmployeesTypeList.class)
                .createUnmarshaller().unmarshal(document);
        for (EmployeesTypeList.EmployeeType employeeType : employeesTypeList.getEmployeetype()) {
            System.out.printf("Employee ID: %s; First name: %s; Last Name: %s; Title: %s; Hire date: %s; Phone: %s; Email: %s;\n",
                    employeeType.getId(), employeeType.getFirstName(), employeeType.getLastName(),
                    employeeType.getTitle(), employeeType.getHiredate(), employeeType.getPhone(),
                    employeeType.getEmail());
        }
    }
}
