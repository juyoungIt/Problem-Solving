// BOJ - 1541
// Problem Sheet - https://www.acmicpc.net/problem/1541

import java.util.Scanner;
import java.util.LinkedList;

public class Main {

	static LinkedList<Integer> operands = new LinkedList<>();    // store the operands
	static LinkedList<Character> operators = new LinkedList<>(); // store the operators
	static int lastIdx = 0; // last referenced index

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String exp = key.nextLine(); // expression
		int result;

		parse(exp); // parse the string and store the operator & operand info

		// find minimum solutions
		for(int i=0 ; i<operators.size() ; i++) {
			if(operators.get(i) == '+') {
				int tmp = operands.get(i) + operands.get(i+1);
				operands.remove(i);
				operands.remove(i);
				operands.add(i, tmp);
				operators.remove(i--);
			}
		}

		result = operands.get(0);
		for(int i=1 ; i<operands.size() ; i++)
			result -= operands.get(i);

		System.out.println(result);

		key.close();
		System.exit(0);
	}

	// parse the expression from the string
	public static void parse(String exp) {
		for(int i=0 ; i<exp.length() ; i++) {
			if(isOperator(exp.charAt(i))) {
				operators.add(exp.charAt(i));
				operands.add(Integer.parseInt(exp.substring(lastIdx, i)));
				lastIdx = i+1;
			}
		}
		operands.add(Integer.parseInt(exp.substring(lastIdx, exp.length())));
	}

	// check the operator
	public static boolean isOperator(char c) {
		if(c == '+' || c == '-')
			return true;
		return false;
	}
}
