package vehicles;

public class HeavyVehicle extends Vehicle {
    private double weight;

    public HeavyVehicle(int modelNumber, int enginePower, double tireSize, double weight) {
        super(modelNumber, 3, enginePower, tireSize);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public void showFullDetails() {
        System.out.println("Model Number: " + this.getModelNumber() +
                ", Engine Type: " + this.getEngineType() +
                ", Engine Power: " + this.getEnginePower() + " HP" +
                ", Weight: " + this.getWeight() + " KG" +
                ", Tire Size: " + this.getTireSize() + "Inch"
        );
    }
}
