package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LineSensors {
    private static DigitalInput right;
    private static DigitalInput left;
    public LineSensors(DigitalInput r, DigitalInput l) {
        right = r;
        left = l;
    }
    public static boolean getIsOnLine(DigitalInput lineSensor) {
        return lineSensor.get();
    }
    public static boolean getIsLeft() {
        return !left.get() && right.get();
    }
    public static boolean getIsOnTarget() {
        return left.get() && right.get();
    }
    public static boolean getIsRight() {
        return left.get() && !right.get();
    }
}