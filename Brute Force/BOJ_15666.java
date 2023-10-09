// BOJ - 15666
// Problem Sheet - https://www.acmicpc.net/problem/15666

import java.util.*;
import java.io.*;

public class Main {

    private static int m;
    private static int[] elements;
    private static int[] selected;
    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        elements = new int[n];
        selected = new int[m];

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        elements = getUniqueArray();
        Arrays.sort(elements);

        generate(0, 0);
        System.out.println(result);

        bf.close();
        System.exit(0);
    }

    private static int[] getUniqueArray() {
        Set<Integer> elementSet = new HashSet<>();
        for(int element : elements) {
            elementSet.add(element);
        }
        return elementSet.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void generate(int accLen, int lastIdx) {
        if(accLen == m) {
            for(int element : selected) {
                result.append(element).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i=lastIdx ; i<elements.length ; i++) {
            selected[accLen] = elements[i];
            generate(accLen + 1, i);
        }
    }
}