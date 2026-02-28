// BOJ - 29731
// Problem Sheet - https://www.acmicpc.net/problem/29731

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("Never gonna give you up");
        set.add("Never gonna let you down");
        set.add("Never gonna run around and desert you");
        set.add("Never gonna make you cry");
        set.add("Never gonna say goodbye");
        set.add("Never gonna tell a lie and hurt you");
        set.add("Never gonna stop");
        boolean isChanged = false;
        while (n-- > 0) {
            String s = br.readLine();
            if (!set.contains(s)) {
                isChanged = true;
                break;
            }
        }
        System.out.println(isChanged ? "Yes" : "No");
        br.close();
    }
}
