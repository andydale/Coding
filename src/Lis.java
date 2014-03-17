import java.util.Stack;

// Problem to find the longest increasing subsequence. Print the longest increasing subsequence.

// Implement longest decreasing subsequence

// Implement bitonic sequence solution here.
	//TWo parts : 1 is the increasing subsequence part+ 2nd part is the decreasing subsequence.
	//Merge two arrys and find the max at given position i.

public class Lis {
	public static void main(String args[]){
		int[] a={2, 1, 2, 11, 4, 5, 2, 12,13};
		lis(a);
		lds(a);
	}

	private static void lis(int[] a) {
		//definition of lis : ith position means the longest increasing subsequence until now ending at this character. 
		int lis[]=new int[a.length];
		int s[]=new int[a.length]; // to print you can set previous pointers in this array.
		lis[0]=1;
		s[0]=0; //pointer to self.
		for(int i=1;i<a.length;i++){
			int cur=a[i];
			s[i]=i; //default pointer is to self.
			for(int j=i-1;j>=0;j--){
				if(cur>a[j])
				if(lis[j]+1 > lis[i]){
					
					s[i]=j;  
//					System.out.println(cur);
					lis[i]=lis[j]+1;
				}
			}
		}
//		System.out.println(max(lis));
		System.out.println(getSequence(max(lis),s,a));
	}
	
	private static String getSequence(int e, int[] s,int[] a) {
		Stack<Integer> sc=new Stack<Integer>();
		//Learn the mistakes made in this one.
		while(s[e]!=e){ // it will never add the last value to stack ( as it fails on that conditioon. So you want to add the last one to the stack after loop.
			sc.push(a[e]);
			e=s[e];
		}
		sc.push(a[e]);
		StringBuilder sb=new StringBuilder();
		while(!sc.isEmpty()){
			sb.append(sc.pop()+" ");
		}
		return sb.toString();
	}

	private static int max(int[] a){
		int max=Integer.MIN_VALUE;
		int i=0;
		int maxP=-1;
		for(int t:a){
			if(t>max){
				max=t;
				maxP=i;
			}
			
			i++;
		}
		return maxP;
	}
	private static void lds(int a[]){
	}
}
