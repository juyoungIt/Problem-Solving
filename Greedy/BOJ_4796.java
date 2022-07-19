// BOJ - 4796
// Problem Sheet - https://www.acmicpc.net/problem/4796

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] input = new int[3]; // store the input L, P, V values.
        ArrayList<Integer> output = new ArrayList<>(); // store the all answer about test cases

        int answer = 0;

        while(true) {

            answer = 0;
            st = new StringTokenizer(bf.readLine());
            for(int i=0 ; i<3 ; i++)
                input[i] = Integer.parseInt(st.nextToken());
            
            // 입력의 종료 조건인 모든 입력이 0으로 들어온 경우
            if(input[0] == 0 && input[1] == 0 && input[2] == 0)
                break;
            
            answer += ((input[2] / input[1]) * input[0]);
            if(input[2]%input[1] > input[0])
                answer += input[0];
            else
                answer += (input[2]%input[1]);
            
            output.add(answer);
        }

        // print out the answer
        for(int i=0 ; i<output.size() ; i++)
            System.out.println("Case " + (i+1) + ": " + output.get(i));

        bf.close();
        System.exit(0);
	}
}