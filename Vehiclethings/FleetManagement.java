package OOP.Vehiclethings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FleetManagement {
    List<Vehicle> vehicles;
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void removeVehicle(String licensePlate) {
        Vehicle v = findVehicleByLicensePlate(licensePlate);
        vehicles.remove(v);
    }
    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if(Objects.equals(vehicle.getType(), "Car")){
                Car car = (Car) vehicle;
                if(Objects.equals(car.licensePlate, licensePlate))
                    return car;
            }
            else if(Objects.equals(vehicle.getType(), "Motorcycle")){
                Motorcycle motorcycle = (Motorcycle) vehicle;
                if(Objects.equals(motorcycle.licensePlate, licensePlate))
                    return motorcycle;
            }
        }
        return null;
    }
    public double calculateTotalFuelConsumption(){
        double totalFuelConsumption = 0;
        for (Vehicle vehicle : vehicles) {
            if(Objects.equals(vehicle.getType(), "Car")){
                Car car = (Car) vehicle;
                totalFuelConsumption += car.getFuelConsumption();
            }
            else if(Objects.equals(vehicle.getType(), "Motorcycle")){
                Motorcycle motorcycle = (Motorcycle) vehicle;
                totalFuelConsumption += motorcycle.getFuelConsumption();
            }
        }
        return totalFuelConsumption;
    }
    public int getTotalMileage(){
        int totalMileage = 0;
        for (Vehicle vehicle : vehicles) {
            if(Objects.equals(vehicle.getType(), "Car")){
                Car car = (Car) vehicle;
                totalMileage += car.getMileage();
            }
            else if(Objects.equals(vehicle.getType(), "Motorcycle")){
                Motorcycle motorcycle = (Motorcycle) vehicle;
                totalMileage += motorcycle.getMileage();
            }
        }
        return totalMileage;
    }
    public double calculateTotalMaintenanceCost(){
        double totalMaintenanceCost = 0;
        for (Vehicle vehicle : vehicles) {
            if(Objects.equals(vehicle.getType(), "Car")){
                Car car = (Car) vehicle;
                totalMaintenanceCost += car.calculateMaintenanceCost();
            }
            else if(Objects.equals(vehicle.getType(), "Motorcycle")){
                Motorcycle motorcycle = (Motorcycle) vehicle;
                totalMaintenanceCost += motorcycle.calculateMaintenanceCost();
            }
        }
        return totalMaintenanceCost;
    }
    public List<Vehicle> sortVehiclesByMileage(List<Vehicle> vehicles) {
        List<Vehicle> sortedVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            if(Objects.equals(vehicle.getType(), "Car")){
                Car vec = (Car) vehicle;
            }
            else if(Objects.equals(vehicle.getType(), "Motorcycle")){
                assert vehicle instanceof Motorcycle;
                Motorcycle vec = (Motorcycle) vehicle;
            }
        }
        return sortedVehicles;
    }
    public List<Vehicle> sortVehiclesByMileage2() {
        List<Vehicle> sortedVehicles = new ArrayList<Vehicle>();
        return sortedVehicles;
    }
    public Vehicle findVehicleWithMaxMileage(){
        vehicles = sortVehiclesByMileage(vehicles);
        return vehicles.getFirst();
    }
}
