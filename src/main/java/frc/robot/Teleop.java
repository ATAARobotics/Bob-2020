package frc.robot;

import java.lang.Math;

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

        // Get normalized colours (0-1 where 1 means equal to the brightest colour)
        double normRed = colorSensor.getRed();
        double normGreen = colorSensor.getGreen();
        double normBlue = colorSensor.getBlue();

        double max = Math.max(Math.max(normRed, normGreen), normBlue);

        normRed /= max;
        normGreen /= max;
        normBlue /= max;

        // Give raw colour values to smart dashboard
        SmartDashboard.putNumber("Red", normRed);
        SmartDashboard.putNumber("Green", normGreen);
        SmartDashboard.putNumber("Blue", normBlue);
        SmartDashboard.putNumber("Proximity", colorSensor.getProximity());

        // Compute the difference between the actual colour and the expected colour for each colourwheel colour
        double redPercent = Math.abs(normRed-1.0) + Math.abs(normGreen-0.8) + Math.abs(normBlue-0.2);
        double yellowPercent = Math.abs(normGreen-1.0) + Math.abs(normRed-0.5) + Math.abs(normBlue-0.2);
        double greenPercent = Math.abs(normGreen-1.0) + Math.abs(normBlue-0.3) + Math.abs(normRed-0.2);
        double bluePercent = Math.abs(normBlue-1.0) + Math.abs(normGreen-1.0) + Math.abs(normRed-0.2);

        // Give the differences for each of the four colourwheel colours to smart dashboard
        SmartDashboard.putNumber("Red", redPercent);
        SmartDashboard.putNumber("Yellow", yellowPercent);
        SmartDashboard.putNumber("Green", greenPercent);
        SmartDashboard.putNumber("Blue", bluePercent);

        // Compute a string containing the name of the closest matched colour
        double highest = Math.max(Math.max(redPercent, yellowPercent), Math.max(greenPercent, bluePercent));

        String guess = "";
        if (redPercent == highest) {
            guess = "red";
        } else if (yellowPercent == highest) {
            guess = "yellow";
        } else if (greenPercent == highest) {
            guess = "green";
        } else if (bluePercent == highest) {
            guess = "blue";
        }

        SmartDashboard.putString("Guess", guess);

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
