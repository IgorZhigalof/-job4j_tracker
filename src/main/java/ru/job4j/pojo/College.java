package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setGroup("1");
        student.setDateOfAdmission("01-09-2003");
        student.setName("Andrew");
        student.setSurname("Korobka");
        student.setPatronymic("Dmitrievich");
        System.out.println(student.getName()
                            + System.lineSeparator() + student.getSurname()
                            + System.lineSeparator() + student.getPatronymic()
                            + System.lineSeparator() + student.getGroup()
                            + System.lineSeparator() + student.getDateOfAdmission());

    }
}
