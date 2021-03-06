/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static OI m_oi;
  public static Drivetrain drivetrain;
  public static Gyro gyro;
  public static LineSensors lineSensors = new LineSensors();
  public static Arduino arduino = new Arduino();
  public static PowerDistributionPanel pdp = new PowerDistributionPanel();
  public static Compressor compressor = new Compressor();
  public static CargoHandler cargoHandler = new CargoHandler();
  public static HatchHandler hatchHandler = new HatchHandler();
  public static Arm arm = new Arm();
  public static Dart dartLeft = new Dart(RobotMap.dartHandlerLeft, RobotMap.dartPOTLeft, 4.0, 0.29);
  public static Dart dartRight = new Dart(RobotMap.dartHandlerRight, RobotMap.dartPOTRight, 4.0, 0.48);
  public static PressureSensor pneumaticPressure = new PressureSensor(RobotMap.pressureSensor);
  public static Camera camera = new Camera();

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    drivetrain = new Drivetrain();
    gyro = new GyroPigeon();
    m_oi = new OI();
    
    m_chooser.setDefaultOption("Do nothing", null);
    m_chooser.addOption("Drive Distance", new DriveDistance(30));
    SmartDashboard.putData("Auto mode", m_chooser);
    

    pdp.clearStickyFaults();
    compressor.clearAllPCMStickyFaults();
    SmartDashboard.putData("PDP", pdp);
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
    SmartDashboard.putNumber("Dart Left", dartLeft.getPosition());
    SmartDashboard.putNumber("Dart Right", dartRight.getPosition());
    SmartDashboard.putNumber("Pressure", pneumaticPressure.getPressure());
    SmartDashboard.putNumber("Arm Position", arm.getPosition());
   // SmartDashboard.putNumber("gyro", gyro.getAngle());
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
   * to the switch structure below with additional strings and commands.
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
  
  public void sendLineSensor() {
    boolean LnSensors[] = new boolean[3];
      LnSensors[0] = lineSensors.getIsLeft();
      LnSensors[1] = lineSensors.getIsOnTarget();
      LnSensors[2] = lineSensors.getIsRight();
    /*SmartDashboard.putBoolean("Left", LnSensors[0]);
    SmartDashboard.putBoolean("Center", LnSensors[1]);
    SmartDashboard.putBoolean("Right", LnSensors[2]);*/
  }
}
