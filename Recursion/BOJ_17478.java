// BOJ - 17478
// Problem Sheet - https://www.acmicpc.net/problem/17478

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // 재귀 반복횟수

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        question(0, n);

        key.close();
        System.exit(0);
    }

    public static void question(int cur, int end) {

        StringBuilder header = new StringBuilder();
        String header_part = "____";

        for(int i=0 ; i<cur ; i++)
            header.append(header_part);

        System.out.println(header + "\"재귀함수가 뭔가요?\"");

        if(cur == end)
            System.out.println(header + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        else {
            System.out.println(header + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(header + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(header + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            question(cur+1, end);
        }

        System.out.println(header + "라고 답변하였지.");
    }
}