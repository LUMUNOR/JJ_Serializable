package ru.geekbrains.lesson3.homeWork;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Дмитрий", 19, 3.84);

        System.out.println(student1);

        try(FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(student1);
            System.out.println("Объект Stusent сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("student.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student1 = (Student) objectInputStream.readObject();
            System.out.println("Объект Stusent десериализован.");
        }

        System.out.println(student1);




    }
}
