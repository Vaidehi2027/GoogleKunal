import java.util.*;
public class Introtobacktracking{
    public static void main(String[] args){
        int[][]board = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        printingpaths(1,board,0,0);
    }
    //  count number of ways to complete a 3 * 3 maze where you can go right and down
    public static int numberofways(int r,int c){
        if(r == 1 || c == 1){
            return 1;
        }
        
        int left = numberofways(r - 1, c);
        int right = numberofways(r, c - 1);
        return left + right;
    }
    // print all the paths to reach the destination
    public static void paths(String p,int r,int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            paths(p + 'D', r-1, c);
        }
        if(c > 1){
            paths(p + 'R',r,c-1);
        }
    }
    // returning all the paths in  an arraylist
    public static ArrayList<String> listpaths(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList <String> list = new ArrayList <>();
            list.add(p);
            return list;
        }
        ArrayList <String> ans = new ArrayList <>();
        if(r > 1){
            ans.addAll(listpaths(p + 'D',r-1,c));
        }
        if(c > 1){
            ans.addAll(listpaths(p+ 'R', r , c - 1));
        }
        return ans;
    }
    //  what if we can move in three directions
    //  down, horizontal and diagonal
    public static ArrayList <String> diagonal(String p,int r,int c){
        if(r == 1 && c == 1){
            ArrayList <String> list = new ArrayList <>();
            list.add(p);
            return list;
        }

        ArrayList <String> ans = new ArrayList <>();
        // for diagonal
        if(r > 1 && c > 1){
            ans.addAll(diagonal(p + 'D',r-1,c-1));
        }
        if(r > 1){
            ans.addAll(diagonal(p + 'V',r-1,c));
        }
        if(c > 1){
            ans.addAll(diagonal(p + 'H',r,c-1));
        }
        return ans;
    }
    //  if we have to start from 0 and 1 etc etc
    public static ArrayList<String> diagonal2(String p,int r,int c,int m,int n){
        if(r == m-1 && c == n-1){
            ArrayList <String> list = new ArrayList <>();
            list.add(p);
            return list;
        }
        ArrayList <String> ans = new ArrayList <>();
        // for diagonal
        if(r < m-1 && c < n-1){
            ans.addAll(diagonal2(p + 'D',r+1,c+1,m,n));
        }
        if(r < m-1){
            ans.addAll(diagonal2(p + 'V',r+1,c,m,n));
        }
        if(c < n-1){
            ans.addAll(diagonal2(p + 'H',r,c+1,m,n));
        }
        return ans;

    }
    // if we have an obstacle in the road
    public static void obstacle(String p,boolean [][]board,int r,int c){
        if(r == board.length-1 && c == board[0].length-1){
            System.out.println(p);
            return;
        }
        //  for the obstacle
        if(board[r][c] == false){
            return;
            //  recursion call hi stop kardo tum jaa hi nahi sakte aage
        }
        // if we have to go down
        if(r < board.length-1){
            obstacle(p + 'D',board,r+1,c);
        }
        //  if we want to go right
        if(c < board[0].length-1){
            obstacle(p + 'R',board,r,c+1);
        }
    }
    // implementation of backtracking where you can in all four directions
    //  here we will mark as visited and then revert them when we backtrace the path
    public static void backtracking(String p,boolean [][]board,int r,int c){
        if(r == board.length-1 && c == board[0].length-1){
            System.out.println(p);
            return;
        }
        //  for the obstacle
        if(board[r][c] == false){
            return;
            // ab yaha backtracking main agar visted cell aa gaya toh ruk jao tum jaa hi nahi sakte aage
            
        }
        // here mark the cell as visited
        board[r][c] = false;
        // if we have to go down
        if(r < board.length-1){
            backtracking(p + 'D',board,r+1,c);
        }
        //  if we want to go right
        if(c < board[0].length-1){
            backtracking(p + 'R',board,r,c+1);
        }
        //  if we have to go up
        if(r > 0){
            backtracking(p + 'U',board,r-1,c);
        }
        // if we have to go left
        if(c > 0){
            backtracking(p + 'L',board,r,c-1);
        }

        // here is the end of the function from here the function will return so befor returning revert all the chages that were made
        // by this path to start anew when we are on the upper level of the recursion tree (reverting the changes as if we never took that path)
        board[r][c] = true;
    }
    // print the path and the matrix
    // here the count varibale is primitive and is unique for each call but the array is an object and it has multiple references
    public static void printingpaths(int step,int [][]board,int r,int c){
        if(r == board.length-1 && c == board[0].length-1){
            board[r][c] = step;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //  for the obstacle
        if(board[r][c] != 0){
            return;
            // ab yaha backtracking main agar visted cell aa gaya toh ruk jao tum jaa hi nahi sakte aage
            
        }
        // here mark the cell as visited
        board[r][c] = step;
        // if we have to go down
        if(r < board.length-1){
            printingpaths(step + 1,board,r+1,c);
        }
        //  if we want to go right
        if(c < board[0].length-1){
            printingpaths(step+1,board,r,c+1);
        }
        //  if we have to go up
        if(r > 0){
            printingpaths(step+1,board,r-1,c);
        }
        // if we have to go left
        if(c > 0){
            printingpaths(step+1,board,r,c-1);
        }

        // yaha backatrck karlo us value ko
        board[r][c] = 0;
    }

}