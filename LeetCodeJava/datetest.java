import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class datetest {
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.get(0));
        if (list.get(0) == null) {
            System.out.println("I am here");
        }
    }
}
