// BOJ - 8949
// Problem Sheet - https://www.acmicpc.net/problem/8949

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> numberA = Arrays.stream(st.nextToken().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numberB = Arrays.stream(st.nextToken().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Stack<Integer> numberADigits = new Stack<>();
        Stack<Integer> numberBDigits = new Stack<>();
        Stack<Integer> results = new Stack<>();

        numberADigits.addAll(numberA);
        numberBDigits.addAll(numberB);

        while(!numberADigits.isEmpty() && !numberBDigits.isEmpty()) {
            results.add(numberADigits.pop() + numberBDigits.pop());
        }
        while(!numberADigits.isEmpty()) {
            results.push(numberADigits.pop());
        }
        while(!numberBDigits.isEmpty()) {
            results.push(numberBDigits.pop());
        }

        while(!results.isEmpty()){
            sb.append(results.pop());
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}