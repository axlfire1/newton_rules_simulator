
public class SecondNewtonLaw {

    private static double frictionRailCoefficient = 0.11;
    private static double frictionTireRoadCoefficient = 0.49;
    private static double gravityAcceleration = 9.8;
    double mass = 0;
    double speed = 0;
    String veicle = "";

    // public static void main(String[] args) {
    // SecondNewtonLaw secondNewtonLaw = new SecondNewtonLaw(65.0, 14000.0,
    // "train");
    // System.out.println("FORCE:" + secondNewtonLaw.calculateForce());
    // }

    public SecondNewtonLaw(Double speed, Double mass, String veicle) {
        this.speed = speed;
        this.mass = mass;
        this.veicle = veicle;
        convertValuesToMeterSecondScale();
    }

    public void convertValuesToMeterSecondScale() {
        this.mass = mass * 1000;
        this.speed = speed * 10 / 36;
    }

    // step 1
    public Double calculateWeight() {
        return mass / gravityAcceleration;
    }

    // step 3
    public Double calculateMass() {
        return calculateWeight() / gravityAcceleration;
    }

    public Double calculateAcceleration() {
        return (speed - this.speed) / (22 - 1);
    }

    public Double calculateForce() {
        Double m = calculateMass();
        Double a = calculateAcceleration();

        if (this.veicle.equals("train") || this.veicle.equals("interurban"))
            return (a * m) + ((frictionRailCoefficient * gravityAcceleration) * m);
        else {
            return (a * m) + ((frictionTireRoadCoefficient * gravityAcceleration) * m);
        }
    }
}
