import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(
                1,2,3,4,5,6,7,8
        );
        l.stream()
                .filter(k -> k%2 == 0)
                .forEach(k -> System.out.println(k));
        Map<String,Integer> map = l.stream()
                .collect(Collectors.toMap(c -> c.toString(),c -> c));

        for(String nam : map.keySet()){
            System.out.println(nam + " - " + map.get(nam));
        }

        Stream<Integer> str = l.parallelStream();
        long count = str.count();

        System.out.println(count + "<- Count");

        MylBda k = (int a, int b) -> a + b;
        System.out.println("FROM LAMBDA : " + k.add(5,3));

        Inner inner = new Inner(){
            public void disp(){
                System.out.println("HellNo");
            }
        };
        inner.disp();



    }
}
interface MylBda{
    int add(int a,int b);
}
abstract class Inner{
    void disp(){}
}