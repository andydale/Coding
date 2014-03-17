
//Linkedin
//Binary search to find the start and the end indexes of given number in a sorted array.
//1 issue

public class binarySearch_Modification {
	static int start=-1;
	static int end=-1;
	
	public static void main(String args[]){
		int[] a={0,0,2,3,3,3,3,4,7,7,9};
		print(a,9);
		System.out.println(start+" "+end);
		
//		print(a,5);
	}

	private static void print(int[] a, int i) {
		print(a,0,a.length-1,i);
	}

	private static void print(int[] a, int i, int j, int i2) {
		if(i>j)
			return;
		
		if(i==j){
			if(a[i]==i2){
				if(start==-1){
					start=i;
				}else if( i < start){
					start =i;
				}
				if(end == -1 ){
					end=i;
				}else if ( i > end){
					end =i;
				}		
			
			}
			return;
		}
		
		int mid=(i+j)/2;
		if(a[mid]==i2){
			
			if(start==-1){
				start=mid;
			}else if( mid < start){
				start =mid;
			}
			if(end == -1 ){
				end=mid;
			}else if ( mid > end){
				end =mid;
			}
			
			// Issue : Forgot to add following 2 lines, rest everything worked fine.
			print(a,i,mid-1,i2); 
			print(a,mid+1,j,i2); 
			
		}else if (a[mid]>i2){
			print(a,i,mid-1,i2);
		}else
			print(a,mid+1,j,i2);
	}
}
