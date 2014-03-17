package hackerRank;

import java.util.Collections;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
    	
        Scanner sc=new Scanner(System.in);
         int T= -1;
         while(sc.hasNext()){
            int val=Integer.parseInt(sc.nextLine());
            if(T == -1){
              T= val;  
            }else{
                println(getDecentNumber(val)+"");
                T--;
            }
            
        	if(T==0)    
                break;
        }
        sc.close();
        Long.m
//    	println(getDecentNumber(1));    	
//    	println(getDecentNumber(3));
//    	println(getDecentNumber(5));
//    	println(getDecentNumber(111));    	
    }
    public static void println(String str){
        System.out.println(str);
    }
    
    public static String getDecentNumber(int val){
        Long maxVal= -1l;
        if(val < 3 )
            return maxVal+"";
        int a= val / 3;
        int b =0;        
        while(a >= 0){
            int test = val - (a*3);
            if(test % 5 ==0 ){
            	b=test/5;
                return compose(a,b);                
            }
            a--;            
        }
        return maxVal+"";        
    }
    public static String compose(int a,int b){
    	if(a==0 && b==0){
    		return "-1";
    	}
        a=3*a;
        b=5*b;
        StringBuilder sb=new StringBuilder();
        while(a>0){
            sb.append("5");
            a--;
        }
        while(b>0){
            sb.append("3");
            b--;
        }        
        return sb.toString();
    }
}
