package com.jgranados.driversproject.designpatterns.structural.adapter.adapter;

import com.jgranados.driversproject.designpatterns.structural.adapter.Student;

import java.util.List;

public interface ThirdpartySystemAdapter {

    public void processStudents(List<Student> students);
}
