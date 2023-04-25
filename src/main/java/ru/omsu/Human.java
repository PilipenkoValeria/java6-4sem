package ru.omsu;

import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int age;

    public Human(String surname, String name, String patronymic, int age) {
        if(surname == null || surname.length() < 1 || name == null || name.length() < 1 ||
                patronymic == null || patronymic.length() == 0 || age < 0){
            throw new IllegalArgumentException("Ошибка! Получены некорректные данные.");
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }
    public Human(Human human){
        surname = human.getSurname();
        name = human.getName();
        patronymic = human.getPatronymic();
        age = human.getAge();
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                surname.equals(human.surname) &&
                name.equals(human.name) &&
                patronymic.equals(human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, age);
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

}
