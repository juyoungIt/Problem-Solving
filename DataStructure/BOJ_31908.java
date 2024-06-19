// BOJ - 31908
// Problem Sheet - https://www.acmicpc.net/problem/31908

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, List<String>> ringMapper = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ringFeature = st.nextToken();
            if (ringFeature.equals("-")) continue;
            if (!ringMapper.containsKey(ringFeature)) {
                ringMapper.put(ringFeature, new LinkedList<>());
            }
            ringMapper.get(ringFeature).add(name);
        }

        List<List<String>> result = ringMapper.values()
                .stream()
                .filter(m -> m.size() == 2)
                .collect(Collectors.toList());

        System.out.println(result.size());
        result.forEach(m -> sb.append(String.format("%s %s\n", m.get(0), m.get(1))));
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}