package lesson2_6;


public class Student {
    private String name;
    private String group;
    private int course;
    private int [] grades;

// конструктор для создания нового студента
public Student(String name, String group, int course, int[] grades) {
    this.name = name;
    this.group = group;
    this.course = course;
    this.grades = grades;
}

    // геттер для получения имени
    public String getName() {
        return name;
    }

    // геттер для получения группы
    public String getGroup() {
        return group;
    }

    // геттер для получения курса
    public int getCourse() {
        return course;
    }

    // геттер для получения оценок
    public int[] getGrades() {
        return grades;
    }

    // сеттер для перевода на следующий курс
    public void setCourse(int course) {
        this.course = course;
    }

    // метод для расчета среднего балла
    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // метод для вывода информации о студенте
    public void printInfo() {
        System.out.println(name + " (группа: " + group + ", курс: " + course +
                ", средний балл: " + String.format("%.1f", getAverageGrade()) + ")");
    }
}
