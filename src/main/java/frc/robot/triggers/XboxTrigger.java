/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Xbox trigger
 */
public class XboxTrigger extends XboxButton {

  public XboxTrigger(XboxController controller, Hand hand) {
    super(controller, hand);
  }

  @Override
  public boolean get() {
    return (controller.getTriggerAxis(hand) > 0.5);
  }
}
