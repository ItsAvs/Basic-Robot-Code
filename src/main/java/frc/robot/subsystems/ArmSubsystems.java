
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class ArmSubsystems extends SubsystemBase {
	private final CANSparkMax clawMotor1;
    private final CANSparkMax clawMotor2;
    public ArmSubsystems() {
        this.clawMotor1 = new CANSparkMax(PortConstants.PORT_1);
        this.clawMotor2 = new CANSparkMax(PortConstants.PORT_2);
    }

    public void motor1Speed(double speed){
        this.clawMotor1.set(speed);
    }

    public void motor2Speed(double speed){
        this.clawMotor2.set(speed);
    }

    public void bothMotorSpeed(double speed1, double speed2){
        this.clawMotor1.set(speed1);
        this.clawMotor2.set(speed2);
    }
	public CommandBase exampleMethodCommand() {
		// Inline construction of command goes here.
		// Subsystem::RunOnce implicitly requires `this` subsystem.
		return runOnce(
				() -> {
					/* one-time action goes here */
				});
	}

	
	public boolean exampleCondition() {
		// Query some boolean state, such as a digital sensor.
		return false;
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}

	@Override
	public void simulationPeriodic() {
		// This method will be called once per scheduler run during simulation
	}
}
