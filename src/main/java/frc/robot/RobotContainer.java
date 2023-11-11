// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.TestArmCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private final ArmSubsystem m_armSubsystem = new ArmSubsystem();

	// Replace with CommandPS4Controller or CommandJoystick if needed
	private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the trigger bindings
		configureBindings();
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
	 * predicate, or via the named factories in {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
	 * {@link CommandXboxControllerXbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4ControllerPS4} controllers or
	 * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flightjoysticks}.
	 * 2. Create a new local variable of type Command, and make it first set both arm motor speeds to 0 
	 * (hint: it runs once), then immediately afterwards runs a new ArmTestCommand.
	 */
	private void configureBindings() {
		Command resetCommand = Commands.runOnce(() -> {
			m_armSubsystem.stopAllMotors();}, m_armSubsystem).andThen(
				new TestArmCommand(m_armSubsystem));
		resetCommand.schedule();

	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	//public Command getAutonomousCommand() {
		// An example command will be run in autonomous
		//return Autos.exampleAuto(Subsystem);

	//}

	public void onAutonInit() {

	}

	public void onTeleopInit() {

	}

}
