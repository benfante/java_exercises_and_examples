package com.javacourse.exercises.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Solution of the Arrays: Left Rotation exercise from HackerRank
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * 
 * @author Lucio Benfante
 *
 */
public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft1(int[] a, int d) {
        Deque<Integer> l = new LinkedList();
        for(int j = 0; j < a.length; j++) {
            l.add(a[j]);
        }
        for(int i = 0; i < d; i++) {
            l.add(l.removeFirst());
        }
        int j = 0;
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
            a[j++] = it.next();
        }
        return a;
    }

    static int[] rotLeft2(int[] a, int d) {
        int[] shifted = new int[d];
        for(int i = 0; i < d; i++) {
            shifted[i] = a[i];
            if (i+d < a.length) {
                a[i] = a[i+d];
            }
        }
        for(int i = d; i < a.length - d; i++) {
            a[i] = a[i+d];
        }
        for (int i = a.length - d; i < a.length; i++) {
            a[i] = shifted[i - a.length + d];
        }
        return a;
    }

    static int[] rotLeft(int[] a, int d) {
        for (int rot = 0; rot < d; rot++) {
            int tmp = a[0];
            for(int i = 1; i < a.length; i++) {
                a[i-1] = a[i];
            }
            a[a.length - 1] = tmp;
        } 
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
