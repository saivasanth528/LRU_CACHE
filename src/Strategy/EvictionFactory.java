package Strategy;


public class EvictionFactory {

    private String Strategy;
    private EvictionStrategyEnums strategyEnum;

    public Eviction getEvictionObject(String strategy) {
        switch(strategy) {
            case "FIRST_COME_EVICTION":
//                return new FirstComeEviction();
            default:
                return null;
        }
    }

}
