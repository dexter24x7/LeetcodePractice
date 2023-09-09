package BFS;
//909. Snakes and Ladders

import java.util.LinkedList;
import java.util.Queue;

/**
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
You start on square 1 of the board. In each move, starting from square curr, do the following:
Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.
Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> posQ = new LinkedList<>();
        int bs = board.length;
        int target = bs*bs;
        int moves =0;
        boolean[] visited = new boolean[target];
        posQ.offer(1);
        visited[0] = true;
        while(!posQ.isEmpty()){
            int options = posQ.size();
            while(options-->0){
                int pos = posQ.poll();
                if(pos == target) return moves;
                for(int i=pos+1; i<=Math.min(bs*bs,pos+6);i++){
                    int[] curr = boardPos(bs,i);
                    int bValue = board[curr[0]][curr[1]];
                    if(bValue==-1) bValue = i;
                    if(visited[bValue-1]) continue;
                    posQ.offer(bValue);
                    visited[bValue-1]=true;
                }
            }
            moves++;
        }
        return -1;
    }

    int[] boardPos(int bs, int pos){
        int row = (pos-1)/bs;
        int col;
        col = (pos-1)%bs;
        if(row%2==1) col = bs-col-1;
        return new int[]{bs-row-1,col};
    }

    public static void main(String[] args) {
        SnakesAndLadders game = new SnakesAndLadders();
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(game.snakesAndLadders(board));
    }
}
