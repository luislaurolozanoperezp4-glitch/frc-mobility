package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj2.command.Command;

/** Runs intake and indexer together while scheduled; both stop when the command ends. */
public class IntakeCommand extends Command {
  private final Intake intake;
  private final Indexer indexer;
  private final double intakeSpeed;
  private final double indexerSpeed;
  public IntakeCommand(Intake intake, Indexer indexer, double intakeSpeed, double indexerSpeed) {
    this.intake = intake; this.indexer = indexer; this.intakeSpeed = intakeSpeed; this.indexerSpeed = indexerSpeed;
    addRequirements(intake, indexer);
  }
  @Override public void execute() { intake.setSpeed(intakeSpeed); indexer.setSpeed(indexerSpeed); }
  @Override public void end(boolean interrupted) { intake.stop(); indexer.stop(); }
}
