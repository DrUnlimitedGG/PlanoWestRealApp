package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.*;

public class RobotBuilder extends RobotConfig {
    public Arm arm;
    public Claw claw;
    public Drivetrain drivetrain;

    public RobotBuilder(HardwareMap hardwareMap) {
        DcMotorEx LF = hardwareMap.get(DcMotorEx.class, RobotConfig.LF);
        DcMotorEx LB = hardwareMap.get(DcMotorEx.class, RobotConfig.LB);
        DcMotorEx RF = hardwareMap.get(DcMotorEx.class, RobotConfig.RF);
        DcMotorEx RB = hardwareMap.get(DcMotorEx.class, RobotConfig.RB);
        this.drivetrain = new Drivetrain(LF, LB, RF, RB);

        Servo clawServo = hardwareMap.get(Servo.class, RobotConfig.CLAW_SERVO);
        this.claw = new Claw(clawServo);

        DcMotorEx armMotor = hardwareMap.get(DcMotorEx.class, RobotConfig.ARM_MOTOR);
        this.arm = new Arm(armMotor);
    }
}
