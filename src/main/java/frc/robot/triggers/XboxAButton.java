/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.XboxController;

/**
 * Xbox A button
 */
public class XboxAButton extends XboxButton {

  public XboxAButton(XboxController controller) {
    super(controller);
  }

  @Override
  public boolean get() {
    return controller.getAButton();
  }
}
