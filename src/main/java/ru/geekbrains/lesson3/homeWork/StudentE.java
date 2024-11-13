package ru.geekbrains.lesson3.homeWork;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class StudentE implements Externalizable {
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(gpa);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        gpa = in.readDouble();
    }

    //region Поля
    public String name;
    public int age;
    transient double gpa;

    public StudentE (String name, int age, double gpa){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    //endregion

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
