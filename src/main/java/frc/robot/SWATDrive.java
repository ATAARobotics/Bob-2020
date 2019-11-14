package frc.robot;

// import libraries
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class SWATDrive {

    //slow variable
    private boolean slow = false;
    //low gear variable
    private static boolean lowGear = true;

    private double maxTurnSpeed;
    private double maxStraightSpeed;
    private RobotMap robotMap;
    
    public SWATDrive(RobotMap roboMap) {

        robotMap = roboMap;
        maxStraightSpeed = 1;
        maxTurnSpeed = 0.8;
    }
    public boolean getGear() {
        return lowGear;
    }
    public void gearShift() {
        lowGear = !lowGear;
        if(lowGear) {
            robotMap.getGearShift().set(DoubleSolenoid.Value.kReverse);
        }
        else {
            robotMap.getGearShift().set(DoubleSolenoid.Value.kForward);
        }
    }
    public double getLeftMotors() {
        return robotMap.getLeftMotor().getAppliedOutput();
    }
    public double getRightMotors() {
        return robotMap.getRightMotor().getAppliedOutput();
    }
    public void slow() {
        slow = !slow;
        if(slow) {
            robotMap.getDriveTrain().setMaxOutput(0.7);
            maxTurnSpeed = 0.7;
            maxStraightSpeed = 0.7;
        }
        else {
            robotMap.getDriveTrain().setMaxOutput(1);
            maxTurnSpeed = 0.8;
            maxStraightSpeed = 1;
        }
    }

    public double getMaxTurnSpeed() {
        return maxTurnSpeed;
    }
    public double getMaxStraightSpeed() {
        return maxStraightSpeed;
    }

    public void arcadeDrive(double speed, double rotation) {
        robotMap.getDriveTrain().arcadeDrive(speed, rotation);
    }

    public void tankDrive(double lSpeed, double rSpeed) {
        robotMap.getDriveTrain().tankDrive(lSpeed, rSpeed);
    }
}
  