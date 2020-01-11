package frc.robot;
import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;

public class RobotMap {

    /**
     * Creates a RobotMap for mapping electronics on the robot to Java Objects,
     * so that they can be used multiple places throughout the code.
     */

    private final I2C.Port colorPort = I2C.Port.kOnboard;

    private final ColorSensorV3 colorSensor = new ColorSensorV3(colorPort);

    public RobotMap() {

    }

    public ColorSensorV3 getColorSensor() {
        return colorSensor;
    }

}
