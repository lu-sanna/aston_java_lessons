package lesson2_3;
import java.time.LocalTime;

public class Park {
    private String parkName;
    private Attraction[] attractions;
    private int count;

    // Конструктор парка
    public Park(String parkName, int maxAttractions) {
        this.parkName = parkName;
        this.attractions = new Attraction[maxAttractions];
        this.count = 0;
    }

    // Геттеры для класса Park
    public String getParkName() {
        return parkName;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public int getCount() {
        return count;
    }




    // Внутренний класс Attraction
    public class Attraction {
        public String name;
        public LocalTime openingTime;
        public LocalTime closingTime;
        public double price;

        public Attraction(
                String name,
                LocalTime openingTime,
                LocalTime closingTime,
                double price
        ) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        // Геттеры для класса Attraction
        public String getName() {
            return name;
        }

        public LocalTime getOpeningTime() {
            return openingTime;
        }

        public LocalTime getClosingTime() {
            return closingTime;
        }

        public double getPrice() {
            return price;
        }


        public void printInfo() {
            System.out.println(name + ": " + openingTime + "-" + closingTime + ", " + price + " руб.");
        }
    }

    // Методы парка
    public void addAttraction(
            String name,
            LocalTime openTime,
            LocalTime closeTime,
            double price
    ) {
        if (count < attractions.length) {
            attractions[count] = new Attraction(name, openTime, closeTime, price);
            count++;
        }
    }

    public void printAll() {
        System.out.println("\nАттракционы парка '" + parkName + "':");
        for (int i = 0; i < count; i++) {
            attractions[i].printInfo();
        }
    }
}
