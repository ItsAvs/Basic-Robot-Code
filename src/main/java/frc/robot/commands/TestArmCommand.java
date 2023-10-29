// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class TestArmCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private int ticks;
    public TestArmCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(armSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("begin arm command (hw2)");
        ticks = 0;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        ticks++;
        this.armSubsystem.bothMotorSpeed(Math.sin(ticks), Math.cos(ticks));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        this.armSubsystem.stopAllMotors();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (ticks > 600);
    }
}
