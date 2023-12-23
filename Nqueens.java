public class Nqueens {
    public static void main(String[] args){
        int n  = 4;
        boolean [][]board = new boolean[n][n];
        System.out.println(nqueens(board,0));
    }
    public static int nqueens(boolean[][]board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //  ab har ek column ke liye karo
        for(int col=0;col<board[0].length;col++){
            if(issafe(board,row,col)){
                board[row][col] = true;
                count += nqueens(board,row+1);
                //  ab yaha jab function return hoga like pev level pe jayega toh current levl ki queen ho hata do
                board[row][col] = false;
            }
        }
        return count;
    }
    
    public static boolean issafe(boolean[][]board,int r,int c){
        //  column ke liye
        for(int i=0;i<r;i++){
            if(board[i][c] == true){
                return false;
            }
        }
        //  left diagonal
        int maxleft = Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i] == true){
                return false;
            }
        }
        //  right diagonal
        int maxright = Math.min(r,board.length-c-1);
        for(int i=1;i<=maxright;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    //  to display board
    public static void display(boolean[][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == true){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    
}
