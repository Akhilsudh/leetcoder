import java.util.*;

public class Game {
    Board board;
    Queue<Player> players;

    Player winningPlayer;
    Die die;

    public Game() {
        players = new LinkedList<>();
    }
    public void addBoard(Board board) {
        this.board = board;
    }

    public void addPlayer(String name) {
        players.offer(new Player(name, 0));
    }

    public void addDie(int num) {
        this.die = new Die(num);
    }

    public void playTurn() {
        Player player = players.poll();
        if(player == null) {
            throw new RuntimeException("No player Invalid game");
        }
        int spots = die.rollDie();
        System.out.println(player.getName() + " rolled " + spots);
        int currentPlayerSpot = player.position + spots;
        Snake snake = board.getSnakesForPosition(currentPlayerSpot);
        Ladder ladder = board.getLadderForPosition(currentPlayerSpot);
        if(currentPlayerSpot > 100) {
            winningPlayer = player;
            System.out.println(player.getName() + " Won");
        } else if(snake!= null) {
            currentPlayerSpot = snake.getEnd();
            System.out.println(player.getName() + " was bit by a snake now player is in spot " + currentPlayerSpot);
        } else if(ladder != null) {
            currentPlayerSpot = ladder.getEnd();
            System.out.println(player.getName() + " climbed a ladder, player is in spot " + currentPlayerSpot);
        }
        player.position = currentPlayerSpot;
        players.offer(player);
    }
}
