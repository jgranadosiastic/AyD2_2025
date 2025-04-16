package com.jgranados.driversproject.designpatterns.structural.adapter.adapter;

import com.jgranados.driversproject.designpatterns.structural.adapter.Student;

import java.util.List;

public class StudentCollectionAdapterImpl implements StudentCollectionAdapter {
    @Override
    public String[][] adapt(List<Student> students) {
        String[][] studentsThirdparty = new String[students.size()][2];
        for (int i = 0; i < students.size(); i++) {
            studentsThirdparty[i][0] = students.get(0).id();
            studentsThirdparty[i][1] = students.get(0).fullName();
        }

        return studentsThirdparty;
    }
}
