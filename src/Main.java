import java.util.Scanner;

public class Main {
	
	public static double string_parser(String input) {
		Stack s = new Stack();
		int space_pos;
		String expression;
		while(input.length() >= 1) {
			space_pos = input.indexOf(' ');
			if(space_pos == -1 && s.get_size() < 2) {
				System.out.println("There is a missing operand in the expression");
				return -1;
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
					System.out.println("There is a missing operand in the expression");
					return -1;
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
		return s.pop().get_data();
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
			System.out.println("Result: " + string_parser(input_str));			
		}
	}
	
	public static void main(String[] args) {
		program_loop();
	}
}
