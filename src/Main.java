
public class Main {
	public static void string_parser(String input) {
		/*
		for(int i = 0 ; i < input.length(); i++) {
			
		}
		*/
		int upper = input.indexOf(' ');
		String num = input.substring(0, upper);
		System.out.println(Double.valueOf(num));
	}
	
	public static void main(String[] args) {
		/*
		Stack s = new Stack();
		for(int i = 0; i < 10; i++) {
			s.push(i * i);
		}
		System.out.println(s.toString());
		for(int i = 0; i < 5; i++) {
			System.out.println(s.pop().toString());
		}
		System.out.println(s.peek().toString());
		*/
		string_parser("123.6 43 + 2 *");
	}
}
