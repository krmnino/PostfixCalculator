import java.util.Scanner;

public class Main {
	
	public static Node string_parser(String input) {
		Stack s = new Stack();
		int space_pos;
		String expression;
		while(input.length() >= 1) {
			space_pos = input.indexOf(' ');
			if(space_pos == -1 && s.get_size() < 2) {
				return null;
			}
			if(space_pos != -1) {
				expression = input.substring(0, space_pos);
			}
			else {
				expression = input;
			}
			if(!expression.equals("+") && !expression.equals("-") && 
			   !expression.equals("*") && !expression.equals("/")) {
				s.push(Double.valueOf(expression));
			}
			else {
				char operator = input.charAt(0);
				Node operand1 = s.pop();
				Node operand2 = s.pop();
				if(operand1 == null || operand2 == null) {
					return null;
				}
				switch(operator) {
				case '+':
					s.push(operand2.get_data() + operand1.get_data());
					break;
				case '-':
					s.push(operand2.get_data() - operand1.get_data());
					break;
				case '*':
					s.push(operand2.get_data() * operand1.get_data());
					break;
				case '/':
					s.push(operand2.get_data() / operand1.get_data());
					break;
				default:
				}
			}
			if(space_pos != -1) {
				input = input.substring(space_pos + 1, input.length());
			}
			else {
				break;
			}
		}
		return s.pop();
	}
	
	public static void program_loop() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Postfix Calculator by Kurt Manrique-Nino\nEnter Q/q to quit.");
		while(true) {
			System.out.print(">> ");
			String input_str = scan.nextLine();
			if(input_str.equals("q") || input_str.equals("Q")) {
				break;
			}
			Node result = string_parser(input_str);
			if(result != null) {
				System.out.println("Result: " + result.get_data());
			}
			else {
				System.out.println("There is a missing operand or operator in the expression");
			}
		}
	}
	
	public static void main(String[] args) {
		program_loop();
	}
}
