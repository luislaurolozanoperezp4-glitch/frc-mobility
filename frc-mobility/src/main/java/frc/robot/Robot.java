package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private final RobotContainer container = new RobotContainer();
  private Command autonomousCommand;
  @Override public void robotPeriodic() { CommandScheduler.getInstance().run(); }
  @Override public void autonomousInit() { autonomousCommand = container.getAutonomousCommand(); if (autonomousCommand != null) autonomousCommand.schedule(); }
  @Override public void teleopInit() { if (autonomousCommand != null) autonomousCommand.cancel(); }
}
