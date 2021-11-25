package by.task.shubelko.entity;

public class BallParameters {
    private double surfaceArea;
    private double volume;

    public BallParameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallParameters that = (BallParameters) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 11;
        long longBits = Double.doubleToLongBits(this.surfaceArea);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.volume);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BallParameters{");
        builder.append("surfaceArea=").append(surfaceArea);
        builder.append(", volume=").append(volume);
        builder.append("}");
        return builder.toString();
    }
}
