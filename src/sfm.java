import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.util.Comparator;
import java.util.Formattable;
import java.util.Formatter;

import static com.google.common.base.Preconditions.checkArgument;

public class sfm implements Formattable,Comparable<sfm> {


    private final int areaCode;
    private final int phoneNum;

    private sfm(int areaCode, int phoneNum){
        this.areaCode = areaCode;
        this.phoneNum = phoneNum;

    }

    public static void main(String[] args){

        new Main().main();
    }

    public static sfm of(int areaCode, int phoneNum) {
        checkArgument(areaCode > 100);
        checkArgument(phoneNum > 1000);


        return new sfm(areaCode, phoneNum);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof sfm){
            sfm com = (sfm) obj;
            return com.areaCode == this.areaCode && com.phoneNum == this.phoneNum;
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("areaCode",areaCode)
                .add("phone number",phoneNum)
                .toString();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d",areaCode,phoneNum);

    }


    @Override
    public int compareTo(sfm o) {
        // Java API Implementation
            /*
            return Comparator.comparingInt((sfm a) -> a.areaCode)
                    .thenComparingInt(a -> a.phoneNum)
                    .compare(this,(sfm) o);
            */
        // GUAVA IMPLEMENTATION

        return ComparisonChain.start()
                .compare(this.areaCode,((sfm) o).areaCode)
                .compare(this.phoneNum,((sfm) o).phoneNum)
                .result();

    }
}
class Main{

    public static void main(){
        sfm test = sfm.of(120000,30000);
        sfm eq = sfm.of(120000,3000);
        System.out.println(test.equals(eq));

        System.out.println(test.toString());  // toString Implementation
        System.out.println(String.format("%s",test));// Formattable Implementation

        System.out.println(test.compareTo(eq)); // CompareTo Implementation
    }
}