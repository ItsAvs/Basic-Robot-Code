
package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.PortConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import java.util.function.Supplier;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.networktables.NTSendable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import frc.robot.subsystems.staticsubsystems.RobotGyro;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.util.NetworkTablesUtil;


public class ArmSubsystem extends SubsystemBase {
	private final CANSparkMax armMotor1;
    private final CANSparkMax armMotor2;

    private final RelativeEncoder pivot1Encoder;
    private final RelativeEncoder pivot2Encoder;

    private final DigitalInput pivot1LimitSwitch;
    private final DigitalInput pivot2LimitSwitch;


    
    public ArmSubsystem()  {
        this.armMotor1 = new CANSparkMax(PortConstants.ARM_MOTOR_PORT_1, MotorType.kBrushless);
        this.armMotor2 = new CANSparkMax(PortConstants.ARM_MOTOR_PORT_2, MotorType.kBrushless);

        //Set Pivot Encoders
        this.pivot1Encoder = this.armMotor1.getEncoder();
        this.pivot2Encoder = this.armMotor2.getEncoder();

        this.pivot1LimitSwitch = new DigitalInput(PortConstants.PIVOT_1_LIMIT_PORT);
        this.pivot2LimitSwitch = new DigitalInput(PortConstants.PIVOT_2_LIMIT_PORT);

         // Arm Angle Conversion Factors
         this.pivot1Encoder.setPositionConversionFactor(2.7); // 125:1 gearbox
         this.pivot2Encoder.setPositionConversionFactor(3.65); // 125:1 gearbox
    }

    public void motor1Speed(double speed){
        this.armMotor1.set(speed);
    }

    public void setEncoderValues(double encoder1, double encoder2){
        this.pivot1Encoder.setPosition(encoder1);
        this.pivot2Encoder.setPosition(encoder2);
    }

    public void setDefaultEncoderValues(){
        setEncoderValues(ArmConstants.ENCODER_1_VALUE, ArmConstants.ENCODER_2_VALUE);
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

    public void printEncoderValues(){
        System.out.println("Encoder 1: " + pivot1Encoder.getPosition()+ "\nEncoder 2:" + pivot2Encoder.getPosition());
    }

    public void encoderReset(){
        double targetValue = 70;
        double currentValue1 = pivot1Encoder.getPosition();
        double currentValue2 = pivot2Encoder.getPosition();
        if (Math.abs(targetValue - currentValue1) <=  1 || Math.abs(targetValue - currentValue2) <= 1){
            setDefaultEncoderValues();
        }
    }

    public void printTableEntrys(){
        //java has boolean values lowercase :O
        boolean checkNetworkTable = NetworkTablesUtil.getEntry("table1", "entry2").getBoolean(false);
        if (checkNetworkTable){
            System.out.println("Network Table Value is True.");
        }
    }

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
        if (pivot1LimitSwitch.get() || pivot2LimitSwitch.get()){
            setDefaultEncoderValues();
        }
	}

	@Override
	public void simulationPeriodic() {
		// This method will be called once per scheduler run during simulation
	}
}
