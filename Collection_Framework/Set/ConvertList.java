import java.util.Arrays;
import java.util.List;

public class ConvertList {

    public static void main(String[] args)
    {
        String[] cars = {"Honda", "bmw", "verna", "ford"};
        List<String> carList = Arrays.asList(cars);
 System.out.println(carList.getClass().getName());
 //carList.add("merc");
        for (String car : carList) {
            System.out.println(car);
        }
    }
}
