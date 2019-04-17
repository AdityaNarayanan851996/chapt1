import static com.google.common.base.Preconditions.checkArgument;

public class sfm {
    private final int areaCode;
    private final int phoneNum;

    private sfm(int areaCode, int phoneNum){
        this.areaCode = areaCode;
        this.phoneNum = phoneNum;

    }

    public static void main(String[] args){

        new Main().main();

        System.out.println("KLOL");
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
}
class Main{

    public static void main(){
        sfm test = sfm.of(120000,3000);
        sfm eq = sfm.of(120000,3000);
        System.out.println(test.equals(eq));

        System.out.println(test);
        System.out.println();
    }
}