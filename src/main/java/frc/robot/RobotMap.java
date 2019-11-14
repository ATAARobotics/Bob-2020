package frc.robot;

import com.revrobotics.CANEncoder;
//import motor controller libraries
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import Drivetrain and SpeedController Groups
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import camera libraries
//import solenoids
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import shuffleboard
public class RobotMap {
    //Motor Controllers
    private CANSparkMax frontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rearLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
    private CANSparkMax frontRightMotor = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax rearRightMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
    private CANEncoder rearLeftEncoder = rearLeftMotor.getEncoder();
    private CANEncoder frontRightEncoder = frontRightMotor.getEncoder();
    private CANEncoder rearRightEncoder = rearRightMotor.getEncoder();

    //Group Drive
    private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rearRightMotor, frontRightMotor);
    private SpeedControllerGroup leftMotors = new SpeedControllerGroup(rearLeftMotor, frontLeftMotor);

    //Add Drivetrain
    private DifferentialDrive driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    
    //Gear Shifting Solenoid
    private DoubleSolenoid gearShiftSolenoid = new DoubleSolenoid(6, 7);

    public RobotMap() {
        rearLeftMotor.follow(frontLeftMotor);
        rearRightMotor.follow(frontRightMotor);
    }
    public CANSparkMax getLeftMotor() {
        return frontLeftMotor;
    }
    public CANSparkMax getRightMotor() {
        return frontRightMotor;
    }
    //Get Motors
    public SpeedControllerGroup getLeftMotors() {
        return leftMotors;
    }

    public SpeedControllerGroup getRightMotors() {
        return rightMotors;
    }
    //Get Gear Shift
    public DoubleSolenoid getGearShift() {
        return gearShiftSolenoid;
    }
    //Get Drivetrain
    public DifferentialDrive getDriveTrain() {
        return driveTrain;
    }
}