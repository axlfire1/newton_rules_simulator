
public class SecondNewtonLaw {

    public static double frictionRailCoefficient = 0.11;
    public static double frictionTireRoadCoefficient = 0.49;
    public static double gravityAcceleration = 9.8;
    public double mass = 0;
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
        this.speed = (float) Math.round((speed * 10 / 36) * 100.0) / 100.0;
    }

    // step 1
    public Double calculateWeight() {
        return (float) Math.round((mass / gravityAcceleration) * 100.0) / 100.0;
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
        Double force;
        if (this.veicle.equals("train") || this.veicle.equals("interurban"))
            force = (a * m) + ((frictionRailCoefficient * gravityAcceleration) * m);
        else {
            force = (a * m) + ((frictionTireRoadCoefficient * gravityAcceleration) * m);
        }

        return (float) Math.round(force * 100.0) / 100.0;
    }
}
