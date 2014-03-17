package backtracking;

/**
 * BackTracking Algorithm
 * Cracked the problem, but required debugging 2 times. 
 * Because custom nested for loop start, is tricky, you need to set the internal loop's initialization value after it's completion. Otherwise  you never initialize the internal loops value from start.
 * 
 * @author ydalal
 *
 */
public class queensProblem {
	static int[][] board=new int[8][8];
	static int solCount=0;

	public static void main(String args[]){
		solve(0);
		System.out.println("Solution  Count = "+solCount);
	}
	
	public static void solve(int count){
		if(count==8){
			solCount++;
			printSolution();
			System.out.println("Solution Achieved !");
			return;
		}
		Loc lc=getValidPosition();		
		if(lc==null)
			return; // no need to try out anything here.
		do{
		board[lc.row][lc.col]=1;
		solve(count+1);
		board[lc.row][lc.col]=0; // back track step		
		}while((lc=getNextValidPosition(lc))!=null);
		return;
	}
	
	private static void printSolution() {
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}

	private static Loc getNextValidPosition(Loc lc) {
		int i=lc.row;
		int j=lc.col;
		if(lc.row==7 && lc.col==7)
			return null;		
		else if(lc.col==7){
			i+=1;		
			j=0;		
		}else{
			j++;
		}
		
		for(;i<8;i++){
			for(;j<8;j++){				
				if(board[i][j]!=1){
					if(!isChallenged(i,j)){
						return new Loc(i,j);
					}
				}
			}
			j=0;
		}
		return null;
	}

	private static Loc getValidPosition() {
		//Get valid position function uses isChallenged function to see if current position is acceptable, since the isChallenged function is made optimized  ( it only looks back in row, col and upper and lower diagonal, it doesn't check in 
		//both the directions ( below and above and left and right ) . The idea is that we call this function after the last seen queen's position, as we are adding queens in row by row fashion we are sure that ith queen would be in ith row and there are no
		// more queens below or right to it. So we call up isChallenged function appropriately.
		
		//Made mistake*
		//Find the last 1 in the array, start finding the valid locations after it.
		int lastRow=0;
		int lastcol=0;
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]==1){					
					if(i>=lastRow){
						lastRow=i;lastcol=j;
					}	
				}
			}
		}
		
		//**Note :: 
		//When you start a nested loop from custom location, make sure that you initialize inner loop's variable. 
		int i=lastRow;
		int j=lastcol;				
		for(;i<8;i++){
			for(;j<8;j++){
				if(board[i][j]!=1){
					if(!isChallenged(i,j)){
						return new Loc(i,j);
					}
				}
			}
			j=0; // synthesized for loop start and then setting value of j=0 can be done after finish of internal loop.
		}		
		return null;
	}

	private static boolean isChallenged(int i, int j) {
		//rowCheck
		for(int c=0;c<=j;c++){ // row mein poora check karna chahiye, mistake here, the values can appear after this col.
			if(board[i][c]==1){
				return true;
			}
		}
		
		//colCheck
		for(int r=0;r<=i;r++){
			if(board[r][j]==1){
				return true;
			}
		}
		
		int r=i,c=j;
		r--;c++;
		//upperDiagCheck
		while(r>=0 && c<=7)
		{	
			if(board[r][c]==1)
				return true;
			r--;c++;
		}
		
		//lowerDiagCheck
		r=i;c=j;
		r--;c--;
		while(r>=0 && c>=0)
		{	
			if(board[r][c]==1)
				return true;
			r--;c--;
		}
		
		return false;
	}
	
	private static class Loc{
		int row;
		int col;
		public Loc(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	
}
