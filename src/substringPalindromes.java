
// DP problem
// Longest palindrom

public class substringPalindromes {

	public static void main(String args[]) {
		String input="abba";
		int[][] pMat=new int[input.length()][input.length()];
		fillPalin(pMat,input);
		printMatrix(pMat,input.length());
	}

	private static void printMatrix(int[][] pMat,int n){
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){
				System.out.print(pMat[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	
	private static void fillPalin(int[][] pMat, String input) {
		int n=input.length();
		char[] arr=input.toCharArray();
		
		//Set diagonal to be true
		for(int i=0;i<n;i++){
			pMat[i][i]=1;
		}
		
		//Set flag for strings of size 2
		for(int i=0;i<n-1;i++){
			if(input.toCharArray()[i]==input.toCharArray()[i+1])
			pMat[i][i+1]=1;
		}
		
		//For all the other cases
		int len=2;
		while(len < n){
			for(int i=0;i<n-len;i++){
				for(int j=i+len;j<n;j++){
					if(pMat[i][j]==0 && arr[i]==arr[j] && pMat[i+1][j-1]==1){
						pMat[i][j]=1;
					}
				}
			}	
		len++;
		}
		
	}
}
