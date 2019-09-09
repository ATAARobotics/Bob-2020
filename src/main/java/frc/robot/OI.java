package frc.robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
class OI {

    //Driver Variables
    private XboxController driveStick = new XboxController(0);
    private String driverScheme = "Default";
    private double XSpeed;
    private double ZRotation;
    private boolean gearShift;
    private boolean slow;

    //Special Function variables
    boolean leftTriggerPressed = false;
    boolean rightTriggerPressed = false;
    
    public OI() {

    }
    //periodic function to update controller input
    public void checkInputs() {
        //switch statement to detirmine controls for the driver
        switch (driverScheme) {
            case "Default":
                XSpeed = driveStick.getY(Hand.kLeft);
                ZRotation = -driveStick.getX(Hand.kRight);
                gearShift = driveStick.getXButtonReleased();
                slow = driveStick.getAButtonReleased();
                break;
            
            case "Reverse Turning":
                XSpeed = -driveStick.getY(Hand.kLeft);
                ZRotation = driveStick.getX(Hand.kRight);
                gearShift = driveStick.getXButtonReleased();
                slow = driveStick.getAButtonReleased();
                break;    
    
            default:
                XSpeed = driveStick.getY(Hand.kLeft);
                ZRotation = -driveStick.getX(Hand.kRight);
                gearShift = driveStick.getXButtonReleased();
                slow = driveStick.getAButtonReleased();
                break;
        }
    }
    //Getter functions for controls
    public double getXSpeed() {
        return XSpeed;
    }
    public double getZRotation() {
        return ZRotation;
    }

    public boolean getGearShift() {
        return gearShift;
    }

    public boolean getSlow() {
        return slow;
    }
}