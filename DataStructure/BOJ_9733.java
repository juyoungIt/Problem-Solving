// BOJ - 9733
// Problem Sheet - https://www.acmicpc.net/problem/9733

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countMapper = new HashMap<>();
        String[] works = { "Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex" }; // 수행 가능한 작업
        List<String> actualWorks = new ArrayList<>();

        // 꿀벌이 수행한 일에 대한 정보를 입력받음
        String input = "";
        while((input = bf.readLine()) != null && !input.equals(""))
            actualWorks.addAll(List.of(input.split(" ")));

        // Map을 초기 사용 가능한 상태로 사용함
        for(String work : works)
            countMapper.put(work, 0);

        // 진행한 작업 현황을 카운트 함
        for(String actualWork : actualWorks)
            if(countMapper.containsKey(actualWork))
                countMapper.put(actualWork, countMapper.get(actualWork) + 1);

        // 종합결과를 반환함
        for(String work : works)
            System.out.printf("%s %d %.2f\n",
                    work,
                    countMapper.get(work),
                    (double)countMapper.get(work) / actualWorks.size());
        System.out.printf("%s %d %.2f", "Total", actualWorks.size(), 1.00);

        bf.close();
        System.exit(0);
    }
}