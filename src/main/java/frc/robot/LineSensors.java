package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LineSensors {
    public static boolean getIsOnLine(DigitalInput lineSensor) {
        return lineSensor.get();
    }
}