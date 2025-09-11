package lesson2_3;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Product[] productsArr = new Product[5];
        productsArr[0] = new Product(
                "Xiaomi Redmi Note 13",
                LocalDate.of(2024, 1, 10),
                "Xiaomi",
                "China",
                24999.0,
                true
        );
        productsArr[1] = new Product(
                "iPhone 16 Pro",
                LocalDate.of(2024, 9, 15),
                "Apple Inc.",
                "USA",
                6999.0,
                false
        );

        productsArr[2] = new Product(
                "Xiaomi Mi 14",
                LocalDate.of(2024, 1, 20),
                "Xiaomi",
                "China",
                3999.0,
                true
        );

        productsArr[3] = new Product(
                "Google Pixel 8",
                LocalDate.of(2023, 10, 5),
                "Google LLC",
                "USA",
                4599.0,
                false
        );

        productsArr[4] = new Product(
                "Huawei P60 Pro",
                LocalDate.of(2023, 3, 23),
                "Huawei Technologies",
                "China",
                4899.0,
                true
        );

        System.out.println("ВСЕ ТОВАРЫ В МАССИВЕ");
        for (int i = 0; i < productsArr.length; i++) {
            System.out.println("\nТовар #" + (i + 1) + ":");
            productsArr[i].printInfo();
        }

        Park myPark = new Park("Солнечный",5);
        // Добавляем аттракционы в парк
        myPark.addAttraction("Американские горки",
                LocalTime.of(10, 0),  // время открытия
                LocalTime.of(20, 0),  // время закрытия
                500.0);               // стоимость

        myPark.addAttraction("Водные горки",
                LocalTime.of(11, 0),
                LocalTime.of(19, 0),
                450.0);


        myPark.addAttraction("Колесо обозрения",
                LocalTime.of(9, 30),
                LocalTime.of(22, 0),
                300.0);


        //выводим все аттракционы и информацию о них
        myPark.printAll();
    }
}
