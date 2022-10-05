package com.javacourse.exercises.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixLayerRotation {

    static void copyRing(List<List<Integer>> source, int ring, int rounds, List<List<Integer>> destination) {
        int width = source.get(0).size() - (2 * ring);
        int height = source.size() - (2 * ring);
        int elements = 2 * width + 2 * (height - 2);
        if (elements == 0)
            return;
        rounds = rounds % elements;
        Coordinates dest = new Coordinates(ring, ring, ring, ring, source.get(0).size() - ring - 1, source.size() - ring - 1);
        Coordinates src = new Coordinates(ring, ring, ring, ring, source.get(0).size() - ring - 1, source.size() - ring - 1);
        src.next(rounds);
        int i = 0;
        while (i < elements) {
            destination.get(dest.y).set(dest.x, source.get(src.y).get(src.x));
            dest.next();
            src.next();
            i++;
        }
    }

    // Complete the matrixRotation function below.
    @SuppressWarnings("unchecked")
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> result = new ArrayList<>(matrix.size());
        List<Integer> newLine = new ArrayList<>(matrix.get(0).size());
        for (int i = 0; i < matrix.get(0).size(); i++) {
            newLine.add(Integer.valueOf(0));
        }
        for (int i = 0; i < matrix.size(); i++) {
            result.add((List<Integer>) ((ArrayList<Integer>) newLine).clone());
        }
        int ring = 0;
        while (ring <= matrix.size() - ring - 1 && ring <= matrix.get(0).size() - ring -1) {
            copyRing(matrix, ring, r, result);
            ring++;
        }
        for (List<Integer> currentLine : result) {
            for (Integer value : currentLine) {
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }

    private static class Coordinates {
        int x, y;
        int minX, minY;
        int maxX, maxY;
        
        protected Coordinates(int x, int y, int minX, int minY, int maxX, int maxY) {
            this.x = x;
            this.y = y;
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
        }

        void next() {
            if (x < maxX) {
                if (y == minY) {
                    x++;
                    return;
                }
            }
            if (y < maxY) {
                if (x == maxX) {
                    y++;
                    return;
                }
            }
            if (x > minX) {
                if (y == maxY) {
                    x--;
                    return;
                }
            }
            if (y > minY) {
                if (x == minX) {
                    y--;
                    return;
                }
            }
        }

        void next(int n) {
            for(int i = 0; i < n; i++) {
                next();
            }
        }
    }
}
