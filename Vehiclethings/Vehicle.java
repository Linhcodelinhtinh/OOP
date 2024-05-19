package OOP.Vehiclethings;

public interface Vehicle {
    default void start(){}
    default void stop(){}
    default String getType(){
        return "";
    }
    public default double calculateMaintenanceCost(){
        return 0;
    }

}
