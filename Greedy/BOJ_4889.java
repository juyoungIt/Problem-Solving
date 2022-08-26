// BOJ - 4889
// Problem Sheet - https://www.acmicpc.net/problem/4889

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp; // 일시적인 저장을 위한 문자열
        Stack<Character> stack = new Stack<>(); // 알고리즘에 사용할 Stack
        ArrayList<Integer> answers = new ArrayList<>(); // 솔루션을 저장

        while(true) {
            int answer = 0;
            tmp = bf.readLine();
            if(tmp.charAt(0) == '-')
                break;
            for(int i=0 ; i<tmp.length() ; i++) {
                // 여는 괄호를 만난 경우
                if(tmp.charAt(i) == '{')
                    stack.add('{');
                // 닫는 괄호를 만난 경우
                else {
                    if(stack.isEmpty()) {
                        answer++;
                        stack.add('{');
                        continue;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                answer += (stack.size() / 2);
            answers.add(answer);
            stack.clear(); // 재사용을 위해 stack을 비움
        }

        // 종합된 솔루션을 출력함
        for(int i=1 ; i<=answers.size() ; i++)
            System.out.println(i + ". " + answers.get(i-1));

        bf.close();
        System.exit(0);
    }
}