// BOJ - 27964
// Problem Sheet - https://www.acmicpc.net/problem/27964

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID = "yummy";
    private static final String INVALID = "sad";
    private static final String IDENTIFIER = "Cheese";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> cheeseToppings = new HashSet<>();

        int numberOfToppings = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfToppings ; i++) {
            String topping = st.nextToken();
            if(topping.endsWith(IDENTIFIER)) {
                cheeseToppings.add(topping);
            }
        }

        if(cheeseToppings.size() >= 4) {
            System.out.println(VALID);
        } else {
            System.out.println(INVALID);
        }

        bf.close();
        System.exit(0);
    }
}