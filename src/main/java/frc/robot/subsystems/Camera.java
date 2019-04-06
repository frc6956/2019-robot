/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.CameraSwitch;

/**
 * This is the camera 
 */
public class Camera extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private boolean isFrontCamera = true;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new CameraSwitch());
  }

  UsbCamera frontCamera;
  UsbCamera backCamera;
  VideoSink server;
public Camera() {
  frontCamera = CameraServer.getInstance().startAutomaticCapture(0);
  backCamera = CameraServer.getInstance().startAutomaticCapture(1);
  server = CameraServer.getInstance().getServer();
}

  public void useBackCamera() {
    if (isFrontCamera) {
      server.setSource(backCamera);
    }
  }

  public void useFrontCamera() {
    if(!isFrontCamera) {
      server.setSource(frontCamera);
    }
  }

}
