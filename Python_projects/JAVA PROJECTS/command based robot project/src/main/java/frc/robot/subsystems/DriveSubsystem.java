package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.OIConstants;

public class DriveSubsystem extends SubsystemBase {
    
    private Spark frontRightMotor = new Spark(OIConstants.kRightFrontMotorID);
    private Spark frontLeftMotor = new Spark(OIConstants.kLeftFrontMotorID);
    private Spark rearRightMotor = new Spark(OIConstants.kRightRearMotorID);
    private Spark rearLeftMotor = new Spark(OIConstants.kLeftRearMotorID);

    private Joystick joy1 = new Joystick(OIConstants.kJoystickPort);
    private Encoder leftencoder = new Encoder(0, 1);
    private Encoder rightencoder = new Encoder(2, 3);

    private final double kDriveTick2Feet = 1.0 / 128 * 6 * Math.PI / 12;

    public double getEncoderMeters() {
        return (leftencoder.get() * -rightencoder.get()) / 2 * kDriveTick2Feet;
    }
    
    public DriveSubsystem() {
        
    }
    
    
    public void periodic() {
        SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    }

    public void setMotors(double left, double right) {
        frontLeftMotor.set(left);
        rearLeftMotor.set(left);
        frontRightMotor.set(-right);
        rearRightMotor.set(-right);
    }
}
