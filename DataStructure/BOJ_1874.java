// BOJ - 1874
// Problem Sheet - https://www.acmicpc.net/problem/1874

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); // 판정에 사용할 Stack
        StringBuilder sb = new StringBuilder(); // 필요한 동작에 대한 log를 저장
        boolean isValid = true; // 발생 가능한 수열인 가?
        int sequenceIdx = 0; // 수열 참조에 사용하는 인덱스

        int n = Integer.parseInt(bf.readLine());
        int[] stackSequence = new int[n]; // 스택수열
        for(int i=0 ; i<n ; i++) {
            stackSequence[i] = Integer.parseInt(bf.readLine());
        }

        for(int i=1 ; i<=n ; i++) {
            if(stackSequence[sequenceIdx] == i) {
                sb.append('+').append('\n');
                sb.append('-').append('\n');
                sequenceIdx++;
            } else if(stackSequence[sequenceIdx] < i) {
                if(!stack.isEmpty() && stackSequence[sequenceIdx] == stack.peek()) {
                    stack.pop();
                    sb.append('-').append('\n');
                    sequenceIdx++;
                    i--;
                } else {
                    isValid = false;
                    break;
                }
            } else {
                stack.push(i);
                sb.append('+').append('\n');
            }
        }

        // push를 마쳤다면 stack에 남은 수에 대해서 추가 검사를 수행함
        while(!stack.isEmpty()) {
            if(stack.peek() != stackSequence[sequenceIdx]) {
                isValid = false;
                break;
            }
            stack.pop();
            sb.append('-').append('\n');
            sequenceIdx++;
        }

        if(isValid) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

        bf.close();
        System.exit(0);
    }
}