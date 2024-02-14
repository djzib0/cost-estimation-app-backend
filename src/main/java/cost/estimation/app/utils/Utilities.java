package cost.estimation.app.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilities {

    public Double roundDouble(Double number, Integer decimalPlaces) {
        if (decimalPlaces < 0) {
            decimalPlaces = 2;
        }

        BigDecimal bd = new BigDecimal(number);
        BigDecimal roundedOffBd = bd.setScale(decimalPlaces, java.math.RoundingMode.HALF_EVEN);
        return roundedOffBd.doubleValue();
    }

    public Double calculateRectPlateSurface(Double dimA, Double dimB, Double thickness, Integer sidesToBePainted) {
        Double surface;
        thickness = thickness / 1000; // mm to meter
        if (sidesToBePainted == 1) {
            surface = (2 * dimA * dimB) + (2 * dimA * thickness) + (2 * dimB * thickness);
            return roundDouble(surface / 2, 2);
        }
        surface = (2 * dimA * dimB) + (2 * dimA * thickness) + (2 * dimB * thickness);
        return roundDouble(surface, 2);
    }

}
