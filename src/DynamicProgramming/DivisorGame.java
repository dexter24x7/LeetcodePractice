package DynamicProgramming;
//1025. Divisor Game
/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.
 */
public class DivisorGame {
    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        int num = (int) (Math.random()*1000);
        System.out.println(divisorGame(num));
    }


}
/*
Intuition
The Divisor Game is a mathematical game, and the optimal strategy can be determined by understanding the
properties of even and odd numbers. The rules of the game are such that Alice goes first and can only win
if she makes a move that ensures the number Bob receives is odd. This is because odd numbers have only odd
factors (other than 1 and themselves). When an odd number is reduced by one of its odd factors, the result
is an even number.

Since Alice always goes first, if the initial number is even, she can always subtract 1 (which is the only
odd divisor of an even number), resulting in an odd number for Bob. Bob will then be forced to pass an even
number back, and so on. By following this strategy, Alice will always end up with the number 2 on her turn,
subtract 1, and win the game.
 */