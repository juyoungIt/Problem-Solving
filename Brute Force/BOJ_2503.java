// BOJ - 2503
// Problem Sheet - https://www.acmicpc.net/problem/2503

import java.io.*;

public class Main {

    private static int N;
    private static int[][] Q;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Q = new int[N][3];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            Q[i][0] = Integer.parseInt(row[0]);
            Q[i][1] = Integer.parseInt(row[1]);
            Q[i][2] = Integer.parseInt(row[2]);
        }
        br.close();
    }

    private static int solve() {
        int caseCount = 0;
        for (int i=1 ; i<10 ; i++) {
            for (int j=1 ; j<10 ; j++) {
                if (i == j) continue;
                for (int k=1 ; k<10 ; k++) {
                    if (i == k || j == k) continue;
                    int src = i * 100 + j * 10 + k;
                    boolean isValid = true;
                    for (int l=0 ; l<N ; l++) {
                        if (!isValid(src, Q[l][0], Q[l][1], Q[l][2])) {
                            isValid = false;
                            break;
                        }
                    }
                    caseCount += isValid ? 1 : 0;
                }
            }
        }
        return caseCount;
    }

    private static boolean isValid(int src, int candidate, int strike, int ball) {
        int s = checkStrike(src, candidate);
        int b = checkBall(src, candidate);
        return s == strike && b == ball;
    }

    private static int checkStrike(int src, int candidate) {
        int strike = 0;
        char[] srcDigits = Integer.toString(src).toCharArray();
        char[] candidateDigits = Integer.toString(candidate).toCharArray();
        for (int i=0 ; i<3 ; i++) {
            if (srcDigits[i] == candidateDigits[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int checkBall(int src, int candidate) {
        int ball = 0;
        char[] srcDigits = Integer.toString(src).toCharArray();
        char[] candidateDigits = Integer.toString(candidate).toCharArray();
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                if (srcDigits[i] == candidateDigits[j] && i != j) {
                    ball++;
                }
            }
        }
        return ball;
    }
}