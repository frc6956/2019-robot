/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // USB
  public static final int driverController = 0;
  public static final int operatorController = 1;
  public static final int driverControllerLeft = 2;
  public static final int driverControllerRight = 3;

  // CAN
  public static final int leftDriveMotor = 2;
  public static final int leftDriveSPX1 = 1;
  public static final int leftDriveSPX2 = 2;
  public static final int rightDriveMotor = 1;
  public static final int rightDriveSPX1 = 3;
  public static final int rightDriveSPX2 = 4;

  // PCM
  public static final int doubleSolenoidA = 1;
  public static final int doubleSolenoidB = 0;

  // PWM
  public static final int cargoHandlerArm = 0;
  public static final int cargoHandlerWheels = 1;
  public static final int dartHandlerLeft = 2;
  public static final int dartHandlerRight = 3;

  // Analog Ports
  public static final int dartPOTLeft = 1;
  public static final int dartPOTRight = 0;
  public static final int pressureSensor = 3;
  public static final int stringPot = 2;

  // Digital Ports
  public static final int lineSensorRight = 1;
  public static final int lineSensorLeft = 0;
}