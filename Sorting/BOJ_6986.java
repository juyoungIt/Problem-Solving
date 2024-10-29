// BOJ - 6986
// Problem Sheet - https://www.acmicpc.net/problem/6986

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[] scores = new double[N];
        for (int i=0 ; i<N ; i++) {
            scores[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(scores);

        double trimmedMean = getRoundValue(getTrimmedMean(scores, N, K));
        double adjustedMean = getRoundValue(getAdjustedMean(scores, N, K));
        System.out.printf("%.2f\n%.2f", trimmedMean, adjustedMean);

        br.close();
    }

    private static double getTrimmedMean(double[] scores, int N, int K) {
        double sum = 0.0;
        for (int i=K ; i<N-K ; i++) {
            sum += scores[i];
        }
        return sum / (N - 2 * K);
    }

    private static double getAdjustedMean(double[] scores, int N, int K) {
        double sum = 0.0;
        double leftAdjacentValue = scores[K], rightAdjacentValue = scores[N-K-1];
        for (int i=0 ; i<K ; i++) {
            scores[i] = leftAdjacentValue;
        }
        for (int i=N-1 ; i>=N-K ; i--) {
            scores[i] = rightAdjacentValue;
        }
        for (int i=0 ; i<N ; i++) {
            sum += scores[i];
        }
        return sum / N;
    }

    private static double getRoundValue(double value) {
        return (value * 1_000) / 1_000;
    }
}