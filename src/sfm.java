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
        return new sfm(areaCode, phoneNum);
    }
}
class Main{

    public static void main(){
        sfm test = sfm.of(12,3);
        System.out.println(test);

    }
}