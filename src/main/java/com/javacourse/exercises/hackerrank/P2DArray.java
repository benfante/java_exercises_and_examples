package com.javacourse.exercises.hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Solution of the 2D Array problem on HacherRank
 * https://www.hackerrank.com/challenges/2d-array/
 * 
 * @author Lucio Benfante
 *
 */
public class P2DArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] pattern = new int[][] {{1, 1, 1}, {0, 1, 0}, {1, 1, 1}};
        int result = Integer.MIN_VALUE;

        for(int yStart = 0; yStart <= arr.length - pattern.length; yStart++) {
            for(int xStart = 0; xStart <= arr[0].length - pattern[0].length; xStart++) {
                int sum = 0;
                for(int i = 0; i < pattern.length; i++) {
                    for(int j = 0; j < pattern[i].length; j++) {
                        sum += (arr[yStart+i][xStart+j] * pattern[i][j]);
                    }
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
