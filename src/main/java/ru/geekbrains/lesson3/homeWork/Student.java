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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: ");
        sb.append(this.name);
        sb.append("\n Age: ");
        sb.append(this.age);
        sb.append("\n GPA: ");
        sb.append(this.gpa);
        return sb.toString();
    }
}
