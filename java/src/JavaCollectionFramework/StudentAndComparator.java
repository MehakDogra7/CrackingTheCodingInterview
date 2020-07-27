package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentAndComparator {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student("Vinayak", 1000, 23),
                new Student("Somnath", 1001, 23),
                new Student("A", 800, 23)
        ));

        Collections.sort(list, new CompareBasedOnRollNo());
        list.forEach(student -> {
            System.out.print(student.name + " " + student.rollNo + " " + student.age);
            System.out.println();
        });
    }

    static class Student {
        String name;
        long rollNo;
        Integer age;

        public Student(String name, long rollNo, Integer age) {
            this.name = name;
            this.rollNo = rollNo;
            this.age = age;
        }
    }

    static class CompareBasedOnRollNo implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.rollNo < s2.rollNo)
                return -1;
            else if (s1.rollNo > s2.rollNo)
                return 1;
            return 0;
        }
    }
}
