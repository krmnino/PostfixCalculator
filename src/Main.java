
public class Main {
	
	public static double string_parser(Stack s, String input) {
		System.out.println(input);
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
					s.push(operand1.get_data() + operand2.get_data());
					break;
				case '-':
					s.push(operand1.get_data() - operand2.get_data());
					break;
				case '*':
					s.push(operand1.get_data() * operand2.get_data());
					break;
				case '/':
					s.push(operand1.get_data() / operand2.get_data());
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
	
	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println(string_parser(s, "123.6 43 45 + 2 * /"));
	}
}
