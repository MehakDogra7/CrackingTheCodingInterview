package CollegeAssignments.Java.Activity1;

import java.time.LocalDate;

public class IdGenerator {

    private static int ID_COUNTER = 1;
    private int currYear = 0;

    public IdGenerator(final int currYear) {
        this.currYear = currYear;
    }

    public String getNextId(final LocalDate date) {
        if (date.getYear() != currYear) ID_COUNTER = 1;
        currYear = date.getYear();

        String temp = String.valueOf(ID_COUNTER++);
        temp = "0".repeat(6 - temp.length()) + temp;
        return date.getYear() + "-" + temp;
    }
}

class IdGeneratorUtilTest {

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator(1970);
        System.out.println(idGenerator.getNextId(getYear(2019, 3, 1)));
        System.out.println(idGenerator.getNextId(getYear(2019, 2, 28)));
        System.out.println(idGenerator.getNextId(getYear(2020, 4, 5)));
        System.out.println(idGenerator.getNextId(getYear(2021, 9, 1)));
        System.out.println(idGenerator.getNextId(getYear(2021, 12, 31)));
    }

    public static LocalDate getYear(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
