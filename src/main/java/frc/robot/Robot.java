/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Gyro;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DigitalInput lineSensorZero = new DigitalInput(RobotMap.lineSensorZero);
  public static DigitalInput lineSensorOne = new DigitalInput(RobotMap.lineSensorOne);
  public static DigitalInput lineSensorTwo = new DigitalInput(RobotMap.lineSensorTwo);
  public static DigitalInput lineSensorThree = new DigitalInput(RobotMap.lineSensorThree);
  public static DigitalInput lineSensorFour = new DigitalInput(RobotMap.lineSensorFour);
  public static DigitalInput lineSensorFive = new DigitalInput(RobotMap.lineSensorFive);
  public static DigitalInput lineSensorSix = new DigitalInput(RobotMap.lineSensorSix);
  public static DigitalInput lineSensorSeven = new DigitalInput(RobotMap.lineSensorSeven);
  public static DigitalInput lineSensorEight = new DigitalInput(RobotMap.lineSensorEight);
  public static OI m_oi;

  public static Drivetrain drivetrain = new Drivetrain();
  //add the Navigation file for Gyro
 // public static Gyro gyro = new Navigation(); 

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Drive Distance", new DriveDistance(60));
    m_chooser.addOption("Do nothing", null);

    SmartDashboard.putData("Auto mode", m_chooser);
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    sendLineSensor();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
  //
  public void sendLineSensor() {
    boolean LnSensors[] = new boolean[9];
      LnSensors[0] = LineSensors.getIsOnLine(lineSensorZero);
      LnSensors[1] = LineSensors.getIsOnLine(lineSensorOne);
      LnSensors[2] = LineSensors.getIsOnLine(lineSensorTwo);
      LnSensors[3] = LineSensors.getIsOnLine(lineSensorThree);
      LnSensors[4] = LineSensors.getIsOnLine(lineSensorFour);
      LnSensors[5] = LineSensors.getIsOnLine(lineSensorFive);
      LnSensors[6] = LineSensors.getIsOnLine(lineSensorSix);
      LnSensors[7] = LineSensors.getIsOnLine(lineSensorSeven);
      LnSensors[8] = LineSensors.getIsOnLine(lineSensorEight);
    SmartDashboard.getBooleanArray("On Line?", LnSensors);
  }
}
