package lesson2_4.task1;

public class Dog extends Animal {
    int runLimit = 500;
    int swimLimit = 10;
    private static int dogCount = 0;

    //конструктор класса Dog
    public Dog(String name) {
        super(name);
        this.runLimit = 500;
        this.swimLimit = 10;
        this.canSwim = true; // собака умеет плавать
        dogCount++;
    }

    //реализация метода run
    @Override
    public void run(int length) {
        if (length <= runLimit) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать " + length + " м.");
        }
    }

    //реализация метода swim
    @Override
    public void swim(int length) {
        if (length <= swimLimit) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " не может проплыть " + length + " м.");

        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}