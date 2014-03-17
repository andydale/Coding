package PhoneScreen;



//Time Taken : 5:15

public class Linkedin_ReverseString_Recursively {
	
	public static void main(String args[]){
		String input="Hello world";
		input=reverse(input);
		
		System.out.println(reverse(input.split(" ")[0])+" "+reverse(input.split(" ")[1]));
	}
	

	private static String reverse(String input) 
	{
		char []result=input.toCharArray();
		
		int j = result.length-1;
		int i=0;
		for(; i < j ; i++, j--){
			char temp=result[i];
			result[i]=result[j];
			result[j]=temp;
		}
		
		StringBuilder sb=new StringBuilder();
		i=0;
		while(i<result.length)
			sb=sb.append(result[i++]);
		
		return sb.toString();
	}

}
