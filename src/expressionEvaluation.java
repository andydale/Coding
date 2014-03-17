

public class expressionEvaluation {
	
	
	public static void main(String args[]){
//		Scanner sc=new Scanner(System.in);
//		while(sc.hasNext()){
//			String str = sc.nextLine();
//			System.out.println(str);
//		}
		String input="(35 - 3*(3+2)) / 4";
//		System.out.println(toPostFix(input));
		String pFix=toPostFix(input);
		System.out.println(pFix);
//		System.out.println(eval(pFix));
	}

	private static String toPostFix(String input) {
		input=input.replaceAll("[ ]+", "");
		return input;
	}

	private static int eval(String input) {
		if(input.isEmpty())
			return 0;
		return -1;
	}
}
