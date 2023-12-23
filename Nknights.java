public class Nknights {
    public static void main(String[] args){
        boolean[][]board = new boolean[4][4];
        nknights(board,0,0,4);
    }
    public static void nknights(boolean[][]board,int row,int col,int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board[0].length){
            //  kuch nahi kar sakte out of bound jaa raha ye
            return;
        }
        //  abhi dekho agar last column tak pohoch gaye toh next row pe jao
        if(col == board[0].length){
            nknights(board,row +1,0,knights);
            return;
        }
        //  abhi agar safe hoga toh place kar do
        if(issafe(board,row,col)){
            board[row][col] = true;
            nknights(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        //  agar nahi bhi place kiya toh bhi aagke col main check karo
        nknights(board,row,col+1,knights);
    }
    public static boolean issafe(boolean[][]board,int row,int col){
        if(isValid(board,row,col)){
            if(board[row][col] == true){
                return false;
            }
        }
        if(isValid(board,row-2,col-1)){
            if(board[row - 2][col - 1] == true){
                return false;
            }
        }
        if(isValid(board,row - 1,col - 2)){
            if(board[row - 1][col - 2] == true){
                return false;
            }
        }
        if(isValid(board,row - 2,col + 1)){
            if(board[row - 2][col + 1] == true){
                return false;
            }
        }
        if(isValid(board,row - 1,col + 2)){
            if(board[row - 1][col + 2] == true){
                return false;
            }
        }
        return true;

    }
    public static boolean isValid(boolean[][]board,int row,int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length){
            return true;
        }
        return false;
    }
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
