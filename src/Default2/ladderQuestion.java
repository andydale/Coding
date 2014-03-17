package Default2;

public class ladderQuestion {
    public static void main(String args[]){

    int[] stepsizes={1,2,3};
    
    try{
    	
    }catch(Exception e){
    	System.err.println(e.getMessage());
    	e.printStackTrace();
    }
    System.out.println(getStepCount(2,stepsizes));
    
    }
    
    public static int getStepCount(int ladderSize,int[] stepSize){
        if(ladderSize==0){
            return 0;
        }
        int sum=0;
        for(int s:stepSize){
            if(ladderSize-s >= 0 ){
                sum+= 1;
                getStepCount(ladderSize-s,stepSize);
            }
        }
        return sum;
    }
}
