/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6514.irecharge.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6514.irecharge.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlPanelRotate extends Command {
  /**
   * Creates a new RotatePanel.
   */

  public ControlPanelRotate() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.controlPanelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.controlPanelSubsystem.StartColourDetectedCount = 0;
    Robot.controlPanelSubsystem.StartColour = Robot.controlPanelSubsystem.CurrentColourString;
    Robot.controlPanelSubsystem.CurrentColour = Robot.controlPanelSubsystem.StartColour;
    Robot.controlPanelSubsystem.StartColourDetected = true;
    Robot.controlPanelSubsystem.ControlPanelRotateClockwise();

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.controlPanelSubsystem.ControlPanelRotateClockwise();
    Robot.controlPanelSubsystem.CurrentColour = Robot.controlPanelSubsystem.CurrentColourString;
    if(Robot.controlPanelSubsystem.StartColourDetected)
    {
      if (Robot.controlPanelSubsystem.CurrentColour == Robot.controlPanelSubsystem.StartColour)
      {
        //Do nothing .. Wait for colour to change

      }
      else 
      {
        Robot.controlPanelSubsystem.StartColourDetected = false;
      }
    }
    else if (Robot.controlPanelSubsystem.CurrentColour == Robot.controlPanelSubsystem.StartColour) {
      Robot.controlPanelSubsystem.StartColourDetected = true;
      Robot.controlPanelSubsystem.StartColourDetectedCount = Robot.controlPanelSubsystem.StartColourDetectedCount + 1;
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    Robot.controlPanelSubsystem.ControlPanelRotationStop();
    Robot.controlPanelSubsystem.StartColour = "STOP / DONE";
    

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //TODO:  NOTE  The colour that we see is not the colour that the FMS sees!  We will need to allow addtional rotation to the colour based an offset.
    Boolean isDone = false;
    if (Robot.controlPanelSubsystem.StartColourDetectedCount > 6) {
      if (Robot.controlPanelSubsystem.CurrentColour == Robot.controlPanelSubsystem.GetGameData()) {
        isDone = true;
      }
    }
    return isDone;
  }
}
