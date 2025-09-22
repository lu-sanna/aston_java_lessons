package lesson2_7_junit;

public class Factorial {
        public  static int factorial (int f) {
            if (f < 0) {
                throw new IllegalArgumentException ("Число должно быть целым и положительным.");
            }
            int n = 1;
            for (int i = 1; i <= f; i++) {
                n = n * i;
            }
            return n;
    }
}
