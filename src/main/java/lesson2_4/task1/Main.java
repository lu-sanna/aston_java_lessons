package lesson2_4.task1;

public class Main {
    public static void main(String[] args) {
        Dog dogBim = new Dog("Бим");
        Cat catSemen = new Cat("Семён");

        int minValue = 1;
        int maxValue = 550;
        int randomValue = minValue + (int) (Math.random() * (maxValue - minValue + 1));

        dogBim.run(randomValue);
        dogBim.swim(8);

        catSemen.run(randomValue);
        catSemen.swim(randomValue);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("----------------------");

        //-------------------------------------------------------------//
        Cat[] cats = new Cat[5]; // Создаем массив из 3 котов
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот " + (i + 1)); // Инициализируем котов
        }

        //-------------------------------------------------------------//
        FoodBowl bowl = new FoodBowl(45); // Создаем миску с едой

        for (int i = 0; i < cats.length; i++) {
            int foodTaken = bowl.getFood(10);
            cats[i].eat(foodTaken);
            if (i < cats.length - 1) {
                System.out.print("\nОсталось в миске " + bowl.getFood() + " --> ");
            }
        }

        for (Cat cat : cats) {
            if (cat.fullness) {
                System.out.println(cat.name + " сыт.");
            } else {
                System.out.println(cat.name + " голоден.");
            }

        }

        catSemen.eat(bowl.getFood(10));
        System.out.println("Осталось в миске " + bowl.getFood());
        bowl.addFood(10);
        catSemen.eat(bowl.getFood(10));
    }
}
