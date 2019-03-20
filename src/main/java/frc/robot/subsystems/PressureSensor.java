package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PressureSensor extends Subsystem {
    private AnalogInput pSensor;
    
    public PressureSensor(int portNum) {
        pSensor = new AnalogInput(portNum);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public double getPressure() {
        double pressure = (250*(pSensor.getVoltage()/5))-25;
        return pressure;
    }
}