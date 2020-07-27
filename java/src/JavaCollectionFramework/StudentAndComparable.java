package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentAndComparable {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student("Vinayak", 1000, 23),
                new Student("Somnath", 1001, 23),
                new Student("A", 800, 23)
        ));

        Collections.sort(list);
        list.forEach(student -> {
            System.out.print(student.name + " " + student.rollNo + " " + student.age);
            System.out.println();
        });
        System.out.println();

        List<Student> efficient = new ArrayList<>(List.of(
                new Student("Vinayak", 1000, 23),
                new Student("Somnath", 1001, 23),
                new Student("A", 800, 23)
        ));

        efficient.sort(Student::compareTo);
        efficient.forEach(student -> {
            System.out.print(student.name + " " + student.rollNo + " " + student.age);
            System.out.println();
        });
    }

    static class Student implements Comparable<Student> {
        String name;
        long rollNo;
        Integer age;

        public Student(String name, long rollNo, Integer age) {
            this.name = name;
            this.rollNo = rollNo;
            this.age = age;
        }

        @Override
        public int compareTo(Student s1) {
            if (this.rollNo < s1.rollNo)
                return -1;
            else if (this.rollNo > s1.rollNo)
                return 1;
            return 0;
        }
    }
}
