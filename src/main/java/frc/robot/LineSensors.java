package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LineSensors {
    private  DigitalInput right = new DigitalInput(RobotMap.lineSensorRight);
    private  DigitalInput left = new DigitalInput(RobotMap.lineSensorLeft);

    public boolean getIsLeft() {
        return !left.get() && right.get();
    }
    public boolean getIsOnTarget() {
        return left.get() && right.get();
    }
    public boolean getIsRight() {
        return left.get() && !right.get();
    }
    public boolean notOnTarget() {
        return !left.get() && !right.get();
    }
}
