/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  private boolean isTank = false;
  private boolean isSplit = false;
  private boolean isJoystick = false;

  private XboxController driver = new XboxController(RobotMap.driverController);
  private XboxController xboxc1 = new XboxController(0);
  private XboxController operator = new XboxController(RobotMap.operatorController);
  private Joystick driverLeft = new Joystick(RobotMap.driverControllerLeft);
  private Joystick driverRight = new Joystick(RobotMap.driverControllerRight);

  public double getTankLeft()
  {
    if(isJoystick)
    {
      return -driverLeft.getY();
    }
    return -driver.getY(Hand.kLeft);
  }

  public double getTankRight()
  {
    if(isJoystick)
    {
      return -driverRight.getY();
    }
    return -driver.getY(Hand.kRight);
  }

  public double getArcadeY()
  {
    if(!isSplit && !isJoystick)
    {
    return -driver.getY(Hand.kLeft);
    }
    else if(isJoystick)
    {
      return -driverRight.getY();
    }
    else
    {
      return -driver.getY(Hand.kRight);
    }
  }

  public double getArcadeX()
  {
    if(isSplit && isJoystick)
    {
      return driverLeft.getX();
    }
    else if(isJoystick)
    {
      return driverRight.getX();
    }
    return driver.getX(Hand.kLeft);
  }

  public boolean getIsTank()
  {
    if(xboxc1.getXButtonReleased())
    {
      isTank=true;
      isSplit=false;
      isJoystick = false;
    }
    if(xboxc1.getYButtonReleased())
    {
      isTank=false;
      isSplit=false;
      isJoystick = false;
    }
    if(xboxc1.getBButtonReleased())
    {
      isTank=false;
      isSplit=true;
      isJoystick = false;
    }
    if(driverRight.getRawButtonReleased(5))
    {
      isTank=true;
      isSplit=false;
      isJoystick=true;
    }
    if(driverRight.getRawButtonReleased(4))
    {
      isTank=false;
      isSplit=true;
      isJoystick=true;
    }
    if(driverRight.getRawButtonReleased(6))
    {
      isTank=false;
      isSplit=false;
      isJoystick=true;
    }
    return isTank;
  }

  public boolean getIsJoystick()
  {
    return isJoystick;
  }
  
  

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
