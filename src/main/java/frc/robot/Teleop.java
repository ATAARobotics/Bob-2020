package frc.robot;

public class Teleop {
    // Vairables for robot classes
    private OI joysticks = null;
    private RobotMap robotMap = null;

    /**
     * Creates a Teleop object which is the main file when in teleop mode.
     */
    public Teleop(RobotMap robotMap) {
        // Initialize Classes
        robotMap = new RobotMap();
        joysticks = new OI();
    }

    /**
     * Initialization function the robot calls when switching to Teleop mode.
     */
    public void TeleopInit() {
    }

    /**
     * Function that's called in an infinite loop on the robot when in teleop mode.
     */
    public void TeleopPeriodic() {
        joysticks.checkInputs();
    }

    /**
     * Function that's called in an infinite loop on the robot when in test mode.
     */
	public void TestPeriodic() {
        joysticks.checkInputs();
	}
}
