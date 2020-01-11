package frc.robot;

import com.revrobotics.ColorSensorV3;

import java.io.FileWriter;
import java.io.IOException;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Teleop {
    // Vairables for robot classes
    private OI joysticks = null;
    
    private ColorMatch colorMatcher = null;
    private ColorSensorV3 colorSensor = null;

    private FileWriter colorLog = null;

    private String colorData = "";

    /**
     * Creates a Teleop object which is the main file when in teleop mode.
     */
    public Teleop(ColorSensorV3 colorSensor) {

        // Initialize Classes
        joysticks = new OI();

        this.colorSensor = colorSensor;
        colorMatcher = new ColorMatch();

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

        colorData += Integer.toString(colorSensor.getRed()) + "," + Integer.toString(colorSensor.getGreen()) + "," + Integer.toString(colorSensor.getBlue()) + "," + Integer.toString(colorSensor.getProximity()) + "\n";

        

        SmartDashboard.putNumber("Red", colorSensor.getRed());
        SmartDashboard.putNumber("Green", colorSensor.getGreen());
        SmartDashboard.putNumber("Blue", colorSensor.getBlue());
        SmartDashboard.putNumber("Proximity", colorSensor.getProximity());

        joysticks.checkInputs();
    }

    /**
     * Function that's called in an infinite loop on the robot when in test mode.
     */
	public void TestPeriodic() {
        joysticks.checkInputs();
    }
    public void disabledInit() {
        try {
            colorLog = new FileWriter("home/lvuser/colorLog.csv");
        } catch (IOException e) {
            return;
        }

        try {
            colorLog.write(colorData);
            colorLog.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
            return;
        }

        try {
            System.out.println("Closing");
            colorLog.close();
        } catch (Exception e) {
            return;
        }
    }
}
