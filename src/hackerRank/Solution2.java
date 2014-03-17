package hackerRank;
import java.util.Arrays;

public class Solution2 {
	
    public static void main(String[] args) {
       int n=10;int k= 4;
       Long arr[]={1l,  2l,       3l,       4l,       10l,       20l,       30l,       40l,       100l,      200l       };
//       Long[] arr={10l,    		   100l,    		   300l,    		   200l,    		   1000l,    		   20l,    		   30l};
//       int n=7;
//       int k=3;
//	     Scanner sc=new Scanner(System.in);
//       int n=Integer.parseInt(sc.nextLine());
//       int k=Integer.parseInt(sc.nextLine());
//       Long[] arr=new Long[n];
       	 int i=0; 
//       while(n>0 && sc.hasNext()){
//           arr[i]=Long.parseLong(sc.nextLine());
//           i++;
//           n--;
//       }
       Arrays.sort(arr);
       Long minDiff=Long.MAX_VALUE;
        //Move k size window
       int s=0;
       k-=1;
       for(i=k;i<n;i++){
         if(minDiff - (arr[i]- arr[s]) > 0){
             minDiff=arr[i]- arr[s];
         }
         s++;
       }
       System.out.println(minDiff);
//       sc.close();    
    }
}