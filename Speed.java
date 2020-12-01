public class Speed {
    public Double calculate(long second, int finalPoint, int initialPoint) {
        if (second == 0)
            second = 1;

        return (double) ((finalPoint - initialPoint) / second);
    }
}
