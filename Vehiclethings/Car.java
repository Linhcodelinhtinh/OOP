package OOP.Vehiclethings;

public class Car extends MotorVehicle {
    int numDoors;
    public void init(String licensePlate, String brand, int numDoors){
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.numDoors = numDoors;
    }
    @Override
    public double getFuelConsumption() {
        return ((double) mileage /100)*8.5;
    }
    @Override
    public String getType(){
        return "Car";
    }
    @Override
    public double calculateMaintenanceCost(){
        return mileage*0.05;
    }

}
