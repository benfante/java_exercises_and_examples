package com.javacourse.exercises.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Solution of the Balanced Brackets exercise from HackerRank
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * 
 * @author Lucio Benfante
 *
 */
public class BalancedBrackets {

    
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	int i = 0;
    	while(sb.length() > 0 && i < sb.length()) {
    		char c = sb.charAt(i);
    		if (c == '{' || c == '[' || c == '(') {
    			i++;
    		} else {
    			if (i == 0) {
    				return "NO";
    			}
    			char prev = sb.charAt(i-1);
    			if ((c == ')' && prev == '(') ||
    				(c == ']' && prev == '[') ||
    				(c == '}' && prev == '{')) {
    				sb.deleteCharAt(i);
    				sb.deleteCharAt(i-1);
    				i--;
    			} else {
    				return "NO";
    			}
    		}
    	}
    	if (sb.length() == 0) {
    		return "YES";
    	}
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
