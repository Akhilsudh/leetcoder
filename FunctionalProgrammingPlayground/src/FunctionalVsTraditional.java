import java.util.List;
import java.util.function.Function;

public class FunctionalVsTraditional {
    public static void main(String[] args) {
        FunctionalVsTraditional obj = new FunctionalVsTraditional();
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        obj.printEvenNumsTraditional(list);
        System.out.println("\n========================");
        obj.printEvenNumsFunctional(list);
        System.out.println("\n========================");
        obj.printSquareNumsFunctional(list);
    }

    private void printEvenNumsTraditional(List<Integer> list) {
        for(int num: list) {
            if(num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }

    private void printEvenNumsFunctional(List<Integer> list) {
        list.stream()
            .filter(i -> i%2 == 0)
            .forEach(i -> System.out.print(i + " "));
        // We can also use a method reference this::print
    }

    private void printSquareNumsFunctional(List<Integer> list) {
        list.stream()
            .map(i -> i * i)
            .forEach(i -> System.out.print(i + " "));
    }
}