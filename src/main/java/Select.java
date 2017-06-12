
public enum Select {
    PESEL("0"), REGON("1"), NIP("2"), EAN8("12"), EAN13("13");

    private final String valueId;
    Select(String valueId) {
        this.valueId = valueId;
    }

    public String value(){
        return valueId;
    }
}
