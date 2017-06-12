/**
 * Created by Zalew on 2017-06-12.
 */
public enum Select {
    PESEL("0"), REGON("1"), NIP("2");

    private final String valueId;
    Select(String valueId) {
        this.valueId = valueId;
    }
    public String value(){
        return valueId;
    }
}
