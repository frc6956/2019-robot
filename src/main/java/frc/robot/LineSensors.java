package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LineSensors {
    public static boolean getIsOnLine(DigitalInput lineSensor) {
        return lineSensor.get();
    }
    public static boolean getIsLeft(DigitalInput right, DigitalInput left) {
        return left.get() && !right.get();
    }
    public static boolean getIsOnTarget(DigitalInput right, DigitalInput left) {
        return left.get() && right.get();
    }
    public static boolean getIsRight(DigitalInput right, DigitalInput left) {
        return !left.get() && right.get();
    }
}