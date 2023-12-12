// BOJ - 4388
// Problem Sheet - https://www.acmicpc.net/problem/4388

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int[] numA = Arrays.stream(st.nextToken().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] numB = Arrays.stream(st.nextToken().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(numA[0] == 0 && numB[0] == 0) break;
            sb.append(getCarryCount(numA, numB)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getCarryCount(int[] numA, int[] numB) {
        int carryCnt = 0;
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        stackA.addAll(Arrays.stream(numA).boxed().collect(Collectors.toList()));
        stackB.addAll(Arrays.stream(numB).boxed().collect(Collectors.toList()));

        int curCarry = 0;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            if(stackA.pop() + stackB.pop() + curCarry >= 10) {
                carryCnt++;
                curCarry = 1;
            } else {
                curCarry = 0;
            }
        }

        while(!stackA.isEmpty()) {
            if(stackA.pop() + curCarry >= 10) {
                carryCnt++;
            } else {
                curCarry = 0;
            }
        }

        while(!stackB.isEmpty()) {
            if(stackB.pop() + curCarry >= 10) {
                carryCnt++;
            } else {
                curCarry = 0;
            }
        }

        return carryCnt;
    }
}