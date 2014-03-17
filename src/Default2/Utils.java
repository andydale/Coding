package Default2;

//class can't be static 

public class Utils {
	public static void printArray(int []a){
	for(int i:a){
		System.out.print(i+" ");
	}
	System.out.println("");
	}
	
	public static int[] genArray(int l,int maxV) {
		int a[]=new int[l];
		for(int i=0;i<l;i++){
			a[i]=(int)(Math.random()*maxV);
		}
		return a;
	}
}
