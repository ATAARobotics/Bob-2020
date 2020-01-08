/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;

public class Robot extends TimedRobot {
    // Create objects to run teleop code
    private RobotMap robotMap = null;
    private Teleop teleop = null;

    /**
     * Create a robot which mostly just connects teleop to the WPIlib callbacks.
     */
    Robot() {
        robotMap = new RobotMap();
        teleop = new Teleop(robotMap);
    }

    /**
    * This function is called when the robot turns on.
    */
    @Override
    public void robotInit() {}

    /**
    * This function is called every robot packet, no matter the mode.
    */
    @Override
    public void robotPeriodic() {}

    /**
    * This function is called when the robot is disabled.
    */
    @Override
    public void disabledPeriodic() {}

    /**
    * This function gets called when the mode is switched to auto, currently
    * auto is not being used so this function is empty.
    */
    @Override
    public void autonomousInit() {}

    /**
    * This function is called when the robot is in auto mode, currently auto is
    * not being used so this function is empty.
    */
    @Override
    public void autonomousPeriodic() {}

    /**
    * This function passes teleopInit calls to the teleop class.
    */
    @Override
    public void teleopInit() {
        teleop.TeleopInit();
    }

    /**
    * This function passes teleopPeriodic calls to the teleop class.
    */
    @Override
    public void teleopPeriodic() {
        teleop.TeleopPeriodic();
    }

    /**
    * This function passes testPeriodic calls to the teleop class.
    */
    public void testPeriodic() {
        teleop.TestPeriodic();
    }
}
