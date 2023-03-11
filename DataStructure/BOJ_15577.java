// BOJ - 15577
// Problem Sheet - https://www.acmicpc.net/problem/15577

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Double> scores = new PriorityQueue<>();

        int numberOfScores = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfScores ; i++) {
            scores.add(Double.parseDouble(bf.readLine()));
        }

        while(scores.size() > 1) {
            double scoreA = scores.poll();
            double scoreB = scores.poll();
            scores.add(getAverage(scoreA, scoreB));
        }

        System.out.printf("%.6f\n", scores.poll());

        bf.close();
        System.exit(0);
    }

    static double getAverage(double scoreA, double scoreB) {
        return (scoreA + scoreB) / 2;
    }
}