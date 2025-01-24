import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! lets play snakes and ladders!!");
        Game game = new Game();
        Board board = new Board();
        game.addBoard(board);
        game.addDie(6);
        game.addPlayer("Akhil");
        game.addPlayer("Nihaar");
        game.addPlayer("Anu");
        game.addPlayer("Sudhakaran");
        board.addLadder(21, 40);
        board.addLadder(4, 25);
        board.addLadder(13, 20);
        board.addLadder(8, 70);

        board.addSnake(99, 8);
        board.addSnake(24, 12);
        board.addSnake(19, 9);
        board.addSnake(80, 60);

        while(game.winningPlayer == null) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            game.playTurn();
        }
        System.out.println("The winner is: " + game.winningPlayer.getName());



    }
}