package userinfoapp;

import userinfoapp.model.User;
import userinfoapp.service.UserParser;
import userinfoapp.service.FileHandler;
import userinfoapp.exception.InvalidDataException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Используем try-with-resources для Scanner, чтобы он автоматически закрывался
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ваши данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол):");
            String input = scanner.nextLine().trim(); // Используем trim для удаления лишних пробелов

            // Проверка на пустой ввод
            if (input.isEmpty()) {
                System.err.println("Ошибка: Введена пустая строка.");
                return;
            }

            try {
                // Парсим введённые данные в объект User
                User user = UserParser.parseUser(input);
                // Пишем данные в файл
                FileHandler.writeToFile(user);
                System.out.println("Данные успешно записаны.");
            } catch (InvalidDataException | IOException e) {
                System.err.println("Ошибка при обработке данных: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Ошибка при работе с консолью: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
