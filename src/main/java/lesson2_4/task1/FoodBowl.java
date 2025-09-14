package lesson2_4.task1;

public class FoodBowl {
    private int foodAmount; // количество еды в миске

    //Конструктор миски
    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    //получение текущего количества еды
    public int getFood() {
        return foodAmount;
    }

    //добавление еды в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
        }
    }

    //Метод позволяет кушать из миски
    public int getFood(int countFood) {
        if (foodAmount >= countFood) {
            foodAmount -= countFood;
            return countFood;
        } else {
            foodAmount = 0;
            return 0; // Возвращаем 0, если в миске недостаточно еды
        }
    }
}
