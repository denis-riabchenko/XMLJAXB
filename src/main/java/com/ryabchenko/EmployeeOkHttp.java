package com.ryabchenko;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.xml.bind.JAXBContext;
import java.io.StringReader;

public class EmployeeOkHttp {
    public static void main(String[] args) throws Exception {
        String xml = "http://alex.academy/xml/employee.xml";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(xml).get().build();
        StringReader stringReader = new StringReader((String)client.newCall(request).execute().body().string());
        EmployeesType employeesType = (EmployeesType)JAXBContext.newInstance(EmployeesType.class)
                .createUnmarshaller().unmarshal(stringReader);
        System.out.printf("Employee ID: %s\nFirst name: %s\nLast Name: %s\nTitle: %s\nHire date: %s\nPhone: %s\nEmail: %s",
                employeesType.employee.id, employeesType.employee.firstName, employeesType.employee.lastName,
                employeesType.employee.title, employeesType.employee.hiredate, employeesType.employee.phone,
                employeesType.employee.email);
    }
}
