// BOJ - 8932
// Problem Sheet - https://www.acmicpc.net/problem/8932

import java.util.*;
import java.io.*;

public class Main {

    enum SportType {
        Track, Field
    }

    static class SportScoreInfo {
        private final double a;
        private final double b;
        private final double c;
        private final SportType sportType;

        public SportScoreInfo(double a, double b, double c, SportType sportType) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.sportType = sportType;
        }

        public double getA() { return this.a; }
        public double getB() { return this.b; }
        public double getC() { return this.c; }
        public SportType getSportType() { return this.sportType; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        SportScoreInfo[] sportScoreInfos = new SportScoreInfo[7];
        sportScoreInfos[0] = new SportScoreInfo(9.23076, 26.7, 1.835, SportType.Track);
        sportScoreInfos[1] = new SportScoreInfo(1.84523, 75, 1.348, SportType.Field);
        sportScoreInfos[2] = new SportScoreInfo(56.0211, 1.5, 1.05, SportType.Field);
        sportScoreInfos[3] = new SportScoreInfo(4.99087, 42.5, 1.81, SportType.Track);
        sportScoreInfos[4] = new SportScoreInfo(0.188807, 210, 1.41, SportType.Field);
        sportScoreInfos[5] = new SportScoreInfo(15.9803, 3.8, 1.04, SportType.Field);
        sportScoreInfos[6] = new SportScoreInfo(0.11193, 254, 1.88, SportType.Track);

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int totalScore = 0;
            for (int j=0 ; j<7 ; j++) {
                int record = Integer.parseInt(st.nextToken());
                totalScore += getScore(sportScoreInfos[j].getA(),
                        sportScoreInfos[j].getB(),
                        sportScoreInfos[j].getC(),
                        record,
                        sportScoreInfos[j].getSportType());
            }
            sb.append(totalScore).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getScore(double a, double b, double c, int p, SportType sportType) {
        if (sportType.equals(SportType.Track)) {
            return getTrackScore(a, b, c, p);
        }
        return getFieldScore(a, b, c, p);
    }

    private static int getTrackScore(double a, double b, double c, int p) {
        return (int) (a * Math.pow(b - p, c));
    }

    private static int getFieldScore(double a, double b, double c, int p) {
        return (int) (a * Math.pow(p - b, c));
    }
}