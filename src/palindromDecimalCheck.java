import java.util.ArrayList;
import java.util.List;


//Never forget to check all the boundary conditions

public class palindromDecimalCheck {
	
	public static void main(String args[]){
		int n=111;
		
		System.out.println(isPalindrome(n));
	}

	
	private static boolean isPalindrome(int n) {
		if(n<0){
			n*=-1;
		}
		
		List<Integer> q=new ArrayList<Integer>();	
		while(n > 0){			
			int r=n%10;
			q.add(r);
			n=n/10;		
		}
		for(int s=0,e=q.size()-1;s<e;s++,e--){
			if(q.get(s)!=q.get(e))
				return false;
		}
		return true;		
	}
}
