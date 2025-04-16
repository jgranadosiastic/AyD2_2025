package com.jgranados.driversproject.designpatterns.structural.adapter;

import com.jgranados.driversproject.designpatterns.structural.adapter.adapter.StudentCollectionAdapter;
import com.jgranados.driversproject.designpatterns.structural.adapter.adapter.StudentCollectionAdapterImpl;
import com.jgranados.driversproject.designpatterns.structural.adapter.adapter.ThirdpartySystemAdapter;
import com.jgranados.driversproject.designpatterns.structural.adapter.adapter.ThirdpartySystemAdapterImpl;
import com.jgranados.driversproject.designpatterns.structural.adapter.studentservice.StudentService;
import com.jgranados.driversproject.designpatterns.structural.adapter.thirdparty.ThirdpartySystem;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        ThirdpartySystem thirdpartySystem = new ThirdpartySystem();
        StudentCollectionAdapter studentCollectionAdapter = new StudentCollectionAdapterImpl();

        StudentService studentService = new StudentService();
        List<Student> students = studentService.getStudents();

        thirdpartySystem.processStudents(studentCollectionAdapter.adapt(students));


        //------------------------------------
        ThirdpartySystemAdapter thirdpartySystemAdapter = new ThirdpartySystemAdapterImpl();
        thirdpartySystemAdapter.processStudents(students);

    }


}
