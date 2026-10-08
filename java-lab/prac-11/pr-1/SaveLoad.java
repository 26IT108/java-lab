import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println();
    }
}

public class SaveLoad {
    public static void main(String[] args) {

        Student[] students = {
                new Student(101, "Shivam", "abc123"),
                new Student(102, "Rahul", "xyz789"),
                new Student(103, "Priya", "pass456")
        };

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("students.dat"));

            out.writeObject(students);
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("students.dat"));

            Student[] loadedStudents = (Student[]) in.readObject();
            in.close();

            System.out.println("Loaded Data:\n");

            for (Student s : loadedStudents) {
                s.display();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}