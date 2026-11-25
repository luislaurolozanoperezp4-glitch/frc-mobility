package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;

public class Drivetrain extends SubsystemBase {
  private final PWMSparkMax leftMotor = new PWMSparkMax(Constants.LEFT_DRIVE_PWM);
  private final PWMSparkMax rightMotor = new PWMSparkMax(Constants.RIGHT_DRIVE_PWM);
  private final DifferentialDrive drive;
  public Drivetrain() {
    rightMotor.setInverted(true);
    drive = new DifferentialDrive(new MotorControllerGroup(leftMotor), new MotorControllerGroup(rightMotor));
  }
  public void arcadeDrive(double forward, double rotation) { drive.arcadeDrive(forward, rotation); }
  public Command driveCommand(DoubleSupplier forward, DoubleSupplier rotation) {
    return run(() -> arcadeDrive(forward.getAsDouble(), rotation.getAsDouble())).withName("Teleop Drive");
  }
  public Command driveFor(double speed, double seconds) { return runEnd(() -> arcadeDrive(speed, 0), () -> arcadeDrive(0, 0)).withTimeout(seconds); }
  @Override public void periodic() { drive.feed(); }
}
