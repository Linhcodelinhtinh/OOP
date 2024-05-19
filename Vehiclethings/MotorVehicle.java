package OOP.Vehiclethings;

public abstract class MotorVehicle implements Vehicle {
    String licensePlate;
    String brand;
    int mileage;
    public void start(){
        System.out.println("Vehicle "+ brand +" is starting.");
    }
    public void stop(){
        System.out.println("Vehicle "+ brand +" is stopping.");
    }
    public double getFuelConsumption(){
        return 0;
    }
    public int getMileage(){
        return mileage;
    }
    public void drive(int distance){
        mileage += distance;
    }
}
