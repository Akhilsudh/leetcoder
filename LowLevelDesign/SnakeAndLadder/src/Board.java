import java.util.*;
import java.util.stream.Collectors;

public class Board {
    Set<Snake> snakes;
    Set<Ladder> ladders;

    public Board() {
        this.snakes = new HashSet<>();
        this.ladders = new HashSet<>();
    }

    public Board(Set<Snake> snakes, Set<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public void addSnake(int start, int end) {
        if(!snakes.stream().filter(snake -> snake.getStart() == start).toList().isEmpty()) {
            throw new RuntimeException("Snake head already in start position");
        }
        snakes.add(new Snake(start, end));
        System.out.println("Snake added");
    }

    public void addLadder(int start, int end) {
        if(!ladders.stream().filter(ladder -> ladder.getStart() == start).toList().isEmpty()) {
            throw new RuntimeException("Ladder head already in start position");
        }
        ladders.add(new Ladder(start, end));
        System.out.println("Ladder added");
    }

    public Snake getSnakesForPosition(int position) {
        List<Snake> list = snakes.stream().filter(snake -> snake.getStart() == position).toList();
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public Ladder getLadderForPosition(int position) {
        List<Ladder> list = ladders.stream().filter(ladder -> ladder.getStart() == position).toList();
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
