package lesson2_4.task1;

public abstract class Animal {
    static int animalCount = 0; //счётчик животных
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected boolean canSwim;

    // Конструктор класса Animal
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int length);
    public abstract void swim(int length);
    public static int getAnimalCount() {
        return animalCount;
    }
}

