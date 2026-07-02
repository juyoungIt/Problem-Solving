// PGS - 250121
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/250121

import java.util.*;

class Solution {
    
    static class Data {
        int code;
        int date;
        int maximum;
        int remain;
        
        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> datas = new ArrayList<>();
        for (int[] d : data) {
            datas.add(new Data(d[0], d[1], d[2], d[3]));
        }
        List<Data> result = datas.stream()
            .filter((d) -> {
                if (ext.equals("code")) return d.code < val_ext;
                else if (ext.equals("date")) return d.date < val_ext;
                else if (ext.equals("maximum")) return d.maximum < val_ext;
                else return d.remain < val_ext;
            })
            .sorted((d1, d2) -> {
                if (sort_by.equals("code")) return d1.code - d2.code;
                else if (sort_by.equals("date")) return d1.date - d2.date;
                else if (sort_by.equals("maximum")) return d1.maximum - d2.maximum;
                else return d1.remain - d2.remain;
            })
            .toList();
        int[][] answer = new int[result.size()][4];
        for (int i=0; i<result.size(); i++) {
            answer[i][0] = result.get(i).code;
            answer[i][1] = result.get(i).date;
            answer[i][2] = result.get(i).maximum;
            answer[i][3] = result.get(i).remain;
        }
        return answer;
    }
}
