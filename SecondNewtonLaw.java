
public class SecondNewtonLaw {

    public static double frictionRailCoefficient = 0.11;
    public static double frictionTireRoadCoefficient = 0.49;
    public static double gravityAcceleration = 9.8;
    public double mass = 0;
    double speedInitial = 0;
    double speedFinal = 0;
    long elapsedtime = 0;

    String veicle = "";

    public SecondNewtonLaw(int speedFinal, Double mass, String veicle) {
        this.mass = mass;
        this.veicle = veicle;
        this.speedFinal = speedFinal;
        convertValuesToMeterSecondScale();
    }

    public void convertValuesToMeterSecondScale() {
        this.mass = mass * 1000;
    }

    // step 1
    public Double calculateWeight() {
        return (float) Math.round((mass / gravityAcceleration) * 100.0) / 100.0;
    }

    // step 3
    public Double calculateMass() {
        return mass;
    }

    public Double calculateAcceleration() {
        // 22 final time
        // 1 initial time
        convertValuesToMeterSecondScale();
        double a = (this.speedFinal - 0.02) / (23 - 1);
        return Math.round(a * 100.0) / 100.0;
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

        return force / 1000;
    }
}
