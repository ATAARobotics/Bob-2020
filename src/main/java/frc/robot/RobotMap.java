package frc.robot;

//import motor controller libraries
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import Drivetrain and SpeedController Groups
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import camera libraries
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
//import solenoids
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import shuffleboard
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class RobotMap {
    //Motor Controllers
    private CANSparkMax frontLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
    private CANSparkMax rearLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax rearRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    
    //Group Drive
    private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rearRightMotor, frontRightMotor);
    private SpeedControllerGroup leftMotors = new SpeedControllerGroup(rearLeftMotor, frontLeftMotor);

    //Add Drivetrain
    private DifferentialDrive driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    
    //Gear Shifting Solenoid
    private DoubleSolenoid gearShiftSolenoid = new DoubleSolenoid(0, 1);

    public RobotMap() {
        //Set camera variables and Add to Shuffleboard
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        Shuffleboard.getTab("Camera").add(camera);
        UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
        Shuffleboard.getTab("Camera").add(camera2);
        camera.setFPS(30);
        camera2.setFPS(30);
        //sync motors
        rearLeftMotor.follow(frontLeftMotor);
        rearRightMotor.follow(frontRightMotor);
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