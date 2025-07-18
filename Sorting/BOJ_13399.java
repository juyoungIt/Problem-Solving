// BOJ - 13399
// Problem Sheet - https://www.acmicpc.net/problem/13399

import java.util.*;
import java.io.*;

public class Main {

    static class Element {
        final int value;
        int weight;

        public Element(int value) {
            this.value = value;
            this.weight = 1;
        }

        private void addWeight(int weight) { this.weight = weight; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        Element[] elements = new Element[n];
        for (int i=0 ; i<n ; i++) {
            elements[i] = new Element(i + 1);
        }
        int weight = 1;
        for (int i=0 ; i<m ; i++) {
            int e = Integer.parseInt(br.readLine());
            elements[e - 1].addWeight(++weight);
        }
        Arrays.sort(elements, (e1, e2) -> e2.weight - e1.weight);
        for (Element element : elements) {
            sb.append(element.value).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}