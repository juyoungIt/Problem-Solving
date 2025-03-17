// BOJ - 5092
// Problem Sheet - https://www.acmicpc.net/problem/5092

import java.util.*;
import java.io.*;

public class Main {
    
	static class Product {
		private final String name;
		private final int point;
		private final int deliveryDate;

		public Product(String name, int point, int deliveryDate) {
			this.name = name;
			this.point = point;
			this.deliveryDate = deliveryDate;
		}

		public String getName() { return this.name; }
		public int getPoint() { return this.point; }
		public int getDeliveryDate() { return this.deliveryDate; }
	}

	private static final String REPORT_FORMAT = "Number of discontented customers is: %d";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			Map<String, Product> products = new HashMap<>();
			for (int i=0 ; i<N ; i++) {
				String[] row = br.readLine().split(" ");
				String name = row[0];
				int point = Integer.parseInt(row[1]);
				int deliveryDate = Integer.parseInt(row[2]);
				products.put(name, new Product(name, point, deliveryDate));
			}
			int C = Integer.parseInt(br.readLine());
			int discontentedCount = 0;
			for (int i=0 ; i<C ; i++) {
				int totalPoint = 0;
				boolean isDiscontented = false;
				String[] row = br.readLine().split(" ");
				String customerNumber = row[0];
				int P = Integer.parseInt(row[1]);
				int M = Integer.parseInt(row[2]);
				for (int j=0 ; j<P ; j++) {
					String name = br.readLine();
					if (products.get(name).getDeliveryDate() > M) {
						isDiscontented = true;
					} else {
						totalPoint += products.get(name).getPoint();
					}
				}
				sb.append(String.format("%s %d", customerNumber, totalPoint));
				if (isDiscontented) {
					sb.append(" *");
					discontentedCount++;
				}
				sb.append("\n");
			}
			sb.append(String.format(REPORT_FORMAT, discontentedCount)).append("\n");
		}

		System.out.println(sb);
		br.close();
    }
}
