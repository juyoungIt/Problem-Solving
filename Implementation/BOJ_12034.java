import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] prices = new long[2 * n];
            for(int j=0; j<2*n; j++) {
                prices[j] = Long.parseLong(st.nextToken());
            }
            List<Long> discounts = new ArrayList<>();
            Queue<Long> nonDiscount = new LinkedList<>();
            for (long price : prices) {
                if (!nonDiscount.isEmpty() && nonDiscount.peek() == price) {
                    nonDiscount.poll();
                } else {
                    discounts.add(price);
                    nonDiscount.offer(price * 4 / 3);
                }
            }
            sb.append("Case #").append(i).append(":");
            for (long val : discounts) {
                sb.append(" ").append(val);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}