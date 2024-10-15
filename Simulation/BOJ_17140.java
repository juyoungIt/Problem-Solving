// BOJ - 17140
// Problem Sheet - https://www.acmicpc.net/problem/17140

import java.util.*;
import java.io.*;

public class Main {

    private static int r, c, k;
    private static final int[][] A = new int[101][101];
    private static int rSize = 3, cSize = 3;

    static class Number implements Comparable<Number> {
        private final int value;
        private int count;

        public Number(int value) {
            this.value = value;
            this.count = 0;
        }

        public int getValue() { return this.value; }
        public int getCount() { return this.count; }
        public void addCount() { this.count++; }

        @Override
        public int compareTo(Number n) {
            if (this.count == n.getCount()) {
                return this.value - n.getValue();
            }
            return this.count - n.getCount();
        }
    }

    public static void main(String[] args) throws IOException {
        getInput();
        int time = 0;
        boolean isValid = false;
        while (true) {
            if (time > 100) {
                break;
            }
            if (A[r][c] == k) {
                isValid = true;
                break;
            }
            process();
            time++;
        }
        System.out.println(isValid ? time : -1);
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i=0 ; i<=3 ; i++) {
            if (i == 0) {
                Arrays.fill(A[i], 1, 4, 3);
                continue;
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<=3 ; j++) {
                if (j == 0) {
                    A[i][j] = 3;
                    continue;
                }
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static void process() {
        if (rSize >= cSize) {
            processR();
        } else {
            processC();
        }
    }

    private static void processR() {
        for (int i=1 ; i<=rSize ; i++) {
            int[] sortedRow = getSortedArray(A[i]);
            System.arraycopy(sortedRow, 0, A[i], 0, sortedRow.length);
            cSize = Math.max(cSize, sortedRow[0]);
        }
    }

    private static void processC() {
        for (int i=1 ; i<=cSize ; i++) {
            int[] col = new int[101];
            for (int j=0 ; j<=100 ; j++) {
                col[j] = A[j][i];
            }
            int[] sortedRow = getSortedArray(col);
            for (int j=0 ; j<sortedRow.length ; j++) {
                A[j][i] = sortedRow[j];
            }
            rSize = Math.max(rSize, sortedRow[0]);
        }
    }

    private static int[] getSortedArray(int[] src) {
        List<Number> numbers = getCountList(src);
        Collections.sort(numbers);

        int[] result = new int[100];
        int index = 1;
        result[0] = Math.min(100, numbers.size() * 2);
        for (Number number : numbers) {
            if (index > 100) break;
            result[index++] = number.getValue();
            result[index++] = number.getCount();
        }
        return result;
    }

    private static List<Number> getCountList(int[] src) {
        Map<Integer, Number> numberMap = new HashMap<>();
        for (int i=1 ; i<src.length ; i++) {
            if (src[i] == 0) continue;
            if (!numberMap.containsKey(src[i])) {
                numberMap.put(src[i], new Number(src[i]));
            }
            numberMap.get(src[i]).addCount();
        }
        return new ArrayList<>(numberMap.values());
    }
}