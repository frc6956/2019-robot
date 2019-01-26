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
  
  //USB
  public static final int driverController = 0;
  public static final int operatorController = 1;
  public static final int driverControllerLeft = 2;
  public static final int driverControllerRight = 3;
  //CAN
  //Charlie
 // public static final int leftDriveMotor = 0;
//  public static final int rightDriveMotor = 1;

//Tempest
  public static final int rightDriveMotor = 1;
	public static final int leftDriveMotor = 2;
	public static final int rightDriveMotor2 = 1;
	public static final int leftDriveMotor2 = 2;
  // Roborio map of Digital Inputs
  public static final int lineSensorZero = 0;
  public static final int lineSensorOne = 1;
  //Analog Ports
 // public static final int potentiometer = 0;
  public static final int gyro = 1;
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}