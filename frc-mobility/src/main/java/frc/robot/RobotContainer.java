package frc.robot;

import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Indexer indexer = new Indexer();
  private final CommandXboxController driver = new CommandXboxController(Constants.DRIVER_PORT);
  private final CommandXboxController operator = new CommandXboxController(Constants.OPERATOR_PORT);

  public RobotContainer() {
    drivetrain.setDefaultCommand(drivetrain.driveCommand(() -> -driver.getLeftY(), () -> -driver.getRightX()));
    driver.leftBumper().whileTrue(intake.runCommand(() -> 0.75));
    driver.rightBumper().whileTrue(intake.runCommand(() -> -0.65));
    operator.a().whileTrue(indexer.runCommand(() -> 0.7));
    operator.b().whileTrue(indexer.runCommand(() -> -0.5));
    operator.x().whileTrue(new IntakeCommand(intake, indexer, 0.75, 0.65));
  }
  public Command getAutonomousCommand() { return Commands.sequence(drivetrain.driveFor(0.35, 2.0), Commands.none()); }
}
