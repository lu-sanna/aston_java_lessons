package lesson2_4.task1;
public class Cat extends Animal {
    int runLimit = 250;
    private static int CatCount = 0;
    boolean  fullness;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.swimLimit = 0;
        this.canSwim = false; // Кот не умеет плавать

        CatCount++;
    }
    @Override
    public void run(int lenght) {
        if (lenght <= runLimit ) {
            System.out.println(name + " пробежал(а) " + lenght + " м.");
        } else {
            System.out.println(name + " не может пробежать " + lenght + " м.");
        }
    }

    @Override
    public void swim(int lenght) {
        System.out.println(name + " не умеет плавать" );
    }

    public static int getCatCount() {
        return CatCount;
    }


    //Метод eat позволяет коту покушать из миски. Если в миске достаточно еды, кот становится сытым (fullness = true)
    public void eat(int foodAmount) {
        if (foodAmount > 0 ) {
            fullness = true;
            System.out.print(name + " покушал из миски.");
        } else {
            fullness = false; // Помечаем кошку как голодную, если в миске недостаточно количества еды
            System.out.println(name + " не может покушать из миски, так как не хватает еды.");
        }
    }

}
