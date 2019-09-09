package frc.robot;

public class Teleop {
    // Vairables for robot classes
    private SWATDrive driveTrain;
    private RobotMap robotMap;
    private OI joysticks;


    public Teleop() {
        //Initialize Classes
        robotMap = new RobotMap();
        joysticks = new OI();
        driveTrain = new SWATDrive(robotMap);
    }

    public void TeleopPeriodic() {
        joysticks.checkInputs();
        //drive
        driveTrain.arcadeDrive(joysticks.getXSpeed() * driveTrain.getMaxStraightSpeed(), joysticks.getZRotation() * driveTrain.getMaxTurnSpeed());
        //speed limiters
        if(joysticks.getGearShift()) {
            driveTrain.gearShift();
        }
        if (joysticks.getSlow()) {
            driveTrain.slow();
        }
    }
	public void drive(double speedA, double speedB, boolean arcade) {
        if(arcade) {
            driveTrain.arcadeDrive(speedA, speedB);
        }
        else {
            driveTrain.tankDrive(speedA, speedB);
        }
	}
	public void TestPeriodic() {
        joysticks.checkInputs();
	}
}