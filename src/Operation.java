import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

public enum Operation {
    ADD((x,y) -> x + y, "A"),
    SUBTRACT((x,y) -> x - y, "S"),
    MULTIPLY((x,y) -> x * y, "M"),
    DIVIDE((x,y) -> x / y, "D");
    private final String dbVal;
    private final IntBinaryOperator op;
    private static final Map<String,Operation> VAL_MAP = Stream.of(values())
                                                  .collect(Collectors.toMap(o -> o.dbVal, o -> o));

    Operation(IntBinaryOperator op, String dbVal) {
        this.op = op;
        this.dbVal = dbVal;
    }
    public static Operation fromString(String dbVal){
        return  VAL_MAP.get(dbVal);
    }

    public String todBValue(){
        return dbVal;
    }

    //public abstract double apply(double x,double y);
}
