package dz3.Task1;

import java.io.*;


public class Main {
    public static void main(String\[\] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Nick", 23);

        try(FileOutputStream fileOutputStream = new FileOutputStream("persondata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("persondata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            person = (Person)objectInputStream.readObject();
            System.out.println("Объект Person десериализован.");
            System.out.println("Имя: " + person.getName());
            System.out.println("Возраст: " + person.getAge());
        }
    }
}
