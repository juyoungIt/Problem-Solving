// BOJ - 25601
// Problem Sheet - https://www.acmicpc.net/problem/25601

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int classCount = Integer.parseInt(bf.readLine()); // 클래스의 수
        Map<String, List<String>> classNetwork = new HashMap<>(); // adjacency list

        String childrenClass; // 자식 클래스
        String parentClass; // 부모 클래스
        for(int i=0 ; i<classCount-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            childrenClass = st.nextToken();
            parentClass = st.nextToken();

            if(!classNetwork.containsKey(childrenClass)) {
                classNetwork.put(childrenClass, new LinkedList<>());
            }
            if(!classNetwork.containsKey(parentClass)) {
                classNetwork.put(parentClass, new LinkedList<>());
            }
            classNetwork.get(childrenClass).add(parentClass);
        }

        st = new StringTokenizer(bf.readLine());
        String classOne = st.nextToken();
        String classTwo = st.nextToken();

        // 주어진 graph를 탐색하여 변환가능 여부를 판단함
        boolean result1 = checkConvertable(classNetwork, classOne, classTwo);
        boolean result2 = checkConvertable(classNetwork, classTwo, classOne);
        System.out.println((result1 || result2) ? 1 : 0);

        bf.close();
        System.exit(0);
    }

    static boolean checkConvertable(Map<String, List<String>> classNetwork, String source, String target) {
        Queue<String> queue = new LinkedList<>(); // bfs에 사용할 queue
        boolean isConvertable = false;

        queue.add(source);
        while(!queue.isEmpty() && !isConvertable) {
            String curClass = queue.peek();
            for(String className : classNetwork.get(curClass)) {
                if(className.equals(target)) {
                    isConvertable = true;
                    break;
                }
                queue.add(className);
            }
            queue.poll();
        }
        return isConvertable;
    }
}