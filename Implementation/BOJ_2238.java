// BOJ - 2238
// Problem Sheet - https://www.acmicpc.net/problem/2238

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Person implements Comparable<Person> {
        int index;
        String name;
        int price;

        public Person(int index, String name, int price) {
            this.index = index;
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Person p) {
            return index - p.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Map<Integer, List<Person>> priceMap = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            if (!priceMap.containsKey(p)) {
                priceMap.put(p, new ArrayList<>());
            }
            priceMap.get(p).add(new Person(i, s, p));
        }

        List<List<Person>> persons = priceMap.entrySet().stream()
                .filter(e -> e.getKey() <= u)
                .sorted(Comparator.comparingInt(e -> e.getValue().size()))
                .map(Map.Entry::getValue)
                .limit(1)
                .collect(Collectors.toList());

        Collections.sort(persons.get(0));
        System.out.println(persons.get(0).get(0).name + " " + persons.get(0).get(0).price);
        br.close();
    }
}
