// BOJ - 4921
// Problem Sheet - https://www.acmicpc.net/problem/4921

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Boolean> results = new LinkedList<>(); // 각 케이스에 대한 정답

        Map<Integer, List<Integer>> nextMapper = new HashMap<>();
        buildMapper(nextMapper);

        while(true) {
            String sequence = bf.readLine();
            if(sequence.equals("0")) break;
            results.add(validation(nextMapper, sequence));
        }

        for(int i=0 ; i<results.size() ; i++) {
            System.out.println((i+1) + ". " + ((results.get(i)) ? "VALID" : "NOT"));
        }

        bf.close();
        System.exit(0);
    }

    static void buildMapper(Map<Integer, List<Integer>> map) {
        for(int i=1 ; i<=8 ; i++) {
            map.put(i, new ArrayList<>());
            if(i == 1 || i == 3) {
                map.get(i).add(4);
                map.get(i).add(5);
            } else if(i == 4 || i == 6) {
                map.get(i).add(2);
                map.get(i).add(3);
            } else if(i == 5 || i == 7) {
                map.get(i).add(8);
            } else {
                map.get(i).add(6);
                map.get(i).add(7);
            }
        }
    }

    // 블럭의 배치순서(sequence)가 유효한지 검증
    static boolean validation(Map<Integer, List<Integer>> map, String sequence) {
        if(sequence.charAt(0) != '1' || sequence.charAt(sequence.length()-1) != '2')
            return false;
        for(int i=1 ; i<sequence.length() ; i++) {
            int preBlock = Integer.parseInt(sequence.charAt(i-1)+"");
            int curBlock = Integer.parseInt(sequence.charAt(i)+"");
            if(!map.get(preBlock).contains(curBlock)) {
                return false;
            }
        }
        return true;
    }
}