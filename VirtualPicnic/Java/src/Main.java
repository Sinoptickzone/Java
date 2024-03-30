import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Ваш файл `input.txt` содержит множество слов, разделенных
 * пробелами. Это слова-фрукты, овощи и другие продукты.
 * Представьте, что это ваш виртуальный пикник! 🍎🥕🥧🍇🍉
 * Задания:
 * 1. Осуществить подсчет слов:
 * Напишите программу, которая подсчитывает количество слов в
 * файле `input.txt`.
 * 2. Найти самое длинное слово:
 * Создайте программу, которая находит самое длинное слово в
 * файле.
 * 3. Вычислить частоту слов:
 * Напишите программу, которая анализирует, сколько раз каждое
 * слово встречается в файле. Подумайте об этом как о подсчете того,
 * какие фрукты и овощи самые популярные на вашем пикнике!
 */

public class Main {
    // Метод для подсчета общего количества слов
    public static int wordCount(Map<String, Integer> map) {
        // получаем коллекцию значений из map, получаем stream, суммируем количество элементов
        return map
                .values()
                .stream()
                .reduce(0, Integer::sum);
    }

    // Метод для нахождения самого длинного слова
    public static Optional<String> findLongestWord(Map<String, Integer> map) {
        // получаем множество ключей из map, получаем stream, находим максимальный по длине элемент
        return map
                .keySet()
                .stream()
                .max(Comparator.comparingInt(String::length));
    }

    public static void main(String[] args) {
        String fileName = "resources/input.txt"; // имя файла
        Map<String, Integer> wordMap = new HashMap<>(); // карта для хранения пар: слово-количество

        // создаём сканнер для чтения из файла
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            // пока есть, что читать
            while (fileScanner.hasNext()) {
                String word = fileScanner.next(); // читаем следующее слово
                // добавляем слово в map, обновляем количество
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word) + 1);
                } else {
                    wordMap.put(word, 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // выводим общее количество слов, самое длинное слово и map в консоль
        System.out.println(wordCount(wordMap));
        System.out.println(findLongestWord(wordMap).get());
        System.out.println(wordMap);
    }
}
