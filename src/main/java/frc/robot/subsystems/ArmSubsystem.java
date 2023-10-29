
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class ArmSubsystem extends SubsystemBase {
	private final CANSparkMax armMotor1;
    private final CANSparkMax armMotor2;
    public ArmSubsystem() {
        this.armMotor1 = new CANSparkMax(PortConstants.ARM_MOTOR_PORT_1, MotorType.kBrushless);
        this.armMotor2 = new CANSparkMax(PortConstants.ARM_MOTOR_PORT_2, MotorType.kBrushless);
    }

    public void motor1Speed(double speed){
        this.armMotor1.set(speed);
    }

    public void motor2Speed(double speed){
        this.armMotor2.set(speed);
    }

    public void bothMotorSpeed(double speed1, double speed2){
        this.armMotor1.set(speed1);
        this.armMotor2.set(speed2);
    }

    public void stopAllMotors(){
        bothMotorSpeed(0.0, 0.0);
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
