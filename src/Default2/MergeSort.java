package Default2;

public class MergeSort {
	/*Write code to merge sort algorithm */


	public static void main(String args[]){
	    int[] arr={0,-1,1,2,4,3};
	    mergeSort(arr,0,arr.length-1);
	    for(int i:arr){
	    	System.out.print(i+" ");
	    }
	}

	//Merge Sort
	//Psuedo code
	//Split input array into 2
	//Merge the partitioned arrays back.
	static void mergeSort(int arr[],int i,int j){    
	   if(i==j)
	      return;	  
	   int mid=(i+j)/2;
	   mergeSort(arr,i,mid);
	   mergeSort(arr,mid+1,j);
	   merge(arr,i,mid,j); 
	}

	static void merge(int []arr,int i,int mid,int j){
		System.out.println(i+"\t"+mid+"\t"+j);		
		System.out.println(" :: ");		
	    int[] midway=new int[j-i+1];
	    int k=0;
	    int m;
	    int n;
	    k=0;
	    n=mid+1;
	    m=i;
	    for(;m<=mid && n <= j ;){    	    	
	       System.out.println("m= "+m+"\t n="+n);
	       if(arr[m]<=arr[n]){   		  		
	            midway[k]=arr[m];
	            k++;
	            m++;
	        }else{
	            midway[k]=arr[n];
	            k++;
	            n++;
	        }    
	    }
	    while(n<=j){
	        midway[k]=arr[n];
	        n++;
	        k++;
	    }
	    while(m<=mid){
	        midway[k]=arr[m];
	        m++;
	        k++;
	    }
	    k=0;
	    for(m=i;m<=j;m++,k++){
	      arr[m]=midway[k];    
	    }
	}
}
