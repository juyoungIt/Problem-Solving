// PGS - 181841
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181841

import java.util.*;

class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        for (String str : str_list) {
            if (!contains(str, ex)) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
    
    private boolean contains(String src, String target) {
        int srcLen = src.length();
        int targetLen = target.length();
        if (srcLen < targetLen) {
            return false;
        } else {
            for (int i=0; i<=srcLen-targetLen; i++) {
                if (target.equals(src.substring(i, i + targetLen))) {
                    return true;
                }
            }
            return false;
        }
    }
}
