import java.util.HashSet;

public class allStringSizeK {

	public static void main(String args[]) {
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		set.add('d');
		set.add('e');
		set.add('f');
		char st[] = {'1','2','3','4'};
//		permute("", st, 3);
//		printAllPossibile("",st,3);
		setGenerate("",st,2);
	}


	//???	Retry 	
	private static void setGenerate(String string, char[] st, int n) {
		if(string.length()+st.length<n){
			return;
		}
		if(string.length()==n){
			System.out.println(string);
			return;
		}
		
		char ar[]=removeIndex(st,0);
		setGenerate(string+st[0],ar,n);
		while(ar.length>=n-1){
			ar=removeIndex(ar,0);
			setGenerate(string+st[0],ar,n);
		}
	}	

	//Looks simple but took 30 minutes to identify the recursion.
	//Yes, ordering matters
	private static void printAllPossibile(String ip, char[] st, int n) {
		if(st.length==0)
		{
			return;
		}
		if(ip.length()==n)
		{
			System.out.println(ip);
			return;
		}
		for(int i=0;i<st.length;i++){
			printAllPossibile(ip+st[i],st,n);
		}
		
	}

	public static void permute(String permutes,char[] st,int n){
		if((permutes.length()+st.length)<n)
		{
			return;
		}
		if(permutes.length()==n)
		{
			System.out.println(permutes);
			return;
		}
		for(int i=0;i<st.length;i++){
			StringBuilder sb=new StringBuilder();
			sb.append(permutes+st[i]);
			permute(sb.toString(),removeIndex(st,i),n);
		}			
	}

	//Complexity is high here as we are making copy of the main array each time we remove an element from it.
	private static char[] removeIndex(char[] st, int i) {
		if(st.length==1 && i==0){
			return new char[0];
		}
		int size=st.length-1;
		char[] ar=new char[size];
		int k=0;
		for(int j=0;j<st.length;j++){
			if(j!=i)
			{
				ar[k]=st[j];
				k++;
			}
		}
		return ar;
	}
}
