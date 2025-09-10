package lesson2_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("== ЗАДАНИЕ 1 ==");
        printThreeWords();


        System.out.println("\n== ЗАДАНИЕ 2 ==");
        checkSumSign();


        System.out.println("\n== ЗАДАНИЕ 3 ==");
        printColor();


        System.out.println("\n== ЗАДАНИЕ 4 ==");
        compareNumbers();


        System.out.println("\n== ЗАДАНИЕ 5 ==");
        System.out.println(isSumInRange(10, 5));


        System.out.println("\n== ЗАДАНИЕ 6 ==");
        checkNumberSign(0);


        System.out.println("\n== ЗАДАНИЕ 7 ==");
        System.out.println(isNegative(0));


        System.out.println("\n== ЗАДАНИЕ 8 ==");
        printString ("Hello, Java!",3);


        System.out.println("\n== ЗАДАНИЕ 9 ==");
        System.out.println(isLeapYear(2020));


        System.out.println("\n== ЗАДАНИЕ 10 ==");
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1};
        printArray(array10);


        System.out.println("\n== ЗАДАНИЕ 11 ==");
        int[] arr = new int[100];
        arrayValues (arr);

        System.out.println("\n== ЗАДАНИЕ 12 ==");
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        modifyArray(array12);


        System.out.println("\n== ЗАДАНИЕ 13 ==");
        int[][] matrix = new int[5][5];
        fillDiagonals(matrix);


        System.out.println("\n== ЗАДАНИЕ 14 ==");
        createArray(5, 10);
    }

    // ========== ЗАДАНИЕ 1 ==========
    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple  ");
    }

    // ========== ЗАДАНИЕ 2 ==========
    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // ========== ЗАДАНИЕ 3 ==========
    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // ========== ЗАДАНИЕ 4 ==========
    public static void compareNumbers() {
        int a = 10;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // ========== ЗАДАНИЕ 5 ==========
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // ========== ЗАДАНИЕ 6 ==========
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // ========== ЗАДАНИЕ 7 ==========
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // ========== ЗАДАНИЕ 8 ==========
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // ========== ЗАДАНИЕ 9 ==========
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // ========== ЗАДАНИЕ 10 ==========
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            System.out.print((array[i]) + " ");
        }
    }

    // ========== ЗАДАНИЕ 11 ==========
    public static void arrayValues(int[] arr) {
        for (int i = 0; i< arr.length;i++){
            arr [i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    // ========== ЗАДАНИЕ 12 ==========
    public static void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
                System.out.print(array[i] + " ");
            }
        }
    }

    // ========== ЗАДАНИЕ 13 ==========
    public static void fillDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ========== ЗАДАНИЕ 14 ==========
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        return array;
    }
}

