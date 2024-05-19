package OOP.Vehiclethings;

public class Motorcycle extends MotorVehicle {
    boolean hasSidecar;
    public void init(String licensePlate, String brand, boolean hasSidecar){
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.hasSidecar = hasSidecar;
    }
    @Override
    public double getFuelConsumption() {
        return ((double) mileage /100)*3.5;
    }
    @Override
    public String getType(){
        return "Motorcycle";
    }
    @Override
    public double calculateMaintenanceCost(){
        return mileage*0.03;
    }
}
