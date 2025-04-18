// BOJ - 7800
// Problem Sheet - https://www.acmicpc.net/problem/7800

import java.util.*;
import java.io.*;

public class Main {

	static class SubMatrix implements Comparable<SubMatrix> {
		private int startX;
		private int startY;
		private Set<Integer> elementSet;

		public SubMatrix(int startX, int startY) {
			this.startX = startX;
			this.startY = startY;
			this.elementSet = new HashSet<>();
		}

		public int getStartX() { return this.startX; }
		public int getStartY() { return this.startY; }
		public int getUniqueElementCount() { return this.elementSet.size(); }
		public Set<Integer> getElementSet() { return this.elementSet; }
		public void addElement(int element) { this.elementSet.add(element); }
		
		@Override
		public int compareTo(SubMatrix sm) {
			if (this.getUniqueElementCount() == sm.getUniqueElementCount()) {
				List<Integer> elementsA = new ArrayList<>(elementSet);
				List<Integer> elementsB = new ArrayList<>(sm.getElementSet());
				for (int i=0 ; i<elementsA.size() ; i++) {
					if (elementsA.get(i) == elementsB.get(i)) continue;
					return elementsB.get(i) - elementsA.get(i);
				}
				if (this.startY == sm.getStartY()) {
					return this.startX - sm.getStartX();
				}
				return this.startY - sm.getStartY();
			}
			return this.getUniqueElementCount() - sm.getUniqueElementCount();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();
			if (input == null) break;
			String[] row = input.split(" ");
			int n = Integer.parseInt(row[0]);
			int m = Integer.parseInt(row[1]);
			int[][] matrix = new int[n][n];
			for (int i=0 ; i<n ; i++) {
				row = br.readLine().split(" ");
				for (int j=0 ; j<n ; j++) {
					matrix[i][j] = Integer.parseInt(row[j]);
				}
			}
			PriorityQueue<SubMatrix> subMatrices = new PriorityQueue<>();
			for (int i=0 ; i<=n-m ; i++) {
				for (int j=0 ; j<=n-m ; j++) {
					SubMatrix subMatrix = new SubMatrix(j, i);
					for (int k=i ; k<i+m ; k++) {
						for (int l=j ; l<j+m ; l++) {
							subMatrix.addElement(matrix[k][l]);
						}
					}
					subMatrices.add(subMatrix);
				}
			}
			SubMatrix top = subMatrices.peek();
			sb.append(String.format("%d %d\n", top.getStartY() + 1, top.getStartX() + 1));
		}

		System.out.println(sb);
		br.close();
	}
}
