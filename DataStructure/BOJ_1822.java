// BOJ - 1822
// Problem Sheet - https://www.acmicpc.net/problem/1822

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int numberOfA = Integer.parseInt(st.nextToken()); // 집합 A의 원소의 수
        int numberOfB = Integer.parseInt(st.nextToken()); // 집합 B의 원소의 수

        Set<Integer> diff = new HashSet<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfA ; i++)
            diff.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfB ; i++) {
            int element = Integer.parseInt(st.nextToken());
            diff.remove(element);
        }

        System.out.println(diff.size());
        if(diff.size() > 0) {
            Iterator<Integer> iter = diff.iterator();
            List<Integer> elements = new ArrayList<>();
            while(iter.hasNext())
                elements.add(iter.next());
            Collections.sort(elements);
            for(int element : elements)
                System.out.print(element + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }
}