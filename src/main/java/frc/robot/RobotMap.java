package frc.robot;

public class RobotMap {

    /**
     * Creates a RobotMap for mapping electronics on the robot to Java Objects,
     * so that they can be used multiple places throughout the code.
     */
    public RobotMap() {
        rearLeftMotor.follow(frontLeftMotor);
        rearRightMotor.follow(frontRightMotor);
    }
}