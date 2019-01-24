package frc.robot;

public class LineSensors {
    public static boolean getIsOnLine() {
        return Robot.lineSensor.get();
    }
}