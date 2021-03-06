package by.task.shubelko.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Point {

    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.coordinateX, coordinateX) == 0 &&
                Double.compare(point.coordinateY, coordinateY) == 0 &&
                Double.compare(point.coordinateZ, coordinateZ) == 0;
    }

    @Override
    public int hashCode() {
        int result = 11;
        long longBits = Double.doubleToLongBits(this.coordinateX);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.coordinateY);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.coordinateZ);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", coordinateZ=" + coordinateZ +
                '}';
    }
}
