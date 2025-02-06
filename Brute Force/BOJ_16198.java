// BOJ - 16198
// Problem Sheet - https://www.acmicpc.net/problem/16198

import java.io.*;

public class Main {

    private static int N;
    private static int[] W;
    private static boolean[] isRemoved;
    private static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0);
        System.out.println(maxEnergy);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            W[i] = Integer.parseInt(row[i]);
        }
        isRemoved = new boolean[N];
        br.close();
    }

    private static void solve(int count, int energy) {
        if (count == N - 2) {
            maxEnergy = Math.max(maxEnergy, energy);
            return;
        }
        for (int i=1 ; i<N-1 ; i++) {
            if (!isRemoved[i]) {
                isRemoved[i] = true;
                solve(count + 1, energy + getLeftClosestElement(i) * getRightClosestElement(i));
                isRemoved[i] = false;
            }
        }
    }

    private static int getLeftClosestElement(int curIndex) {
        int leftClosestElement = -1;
        for (int i=curIndex-1 ; i>=0 ; i--) {
            if (!isRemoved[i]) {
                leftClosestElement = W[i];
                break;
            }
        }
        return leftClosestElement;
    }

    private static int getRightClosestElement(int curIndex) {
        int rightClosestElement = -1;
        for (int i=curIndex+1 ; i<N ; i++) {
            if (!isRemoved[i]) {
                rightClosestElement = W[i];
                break;
            }
        }
        return rightClosestElement;
    }
}