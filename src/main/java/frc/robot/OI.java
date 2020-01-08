package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

class OI {
    private XboxController mainController = null;

    /**
     * Creates an OI that handles input mapping
     */
    public OI() {
        mainController = new XboxController(0)
    }
    /**
     * periodic function to update controller input
     */
    public void checkInputs() {
    }
}
