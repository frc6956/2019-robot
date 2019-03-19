/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DartDrive;

/**
 * Add your docs here.
 */
public class Dart extends Subsystem{
    public Talon motor;
    public AnalogInput potentiometer;
    public double limitHigh = 5;
    public double limitLow = 0;
    public double speedLimit = .5;

    public Dart(int motorLoc, int potLocation) {
       motor = new Talon(motorLoc);
       potentiometer = new AnalogInput(potLocation); 
    }

    public Dart(int motorLoc, int potLocation, double limHigh, double limLow) {
        motor = new Talon(motorLoc);
        potentiometer = new AnalogInput(potLocation); 
        limitHigh = limHigh;
        limitLow = limLow;
    }


    @Override
    public void initDefaultCommand() {
      setDefaultCommand(new DartDrive());
    }

    public void setMotorSpeed(double speed) {
        if(speed>0 && potentiometer.getVoltage()<limitHigh || speed<0 && potentiometer.getVoltage()>limitLow) {
            motor.setSpeed(speed);
        } else {
            motor.setSpeed(0);
        }
    }

    public double getPosition() {
        return potentiometer.getVoltage();
    }

    public void setLimitHigh(double limHigh) {
        limitHigh = limHigh;
    }

    public void setLimitLow(double limLow) {
        limitHigh = limLow;
    }

    public void setMaxSpeed(double maxSpeed) {
        speedLimit = maxSpeed;
    }
}
