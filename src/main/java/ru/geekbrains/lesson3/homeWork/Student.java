package ru.geekbrains.lesson3.homeWork;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public int age;
    transient double gpa;

    public Student (String name, int age, double gpa){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "\nName: " +
                this.name +
                "\n Age: " +
                this.age +
                "\n GPA: " +
                this.gpa;
    }
}
