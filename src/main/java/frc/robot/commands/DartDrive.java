/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Dart;

/**
 * Add your docs here.
 */
public class DartDrive extends Command{
    public DartDrive() {
        requires(Robot.dartLeft);
        requires(Robot.dartRight);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(Robot.m_oi.getDartUp()) {
            Robot.dartLeft.setMotorSpeed(Robot.dartLeft.speedLimit);
            Robot.dartRight.setMotorSpeed(Robot.dartLeft.speedLimit);
        }
        else if(Robot.m_oi.getDartDown()) {
            Robot.dartLeft.setMotorSpeed(-Robot.dartLeft.speedLimit);
            Robot.dartRight.setMotorSpeed(-Robot.dartLeft.speedLimit);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
