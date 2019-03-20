package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class StringPot extends Subsystem {
    private AnalogInput pot;
    
    public StringPot(int portNum) {
        pot = new AnalogInput(portNum);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public double getValue() {
        return pot.getVoltage();
    }
}