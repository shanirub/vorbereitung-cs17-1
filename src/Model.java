import java.text.DecimalFormat;

public class Model {
    double meter, inch, foot, yard;
    String unit;
    StringBuilder builder;

    private void setMeter(double m) {
        meter = m;
        inch = 1 / 0.0254 * m;
        foot = 1 / 0.3048 * m;
        yard = 1 / 0.9144 * m;
    }

    private void setInch(double i) {
        meter = 0.0245 * i;
        inch = i;
        foot = 1. / 12 * i;
        yard = 1. / 36 * i;
    }

    private void setFoot(double f) {
        meter = 0.3048 * f;
        inch = 12 * f;
        foot = f;
        yard = 1. / 3. * f;
    }

    private void setYard(double y) {
        meter = 0.9144 * y;
        inch = 36 * y;
        foot = 3 * y;
        yard = y;
    }

    public void calculate(double value, String unit) {
        switch (unit) {
            case "meter":
                setMeter(value);
                break;
            case "inch":
                setInch(value);
                break;
            case "yard":
                setYard(value);
                break;
            case "foot":
                setFoot(value);
                break;
        }
    }

    public void initialise(double startValue, String startUnit) {
        setMeter(startValue);
        builder = new StringBuilder(startUnit);
    }

    public String format(double value) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(4);
        return decimalFormat.format(value);
    }
}
