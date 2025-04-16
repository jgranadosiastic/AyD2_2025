package com.jgranados.driversproject.designpatterns.structural.adapter.adapter;

import com.jgranados.driversproject.designpatterns.structural.adapter.Student;

import java.util.List;

public interface StudentCollectionAdapter {

    public String[][] adapt(List<Student> students);
}
