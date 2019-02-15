/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Generic Xbox button
 */
public abstract class XboxButton extends Button {

  protected XboxController controller;
  protected Hand hand;

  public XboxButton(XboxController controller) {
    this.controller = controller;
  }

  public XboxButton(XboxController controller, Hand hand) {
    this(controller);
    this.hand = hand;
  }
}
