package com.ryabchenko;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Employees {
    public static void main(String[] args) throws Exception {
        String xml = "http://alex.academy/xml/employee.xml";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xml);
        document.getDocumentElement().normalize();

        EmployeesType employeesType = (EmployeesType) JAXBContext.newInstance(EmployeesType.class)
                .createUnmarshaller().unmarshal(document);
        System.out.printf("Employee ID: %s\nFirst name: %s\nLast Name: %s\nTitle: %s\nHire date: %s\nPhone: %s\nEmail: %s",
                employeesType.employee.id, employeesType.employee.firstName, employeesType.employee.lastName,
                employeesType.employee.title, employeesType.employee.hiredate, employeesType.employee.phone,
                employeesType.employee.email);
    }
}
