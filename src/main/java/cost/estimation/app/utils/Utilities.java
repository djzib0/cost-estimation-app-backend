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
        dimA = dimA / 1000; //mm to meter
        dimB = dimB / 1000; //mm to meter
        if (sidesToBePainted == 1) {
            surface = (2 * dimA * dimB) + (2 * dimA * thickness) + (2 * dimB * thickness);
            return roundDouble(surface / 2.0, 2);
        }
        surface = (2.0 * dimA * dimB) + (2 * dimA * thickness) + (2 * dimB * thickness);
        return roundDouble(surface, 2);
    }

    public Double calculatePlateWeight(Double dimA, Double dimB, Double thickness, Double density, Boolean isRing) {

        System.out.println(dimB);
        // if inner diameter of ring is bigger than 500mm (0.5 meter)
        // weight is reduced by weight of square in inner circle
        if (isRing && dimB  <= 0.5 ) {
            System.out.println(isRing);
            return roundDouble(dimA * dimA * thickness * density, 2);
        } else if (isRing) {
            Double weight = dimA * dimA * thickness * density;
            Double weightOfSquareInCircle = (Math.pow(dimB, 2) / 2) * thickness * density;
            return roundDouble(weight - weightOfSquareInCircle, 2);
        }
        return roundDouble(dimA * dimB * thickness * density, 2);
    }
}
