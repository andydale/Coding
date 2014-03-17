package backtracking;
//Solved :) Made one mistake, made recursive call inside the find next empty cell loop, it must be outside, as the current loop's job is just to retun onyl 1 empty cell and you call recursion on that empty cell, if everything trid out for that cell, then you return. 
// you allow the previous call to move up it's value and try new set of values....

public class sudoku {
	static int arr[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
	
	static long startTime=System.currentTimeMillis();
	//9x9 sudoku solver
	public static void main(String args[]){
		
		try {
			sudoku(arr);
//			testNumCheck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Solution not Achieved !");
	}

	private static void testNumCheck() throws Exception {
//		arr[0][1]=1;
//		arr[0][4]=2;
//		arr[0][7]=7;
//		arr[0][8]=9;
//		rowCheck();		
		arr[0][1]=1;
		arr[2][0]=4;
		arr[1][2]=9;
		System.out.println(checkCell(0,0));
	}

	private static void sudoku(int[][] arr) throws Exception {
 		boolean flag=false;
		int r=0,c=0;
		for(r=0;r<9;r++){
			for(c=0;c<9;c++){
				if(arr[r][c]==0){
					flag=true;
					break;//single break only get you out of the first loop not the second loop. *Mistake					
				}
			}
			if(flag==true){
				break;
			}
		}					
		if(r==9 && c== 9 )
		{
			printPresentState();
			System.out.println("Solution Achieved !");
			return;
		}else if(r==9 || c==9){
			printPresentState();
			System.out.println("This shouldn't happen. r="+r+" c="+c);
		}
		//Mistake, I was calling following block inside the r,c loop above, the problem with that approach is that, we need recursive call for one cell at a time. If we call this loop and function in above loop then we are calling other empty cells
		//as well even before deciding on the previous set of cells. That's why I could see the empty cells before current cell of operation. In back tracking the base is always completed first. There are no empty cell's left before the current operating cell.
		for(int i=1;i<10;i++){
			if(isSafe(arr,r,c,i)){
				arr[r][c]=i;
				sudoku(arr);
				arr[r][c]=0;	
			}
		}
		return;		
	}
	
	private static boolean isSafe(int[][] arr2,int r,int c, int i) {
		if(!isRowSafe(r,i)){
			return false;
		}
		if(!isColSafe(c,i)){
			return false;
		}
		if(!isCellSafe(r,c,i)){
			return false;
		}		
		return true;
	}

	private static boolean isCellSafe(int r, int c, int i) {		
		int cRow = r<3 ? 0 : ( r<6 ? 3 : 6);
		int cCol = c<3 ? 0 : ( c<6 ? 3 : 6);
		for( r=cRow;r<=cRow+2;r++){
			for( c=cCol;c<=cCol+2;c++){
				if(arr[r][c]==i)
					return false;
			}
		}
		return true;
	}

	private static boolean isColSafe(int col,int i) {
		for(int row=0;row<9;row++)
			if(arr[row][col]==i)
				return false;
		return true;
	}

	private static boolean isRowSafe(int row, int i) {
		for(int col=0;col<9;col++)
			if(arr[row][col]==i)
				return false;
		return true;
	}

	private static boolean isValid(int[][] arr) throws Exception {
		if(System.currentTimeMillis()-startTime>300000l){
			startTime=System.currentTimeMillis();
			printPresentState();
			System.out.println("");
		}
		//Scan for any 0 in any row
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(arr[i][j]==0)
					return false;
			}
		}
		//Cell Check
		if(!validCells(arr))
			return false;
		//Column Check
		if(!validCols(arr))
			return false;
		//Row Check
		if(!validRows()){
			return false;
		}
		return true;
	}

	private static void printPresentState() {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		
	}

	private static boolean validRows() throws Exception {
		int bitVector=0x1FF; // Made mistake wrote 0x1AA instead of FF, note that F = 1111 , A = 1000
		int num=0;
		for(int row=0;row<9;row++){
			num=0;
			for(int col=0;col<9;col++){
				num=setBit(num,arr[row][col]);				
			}
			if(bitVector!=num)
				return false;
		}
		return true;
	}

	private static int setBit(int num, int bit) throws Exception {
		if(bit>9)
			throw new Exception("Invalid value in the table, " + bit);
		bit-=1;
		int temp=1;
		temp=temp<<bit;
		num=num|temp;
		return num;
	}

	private static boolean validCols(int[][] arr) throws Exception {
		int bitVector=0x1FF; // Made mistake wrote 0x1AA instead of FF, note that F = 1111 , A = 1000
		int num=0;
		for(int col=0;col<9;col++){
			num=0;
			for(int row=0;row<9;row++){
				num=setBit(num,arr[row][col]);				
			}
			if(bitVector!=num)
				return false;
		}
		return true;
	}

	private static boolean validCells(int[][] arr) throws Exception {		
		if(checkCell(0,0) &&checkCell(0,3) &&checkCell(0,6)
			&& checkCell(3,0) && checkCell(3,3) && checkCell(3,6) 
			&& checkCell(6,0) && checkCell(6,3) && checkCell(6,6) 
		)
			return true;
		return false;
	}
	
	private static boolean checkCell(int i, int j) throws Exception {
		int bitVector=0x1FF;
		int num=0;
		for(int r=i;r<=2;r++){			
			for(int c=i;c<=2;c++){
				num=setBit(num,arr[r][c]);
			}
		}
		if(num!=bitVector)
			return false;
		return true;
	}
}
