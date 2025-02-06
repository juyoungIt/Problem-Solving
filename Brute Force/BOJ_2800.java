// BOJ - 2800
// Problem Sheet - https://www.acmicpc.net/problem/2800

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static String expr;
    private static int pairCount = 0;
    private static int[][] pairs = new int[10][2];
    private static Set<String> exprSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();
        getPairInfo();
        solve(0, 0, "");
        List<String> exprList = exprSet.stream().sorted().collect(Collectors.toList());
        for (String expr : exprList) {
            sb.append(expr).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expr = br.readLine();
        br.close();
    }

    private static void getPairInfo() {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0 ; i<expr.length() ; i++) {
            if (expr.charAt(i) == '(') {
                stack.push(i);
            } else if (expr.charAt(i) == ')') {
                pairs[pairCount][0] = stack.pop();
                pairs[pairCount][1] = i;
                pairCount++;
            }
        }
    }

    private static void solve(int count, int pairIndex, String removed) {
        if (pairIndex == pairCount) {
            if (count > 0) {
                exprSet.add(getExpr(removed));
            }
            return;
        }
        solve(count, pairIndex + 1, removed);
        solve(count + 1, pairIndex + 1, removed + ((count > 0) ? "," : "") + pairIndex);
    }

    private static String getExpr(String removedPair) {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<expr.length() ; i++) {
            if (isRemoved(i, removedPair)) continue;
            sb.append(expr.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isRemoved(int index, String removedPairs) {
        if (removedPairs.isEmpty()) return false;
        for (String removedPair : removedPairs.split(",")) {
            int pairIndex = Integer.parseInt(removedPair);
            if (pairs[pairIndex][0] == index || pairs[pairIndex][1] == index) {
                return true;
            }
        }
        return false;
    }
}