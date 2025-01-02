// BOJ - 10383
// Problem Sheet - https://www.acmicpc.net/problem/10383

import java.io.*;
import java.util.Arrays;

public class Main {

    private static final String OUTPUT_FORMAT = "Site %d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int seq = 1;
        while (true) {
            int productCount = Integer.parseInt(br.readLine());
            if (productCount == 0) break;
            int inputCount = 0;
            String[] before = new String[productCount];
            while (inputCount < productCount) {
                String[] products = br.readLine().split(" ");
                for (String product : products) {
                    before[inputCount++] = product;
                }
            }
            String[] after = new String[productCount];
            System.arraycopy(before, 0, after, 0, productCount);
            Arrays.sort(after);

            int totalDist = 0;
            for (int i=0 ; i<productCount ; i++) {
                int afterIndex = searchTargetIndex(after, before[i]);
                totalDist += Math.abs(afterIndex - i);
            }
            sb.append(String.format(OUTPUT_FORMAT, seq++, totalDist));
        }

        System.out.println(sb);
        br.close();
    }

    private static int searchTargetIndex(String[] arr, String target) {
        int start = 0;
        int end = arr.length - 1;
        int targetIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int diffCode = arr[mid].compareTo(target);
            if (diffCode == 0) {
                targetIndex = mid;
                break;
            } else if (diffCode < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return targetIndex;
    }
}