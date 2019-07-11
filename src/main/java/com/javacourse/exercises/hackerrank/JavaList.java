package com.javacourse.exercises.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Solution of the Java List problem on HacherRank
 * https://www.hackerrank.com/challenges/java-list/
 * 
 * @author Lucio Benfante
 *
 */
public class JavaList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int initialSize = scan.nextInt();
        for(int i=0; i<initialSize; i++) {
            int value = scan.nextInt();
            list.add(value);
        }
        int q = scan.nextInt();
        for(int i=0; i < q; i++) {
            scan.nextLine();
            String operation = scan.nextLine();
            if ("Insert".equals(operation)) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            }
            if ("Delete".equals(operation)) {
                int index = scan.nextInt();
                list.remove(index);
            }
        }
        for(Integer curr:list) {
            System.out.print(curr);
            System.out.print(" ");
        }
        System.out.println();
        scan.close();
    }
}

