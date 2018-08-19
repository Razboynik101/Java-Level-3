package DopDZ;
import java.io.Serializable;
public class Student implements Serializable {
    int age;
    public Student(int age) {
        this.age = age;
    }
    public void info() {
        System.out.println(age);
    }
}
