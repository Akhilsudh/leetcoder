import java.util.Random;

public class Die {
    int numFaces;

    public Die(int faces) {
        numFaces = faces;
    }

    public int rollDie() {
        Random random = new Random();
        return random.nextInt(1, numFaces + 1);
    }
}
