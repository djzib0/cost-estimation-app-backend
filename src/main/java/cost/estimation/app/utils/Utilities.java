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
            System.out.println(sidesToBePainted + " side to be painted");
            System.out.println(surface + " surface, 1 side to be painted");
            return roundDouble(surface / 2.0, 2);
        }
        surface = (2.0 * dimA * dimB) + (2 * dimA * thickness) + (2 * dimB * thickness);
        System.out.println(sidesToBePainted + " side to be painted");
        System.out.println(surface + " surface, 2 sides to be painted");
        return roundDouble(surface, 2);
    }

    public Double calculateSurfaceByDiameterAndLength(Double diameterInMeter, Double lengthInMeters) {
        return roundDouble((Math.PI *(diameterInMeter) * lengthInMeters), 2);
    }

    public Double calculatePlateWeight(Double dimA, Double dimB, Double thickness, Double density, Boolean isRing) {


        // if inner diameter of ring is bigger than 500mm (0.5 meter)
        // weight is reduced by weight of square in inner circle
        if (isRing && dimB  <= 0.5 ) {
            return roundDouble(dimA * dimA * thickness * density, 2);
        } else if (isRing) {
            Double weight = dimA * dimA * thickness * density;
            Double weightOfSquareInCircle = (Math.pow(dimB, 2) / 2) * thickness * density;
            return roundDouble(weight - weightOfSquareInCircle, 2);
        }
        return roundDouble(dimA * dimB * thickness * density, 2);
    }

    public Double calculateRoundbarWeight(Double diameter, Double length, Double density) {
        Double circleRadius = diameter / 2.0;
        Double circleArea = Math.PI * Math.pow(circleRadius, 2);
        return roundDouble(circleArea * length * density, 1);
    }

    public Double calculateRoundbarWeightPerMeter(Double diametedrInMeters, Double density) {
        Double circleRadius = diametedrInMeters / 2.0;
        Double circleArea = Math.PI * Math.pow(circleRadius, 2);
        return roundDouble(circleArea * 1000 * density, 1);
    }
}
