// BOJ - 4673
// Problem Sheet - https://www.acmicpc.net/problem/4673

public class Main {
    public static final int size = 10000;
    public static void main(String[] args) {
        int[] arr = new int[size];

        for(int i=0 ; i<size ; i++)
            arr[i] = i+1;

        for(int i=0 ; i<size ; i++) {
            int tmp = dFunction(i+1);
            if(tmp <= size && tmp != 0) arr[tmp-1] = 0;
            else continue;
        }

        for(int i=0 ; i<size ; i++)
            if(arr[i] != 0)
                System.out.println(arr[i]);
    }

    // generate d function number
    public static int dFunction(int num) {
        int tmp = num;
        int result = num;
        while(true) {
            result += tmp%10;
            if(tmp/10 == 0) break;
            tmp /= 10;
        }
        return result;
    }
}