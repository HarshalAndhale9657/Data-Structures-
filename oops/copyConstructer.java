
public class copyConstructer {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "harshal";
        s1.roll = 123;

        s1.marks[0] = 100;
        s1.marks[1] = 80;
        s1.marks[2] = 90;

        Student s2 = new Student(s1);
        s2.password = "xyz";

        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // copy constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;

    }

    Student() {
        System.out.println("Constructor is called...");
        marks = new int[3];

    }

    Student(String name) {
        this.name = name;
        marks = new int[3];
        System.out.println("Constructor is called...");

    }
}
