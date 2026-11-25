package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;

public class Indexer extends SubsystemBase {
  private final PWMSparkMax motor = new PWMSparkMax(Constants.INDEXER_PWM);
  public void setSpeed(double speed) { motor.set(speed); }
  public Command runCommand(DoubleSupplier speed) { return run(() -> motor.set(speed.getAsDouble())).withName("Run Indexer"); }
  public void stop() { motor.stopMotor(); }
}
