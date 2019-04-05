/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoAlignHatch extends Command {
  private final double forwardSpeed = 0.4;
  private final double reverseSpeed = -0.3;

  private boolean wasReversed;
  private boolean foundLine;
  private boolean wasTooLeft;
  private boolean wasTooRight;

  public AutoAlignHatch() {
		requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Make the hatch mechanism the 'front' of the robot
    wasReversed = Robot.drivetrain.isReversed();
    Robot.drivetrain.reverse(true);

    foundLine = false;
    wasTooLeft = false;
    wasTooRight = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftSpeed = forwardSpeed;
    double rightSpeed = forwardSpeed;

    if (Robot.lineSensors.getIsLeft()) {
      rightSpeed = 0;
      foundLine = true;
      wasTooLeft = true;
      wasTooRight = false;
    } else if (Robot.lineSensors.getIsRight()) {
      leftSpeed = 0;
      foundLine = true;
      wasTooLeft = false;
      wasTooRight = true;
    } else if (Robot.lineSensors.getIsOnTarget()) {
      foundLine = true;
      wasTooLeft = false;
      wasTooRight = false;
    } else if (foundLine) {
      // Was on the line but lost it
      leftSpeed = reverseSpeed;
      rightSpeed = reverseSpeed;
      if (wasTooLeft) {
        leftSpeed = 0;
      } else if (wasTooRight) {
        rightSpeed = 0;
      } else {
        // ??? Just keep backing up
      }
    }

    Robot.drivetrain.setTankDrive(leftSpeed, rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.drivetrain.isLeftStalled() && Robot.drivetrain.isRightStalled());
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.setTankDrive(0, 0);
    Robot.drivetrain.reverse(wasReversed);
  }
}
