// BOJ - 20291
// Problem Sheet - https://www.acmicpc.net/problem/20291

import java.util.*;
import java.io.*;

public class Main {

    static class ExtensionInfo implements Comparable<ExtensionInfo> {
        private final String name; // 확장자명
        private final int count; // 등장한 횟수

        public ExtensionInfo(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return this.name; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(ExtensionInfo ei) {
            return this.name.compareTo(ei.getName());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 파일의 수
        Map<String, Integer> extensionMapper = new HashMap<>(); // 각 확장자 별 등장횟수 저장
        List<ExtensionInfo> extensions = new ArrayList<>();

        // 입력정보를 바탕으로 확장자 수 정보를 구성함
        for(int i=0 ; i<n ; i++) {
            String extension = bf.readLine().split("\\.")[1];
            if(!extensionMapper.containsKey(extension)) extensionMapper.put(extension, 1);
            else extensionMapper.put(extension, extensionMapper.get(extension) + 1);
        }

        // 구성한 확장자 수 기준으로 정렬을 수행함
        for(Map.Entry<String, Integer> extension : extensionMapper.entrySet())
            extensions.add(new ExtensionInfo(extension.getKey(), extension.getValue()));
        Collections.sort(extensions); // 확장자 명의 사전 순 정렬

        // 종합한 결과를 출력함
        for(ExtensionInfo ei : extensions)
            System.out.println(ei.getName() + " " + ei.getCount());


        bf.close();
        System.exit(0);
    }
}