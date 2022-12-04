// BOJ - 13414
// Problem Sheet - https://www.acmicpc.net/problem/13414

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> requests = new LinkedHashSet<>();

        int k = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int l = Integer.parseInt(st.nextToken()); // 대기열의 길이

        for(int i=0 ; i<l ; i++) {
            String sid = bf.readLine();
            if(requests.contains(sid))
                requests.remove(sid);
            requests.add(sid);
        }

        Iterator<String> iterator = requests.iterator();
        for(int i=0 ; i<k ; i++) {
            if(!iterator.hasNext())
                break;
            System.out.println(iterator.next());
        }

        bf.close();
        System.exit(0);
    }
}