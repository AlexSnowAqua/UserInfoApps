package userinfoapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String surname;
    private String name;
    private String middleName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private char gender;

    // Конструктор
    public User(String surname, String name, String middleName, LocalDate dateOfBirth, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    // Геттеры для всех полей
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getMiddleName() { return middleName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public long getPhoneNumber() { return phoneNumber; }
    public char getGender() { return gender; }

    // Переопределение метода toString для удобного вывода данных
    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", surname, name, middleName, dateOfBirth, phoneNumber, gender);
    }

    // Переопределение equals и hashCode для сравнения объектов User
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber &&
               gender == user.gender &&
               Objects.equals(surname, user.surname) &&
               Objects.equals(name, user.name) &&
               Objects.equals(middleName, user.middleName) &&
               Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, middleName, dateOfBirth, phoneNumber, gender);
    }
}
