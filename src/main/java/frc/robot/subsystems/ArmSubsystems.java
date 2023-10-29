
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class ArmSubsystems extends SubsystemBase {
	private final CANSparkMax armMotor1;
    private final CANSparkMax armMotor2;
    public ArmSubsystems() {
        this.armMotor1 = new CANSparkMax(PortConstants.PORT_1, MotorType.kBrushless);
        this.armMotor2 = new CANSparkMax(PortConstants.PORT_2, MotorType.kBrushless);
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

    public void stopAllMotors(){
        this.motor1Speed.set(0);
        this.motor2Speed.set(0);
    }

    public CommandBase TestArmCommand(){
        int ticks;
        while (ticks < 601){
            this.motor1Speed.set(Math.sin(ticks));
            this.motor2Speed.set(Math.cos(ticks));
            ticks += 1;
        }
        stopAllMotors()
    }
	
    @Override
    public void intitilize() {
        ticks = 0;
        System.out.println("begin arm command (hw2)")
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
