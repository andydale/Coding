package Quiz;

import java.util.ArrayList;

public class largestprimefactor {
	static long l=600851475143l;
	
	static ArrayList<Long> primes=new ArrayList<Long>();
	public static void main(String args[]){
		
//		long l=45l;
		primes.add(2l);
		primes.add(3l);
		primes.add(5l);
		
		for(long prime:primes){				
			if(l%prime==0){
				while(l%prime==0){
					l=l/prime;
				}
			}
			if(l==1){
				System.out.println("maxPrime = "+prime);
				break;
			}		
		}
		
		long prime=-1;
		while(true){
//			System.out.println(l);
			if(l==1){
				break;
			}
			prime=nextPrime(primes);
			primes.add(prime);
			System.out.println("Next prime : "+prime);
			
			if(prime==-1){
				System.out.println("Error no solution achieved. ");
			}
			if(l%prime==0){
				while(l%prime==0){
					l=l/prime;
				}
			}
		}
		System.out.println("Max Prime = "+prime);
		
	}

	
	/**
	 * 
	 * @param primes2, list of current primes.
	 * @return
	 */
	private static Long nextPrime(ArrayList<Long> primes2) {
		long maxValue=primes2.get(primes2.size()-1)+1;
		
		while(maxValue<=l){ //check next value against current set of primes.
			int i=0;
			for(;i<primes2.size();i++){//for current set of primes
				long prime=primes2.get(i);
				if(maxValue%prime==0){					
					break; //try next value
				}
			}
			if(i==primes2.size()){//checked all primes for this value, it is a prime.
				return maxValue; 
			}
			maxValue++;			
		}
		return -1l;
	}
}


