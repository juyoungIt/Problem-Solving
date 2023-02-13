// BOJ - 10527
// Problem Sheet - https://www.acmicpc.net/problem/10527

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> domJudgeOutputs = new HashMap<>();
        Map<String, Integer> kattisOutputs = new HashMap<>();
        int answer = 0;

        int submissionCount = Integer.parseInt(bf.readLine());
        String result;
        for(int i=0 ; i<submissionCount ; i++) {
            result = bf.readLine();
            if(!domJudgeOutputs.containsKey(result)) {
                domJudgeOutputs.put(result, 1);
            } else {
                domJudgeOutputs.put(result, domJudgeOutputs.get(result) + 1);
            }
        }
        for(int i=0 ; i<submissionCount ; i++) {
            result = bf.readLine();
            if(!kattisOutputs.containsKey(result)) {
                kattisOutputs.put(result, 1);
            } else {
                kattisOutputs.put(result, kattisOutputs.get(result) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : domJudgeOutputs.entrySet()) {
            if(kattisOutputs.containsKey(entry.getKey())) {
                answer += Math.min(entry.getValue(), kattisOutputs.get(entry.getKey()));
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}