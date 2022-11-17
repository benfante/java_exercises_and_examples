package com.javacourse.examples;

public class LoopExamples {
    
    public static void simpleWhileLoop() {
        int i = 0;
        while(i < 10) {
            System.out.println("i = " + i);
            i++;
        }
    }

    public static void loopWithBreak(int today) {
        for (int i = 1; i <= 31; i++) {
            System.out.println(i);
            if (i == today) {
                break;
            }
        }
        System.out.println("Exited");
    }

    public static void loopWithContinue(int today) {
        for (int i = 1; i <= 31; i++) {
            if (i % 5 == 0) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println("Exited");
    }

    public static int returnExample(int a) {
        if (a > 5) {
            System.err.println("Troppo grande");
            return -1;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        simpleWhileLoop();
        // loopWithBreak(18);
        // loopWithContinue(31);
    }
}