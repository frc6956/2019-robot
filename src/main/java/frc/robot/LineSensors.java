package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
/**
 * This class provides an interface for the digital line sensors.
 */
public class LineSensors {
    private  DigitalInput right = new DigitalInput(RobotMap.lineSensorRight);
    private  DigitalInput left = new DigitalInput(RobotMap.lineSensorLeft);

    /**
     * Reads the line sensors and determines if the robot is on a line but too far to the left.
     * @return true if too far to the left, false if not
     */
    public boolean getIsLeft() {
        return !left.get() && right.get();
    }
    /**
     * Reads the line sensors and determines if the robot is perfectly centered on a line.
     * @return true if on a line, false if not
     */
    public boolean getIsOnTarget() {
        return left.get() && right.get();
    }
    /**
     * Reads the line sensors and determines if the robot is on a line but too far to the right.
     * @return true if too far to the right, false if not
     */
    public boolean getIsRight() {
        return left.get() && !right.get();
    }
    /**
     * Reads the line sensors and determines if the robot is not on a line.
     * @return true if the robot is not on a line, false if not
     */
    public boolean notOnTarget() {
        return !left.get() && !right.get();
    }
}
