package userinfoapp.service;

import userinfoapp.model.User;
import userinfoapp.exception.InvalidDataException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserParser {

    public static User parseUser(String input) throws InvalidDataException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidDataException("Входные данные не могут быть пустыми.");
        }

        String[] parts = input.trim().split("\\s+"); // Разделение строки на части с учётом возможных нескольких пробелов
        if (parts.length != 6) {
            throw new InvalidDataException("Некорректное количество данных. Ожидается 6 параметров.");
        }

        String surname = parts[0];
        String name = parts[1];
        String middleName = parts[2];
        LocalDate dateOfBirth = parseDate(parts[3]);
        long phoneNumber = parsePhoneNumber(parts[4]);
        char gender = parseGender(parts[5]);

        return new User(surname, name, middleName, dateOfBirth, phoneNumber, gender);
    }

    private static LocalDate parseDate(String dateStr) throws InvalidDataException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDataException("Неверный формат даты. Используйте формат dd.MM.yyyy.");
        }
    }

    private static long parsePhoneNumber(String phoneNumberStr) throws InvalidDataException {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона. Ожидается целое число.");
        }
    }

    private static char parseGender(String genderStr) throws InvalidDataException {
        if (genderStr == null || genderStr.length() != 1 || !(genderStr.equalsIgnoreCase("f") || genderStr.equalsIgnoreCase("m"))) {
            throw new InvalidDataException("Неверный формат пола. Ожидается 'f' или 'm'.");
        }
        return genderStr.toLowerCase().charAt(0);
    }
}
