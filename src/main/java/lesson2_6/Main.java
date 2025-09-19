package lesson2_6;

import java.util.ArrayList;

public class Main {
    public static void printStudents(ArrayList<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getCourse() == course) {
                System.out.println(s.getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Нет студентов на этом курсе");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("\n---------Задача 1---------");
        // Создаем список студентов
        ArrayList<Student> students = new ArrayList<>();

        // добавление студентов
        students.add(new Student("Иван Иванов", "ИТ-12", 1, new int[]{5, 4, 5}));
        students.add(new Student("Петр Петров", "ИТ-13", 1, new int[]{3, 2, 2}));
        students.add(new Student("Мария Сидорова", "ИТ-14", 2, new int[]{4, 4, 5}));
        students.add(new Student("Анна Козлова", "ИТ-15", 1, new int[]{2, 3, 3}));

        System.out.println("Все студенты:");
        for (int i = 0; i < students.size(); i++) {
            students.get(i).printInfo();
        }

        printStudents(students, 1);

        // Удаление студентов с плохими оценками
        int i = 0;
        while (i < students.size()) {
            if (students.get(i).getAverageGrade() < 3) {
                students.remove(i);
            } else {
                i++;
            }
        }

        System.out.println("Хорошие студенты:");
        for (int j = 0; j < students.size(); j++) {
            students.get(j).printInfo();
        }

        // перевод на следующий курс
        for (int k = 0; k < students.size(); k++) {
            Student s = students.get(k);
            s.setCourse(s.getCourse() + 1);
        }

        System.out.println("\nПосле перевода:");
        for (int m = 0; m < students.size(); m++) {
            students.get(m).printInfo();
        }

        printStudents(students, 2);

        // Задание 2
        System.out.println("\n---------Задача 2---------");
        BookPhone phoneBook = new BookPhone();
        phoneBook.add("Иванов", "+123456789");
        phoneBook.add("Петров", "+987654321");
        phoneBook.add("Петров", "+555656777");
        phoneBook.add("Скворцов", "+567666777");

        System.out.println("Номера Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Номера Петров: " + phoneBook.get("Петров"));
        System.out.println("Номера Скворцов: " + phoneBook.get("Скворцов"));
    }
}

