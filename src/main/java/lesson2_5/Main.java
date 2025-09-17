package lesson2_5;
 //Исключение MyArraySizeException для неверного размера массива
class MyArraySizeException extends Exception {
     public MyArraySizeException(String message) {
         super(message);
     }
 }

//Исключение MyArrayDataException для неверных данных в массиве
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {

    public static void main(String[] args) {
        //корректный массив
        String[][] validData = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        //массив с неверными данными
        String[][] invalidData = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        //неверный размер массива
        String[][] sizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };

        //обработка корректного массива
        try {
            int sum = SumValidArray.sumValidArray(validData);
            System.out.println("Сумма всех элементов валидного массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //обработка массива с неверными данными
        try {
            int sum = SumValidArray.sumValidArray(invalidData);
            System.out.println("Сумма всех элементов невалидного массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Обработка массива неверного размера (столбцы)
        try {
            int sum = SumValidArray.sumValidArray(sizeArray);
            System.out.println("Сумма массива неверного размера: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // код для генерации и поимки ArrayIndexOutOfBoundsException.
        arrayIndexOutOfBounds();
    }
    private static void arrayIndexOutOfBounds() {
        System.out.println("\n---Демонстрация ArrayIndexOutOfBoundsException ---");

        int[] numbers = {1, 2, 3, 4, 5};

        try {
            System.out.println("Попытка доступа к numbers[-1]");
            int value = numbers[-1]; // Ошибка: отрицательный индекс
            System.out.println("Значение: " + value);

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Причина: отрицательный индекс недопустим");
        }
    }
}

    class SumValidArray {
        public static int sumValidArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
            int sum = 0;
            //проврка количества строк
            if (array.length != 4) {
                throw new MyArraySizeException("Ожидалось 4 строки, но получено: " + array.length);
            }

            //проверка количества столбцов в каждой строке
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException("Строка " + i + " должна содержать 4 элемента, но содержит: " + array[i].length);
                }
            }

            //суммирование элементов
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                    }
                }
            }

            return sum;
        }
    }

