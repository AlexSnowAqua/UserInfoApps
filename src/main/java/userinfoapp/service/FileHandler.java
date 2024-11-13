package userinfoapp.service;

import userinfoapp.model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static void writeToFile(User user) throws IOException {
        // Генерация имени файла на основе фамилии
        String filename = user.getSurname() + ".txt";

        // Указание папки для хранения данных
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs(); // Создаем директорию, если ее нет
        }

        // Создание пути к файлу
        File file = new File(directory, filename);

        // Формирование строки данных
        String line = String.format("%s %s %s %s %d %c", user.getSurname(), user.getName(), user.getMiddleName(),
                user.getDateOfBirth(), user.getPhoneNumber(), user.getGender());

        // Запись данных в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(line);
            writer.newLine(); // Добавление новой строки
        } catch (IOException e) {
            // Обработка ошибок при записи в файл
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;  // Повторно выбрасываем исключение
        }
    }
}
