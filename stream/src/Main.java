import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        for (Integer i : intList) {
            if ((i > 0) && (i % 2 == 0)) {
                newList.add(i);
            }
        }
        newList.sort(Comparator.naturalOrder());
        for (Integer i : newList) {
            System.out.println(i);
        }
    }
}