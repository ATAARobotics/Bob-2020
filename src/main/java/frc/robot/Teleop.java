package frc.robot;

public class Teleop {
    // Vairables for robot classes
    private SWATDrive driveTrain;
    private RobotMap robotMap;
    private OI joysticks;
    private double speedX = 0;
    private double speedZ = 0;
    private double limit = 0.02;


    public Teleop() {
        //Initialize Classes
        robotMap = new RobotMap();
        joysticks = new OI();
        driveTrain = new SWATDrive(robotMap);
    }

    public void TeleopInit() {
        //driveTrain.gearShift();
    }

    public void TeleopPeriodic() {
        joysticks.checkInputs();
        //drive
        double joystickX = -joysticks.getXSpeed();
        double joystickZ = joysticks.getZRotation();
        double changeX = joystickX - speedX;
        double changeZ = joystickZ - speedZ;
        if(changeX>limit && joystickX > 0) {
            changeX = limit;
            System.out.println("1");
        }
        else if(changeX<limit && joystickX < 0) {
            changeX = -limit;
            System.out.println("2");
        }
        speedX += changeX;
        speedZ += changeZ;

        System.out.println("speed = " + speedX);
        driveTrain.arcadeDrive(speedX * driveTrain.getMaxStraightSpeed(), speedZ * driveTrain.getMaxTurnSpeed());
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