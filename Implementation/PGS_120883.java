// PGS - 120883
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120883

import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> userInfo = new HashMap<>();
        for (String[] info : db) {
            userInfo.put(info[0], info[1]);
        }
        String id = id_pw[0];
        String pw = id_pw[1];
        if (!userInfo.containsKey(id)) {
            return "fail";
        } else {
            return userInfo.get(id).equals(pw) ? "login" : "wrong pw";
        }
    }
}
