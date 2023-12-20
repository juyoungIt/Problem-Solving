// BOJ - 6679
// Problem Sheet - https://www.acmicpc.net/problem/6679

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for(int i=1_000 ; i<10_000 ; i++) {
            if(isSpecialNumber(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
        System.exit(0);
    }

    private static boolean isSpecialNumber(int number) {
        int decimalDigitSum = getDigitSum(number, 10);
        int duodecimalDigitSum = getDigitSum(number, 12);
        int hexDigitSum = getDigitSum(number, 16);
        return decimalDigitSum == duodecimalDigitSum
                && duodecimalDigitSum == hexDigitSum;
    }

    private static int getDigitSum(int number, int base) {
        int digitSum = 0;
        while(number > 0) {
            digitSum += number % base;
            number /= base;
        }
        return digitSum;
    }
}