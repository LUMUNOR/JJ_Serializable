package ru.geekbrains.lesson3.homeWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.geekbrains.lesson3.task2.ToDo;

import java.io.*;
import java.util.List;

public class Program {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Дмитрий", 19, 3.84);

        System.out.println(student);

        try(FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(student);
            System.out.println("Объект Stusent сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("student.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Stusent десериализован.");
        }

        System.out.println(student);

        //** Запись в .jsone
        student = new Student("Дмитрий", 19, 3.84);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File("student.json"), student);

        // Чтение .jsone
        student = objectMapper.readValue(new File("student.json"), objectMapper.getTypeFactory().constructType(StudentE.class));
        System.out.println(student);


    }
}
