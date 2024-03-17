// BOJ - 6376
// Problem Sheet - https://www.acmicpc.net/problem/6376

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("n e\n");
        sb.append("- -----------\n");
        for (int n=0 ; n<=9 ; n++) {
            double e = getEValue(n);
            sb.append(n).append(" ");
            if (isInteger(e)) {
                sb.append((int) e);
            } else {
                if (n == 2) {
                    sb.append(String.format("%.1f", e));
                } else {
                    sb.append(String.format("%.9f", e));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        System.exit(0);
    }

    private static double getEValue(int n) {
        double result = 0;
        for (int i=0 ; i<=n ; i++) {
            result += ((double) 1 / getFactorial(i));
        }
        return result;
    }

    private static int getFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    private static boolean isInteger(double value) {
        return (value == (int) value);
    }
}