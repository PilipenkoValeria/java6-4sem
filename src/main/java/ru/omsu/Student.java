package ru.omsu;

import java.util.Objects;

public class Student extends Human{
    private String faculty;

    public Student(String surname, String name, String patronymic, int age, String faculty) {
        super(surname, name, patronymic, age);
        if(faculty == null || faculty.length() < 1 ){
            throw new IllegalArgumentException("Ошибка! Получены неверные данные");
        }
        this.faculty = faculty;
    }

    public Student(Student student) {
        super(student.getSurname(), student.getName(), student.getPatronymic(), student.getAge());
        if(faculty == null || faculty.length() < 1){
            throw new IllegalArgumentException("Ошибка! Получены неверные данные");
        }
        this.faculty = student.getFaculty();
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return faculty.equals(student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
