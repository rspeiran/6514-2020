// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6514.irecharge.subsystems;


import org.usfirst.frc6514.irecharge.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
    import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


/**
 *
 */
public class FuelSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Compressor compressor;
    private DoubleSolenoid doubleSolenoidHippo;
    private Spark hippoIntakeMotor;
    private Spark shooterTopMotor;
    private Encoder shooterTopEncoder;
    private Spark shooterBottomMotor;
    private Encoder shooterBottomEncoder;
    private Relay visionLightSpike;
    private PowerDistributionPanel powerDistributionPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private enum Direction {
        Forward,
        Reverse
    }

    private Direction HippoIntake = Direction.Forward;
    private double HippoIntakeSpeed = .40;
    private double HippoMotorStop =0;

    //0.43 speed
    private double ShooterTopMotorSpeed  = 0.42;
    private double ShooterBottomMotorSpped = 0.46;





    public FuelSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        compressor = new Compressor(0);
        addChild("Compressor",compressor);
        
        
        doubleSolenoidHippo = new DoubleSolenoid(0, 0, 1);
        addChild("DoubleSolenoidHippo",doubleSolenoidHippo);
        
        
        hippoIntakeMotor = new Spark(0);
        addChild("HippoIntakeMotor",hippoIntakeMotor);
        hippoIntakeMotor.setInverted(false);
        
        shooterTopMotor = new Spark(2);
        addChild("ShooterTopMotor",shooterTopMotor);
        shooterTopMotor.setInverted(false);
        
        shooterTopEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("ShooterTopEncoder",shooterTopEncoder);
        shooterTopEncoder.setDistancePerPulse(1.0);
        shooterTopEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        shooterBottomMotor = new Spark(3);
        addChild("ShooterBottomMotor",shooterBottomMotor);
        shooterBottomMotor.setInverted(false);
        
        shooterBottomEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("ShooterBottomEncoder",shooterBottomEncoder);
        shooterBottomEncoder.setDistancePerPulse(1.0);
        shooterBottomEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        visionLightSpike = new Relay(0);
        addChild("VisionLightSpike",visionLightSpike);
        
        
        powerDistributionPanel = new PowerDistributionPanel(0);
        addChild("PowerDistributionPanel",powerDistributionPanel);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void HippoExtendMech() {

        doubleSolenoidHippo.set(kForward);
        hippoIntakeMotor.set(HippoIntakeSpeed);

    }

    public void HippoRetractMech() {
        doubleSolenoidHippo.set(kReverse);
        hippoIntakeMotor.set(HippoMotorStop);

    }

    public void HippoReverseMotor () {

        //Protect the gear box
        double currentSpeed = hippoIntakeMotor.get();
        
        if (currentSpeed > 0.03) {
            hippoIntakeMotor.set(HippoMotorStop);
        }
        else if (currentSpeed < -0.03) {
            hippoIntakeMotor.set(HippoMotorStop);
       }
        else {
            hippoIntakeMotor.set(HippoIntakeSpeed * -1);
        }
    }

    public void ActivateShooter() {
        shooterTopMotor.set(ShooterTopMotorSpeed);
        shooterBottomMotor.set(ShooterBottomMotorSpped);
    }

    public void StopShooter() {
        shooterTopMotor.set(HippoMotorStop);
        shooterBottomMotor.set(HippoMotorStop);

    }


}

