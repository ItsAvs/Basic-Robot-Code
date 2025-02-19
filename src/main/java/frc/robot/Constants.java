// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other purpose. All constants
 * should be declared globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static class OperatorConstants {
		public static final int DRIVER_CONTROLLER_PORT = 0;
	}
	public static class PortConstants {
		public static final int ARM_MOTOR_PORT_1 = 1;
		public static final int ARM_MOTOR_PORT_2 = 2;

		public static final int PIVOT_1_LIMIT_PORT = 1;
		public static final int PIVOT_2_LIMIT_PORT = 0;
	}

	public static class ArmConstants{
		public static final int ENCODER_1_VALUE = 20;
		public static final int ENCODER_2_VALUE = 30;
	}

}
