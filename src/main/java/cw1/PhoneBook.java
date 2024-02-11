package cw1;

import java.util.*;

/**
 * @apiNote Реализуйте структуру телефонной книги с помощью HashMap.
 * Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
 * их необходимо считать, как одного человека с разными телефонами.
 * Вывод должен быть отсортирован по убыванию числа телефонов.
 */
class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    /**
     * @param name     Фамилия
     * @param phoneNum Номер
     * @apiNote Добавляет новую запись (Фамилия, Номер) если записи не существует,
     * или добавляет новый номер если запись уже есть.
     */
    public void add(String name, Integer phoneNum) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNum);
    }

    /**
     * @param name     Фамилия
     * @param phoneNum Номер
     * @apiNote Удаляет номер у существующей записи, или если номер был последний - удаляет запись.
     */
    public void delnum(String name, Integer phoneNum) {
        if (phoneBook.get(name).size() > 1) {
            phoneBook.computeIfPresent(name, (k, v) -> v).remove(phoneNum);
        } else {
            phoneBook.remove(name);
        }
    }

    /**
     * @param name Фамилия
     * @apiNote Удаляет запись со всеми номерами
     */
    public void delpers(String name) {
        phoneBook.remove(name);
    }

    /**
     * @param name Фамилия
     * @return Список номеров
     * @apiNote Возвращает список номеров по фамилии, при отсутствии записи возвращает пустой массив.
     */
    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else return new ArrayList<>();
    }

    /**
     * @return Телефонную книгу
     * @apiNote Выводит все записи от большего количества телефонов к меньшему
     */
    public static LinkedHashMap<String, ArrayList<Integer>> getPhoneBook() {
        LinkedHashMap<String, ArrayList<Integer>> sorted = new LinkedHashMap<>();
        ArrayList<Integer> len = new ArrayList<>(phoneBook.size());
        phoneBook.forEach((k, v) -> len.add(v.size()));
        Collections.sort(len);
        for (int i = len.size() - 1; i >= 0; i--) {
            for (Map.Entry<String, ArrayList<Integer>> entry : phoneBook.entrySet()) {
                String key = entry.getKey();
                ArrayList<Integer> value = entry.getValue();
                if (value.size() == len.get(i)) {
                    sorted.put(key, value);
                }
            }
        }
        return sorted;
    }
}

