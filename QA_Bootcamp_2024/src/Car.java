import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String model;
    private String color;
    private String carType;
    private double  MAX_SPEED = 180;
    private double currentSpeed;
    private float cylinderCapacity;
    private float currentMileage;
    private double carPosition;
    private int MAX_GEAR = 6;
    private int currentGear;

    public Car(String model, String color, String carType, double currentSpeed, float cylinderCapacity, float currentMileage, double carPosition, int currentGear) {
        this.model = model;
        this.color = color;
        this.carType = carType;
        this.currentSpeed = currentSpeed;
        this.cylinderCapacity = cylinderCapacity;
        this.currentMileage = currentMileage;
        this.carPosition = carPosition;
        this.currentGear = currentGear;
    }

    public Car(String color, String carType, String model, float cylinderCapacity, double carPosition) {
        this.color = color;
        this.carType = carType;
        this.model = model;
        this.cylinderCapacity = cylinderCapacity;
        this.carPosition = carPosition;
    }

    public Car() {
    }

    public void startCar(){
        currentGear = 1;
        currentSpeed = 5;

    }

    public void steerLeft(float angle){
        carPosition -= angle;
    }

    public void steerRight(float angle){
        carPosition -= angle;
    }

    public void stopCar(){
        currentSpeed = 0;
        currentGear = 0;
    }

    public void increaseMileage(float mileage){
        currentMileage += mileage;
    }

    public void accelerate(double speedDelta){
        if (currentSpeed + speedDelta > MAX_SPEED){
            currentSpeed = MAX_SPEED;

        }
        else{
            currentSpeed += speedDelta;
        }
    }

    public void decelerate(double speedDelta){

        if (currentSpeed - speedDelta < 0){
            currentSpeed = 0;
        }
        else{
            currentSpeed -= speedDelta;
        }
            }

    public void gearUp(){
        if(currentGear == MAX_GEAR){

        }
        else{
            currentGear ++;
        }
    }

    public void gearDown(){
        if(currentGear > 0){

        }
        else{
            currentGear --;
        }
    }

    public void printCar(){
        System.out.println("------------------");
        System.out.println("Car model:" + model);
        System.out.println("Car color:" + color);
        System.out.println("Car type:" + carType);
        System.out.println("Car position(based on North):" + carPosition);
        System.out.println("Car mileage:"+ currentMileage);

    }

    public double setSpeed(double currentSpeed){
        if(currentSpeed > MAX_SPEED){
            System.out.println("Invalid speed " + currentSpeed);
        }
        else{
            this.currentSpeed = currentSpeed;
        }
        this.currentSpeed = currentSpeed;

        public double getSpeed() {
            return this.currentSpeed;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getMAX_SPEED() {
        return MAX_SPEED;
    }

    public void setMAX_SPEED(double MAX_SPEED) {
        this.MAX_SPEED = MAX_SPEED;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public float getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(float cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public float getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(float currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(double carPosition) {
        this.carPosition = carPosition;
    }

    public int getMAX_GEAR() {
        return MAX_GEAR;
    }

    public void setMAX_GEAR(int MAX_GEAR) {
        this.MAX_GEAR = MAX_GEAR;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }
}
