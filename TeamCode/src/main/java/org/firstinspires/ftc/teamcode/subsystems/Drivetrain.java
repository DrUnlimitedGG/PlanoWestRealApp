package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Drivetrain {
    private DcMotorEx LF;
    private DcMotorEx LB;
    private DcMotorEx RF;
    private DcMotorEx RB;

    public Drivetrain(DcMotorEx LF, DcMotorEx LB, DcMotorEx RF, DcMotorEx RB) {
        this.LF = LF;
        this.RF = RF;
        this.RB = RB;
        this.LB = LB;

        LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void driveForward(double velocity, int distance) {
        dispatchMotors("setTargetPosition", distance, velocity);
        dispatchMotors("setModeToRunToPosition", 0, 0);

        LF.setVelocity(velocity);
        RF.setVelocity(velocity);
        RB.setVelocity(velocity);
        LB.setVelocity(velocity);

        while (LF.isBusy() || LB.isBusy() || RF.isBusy() || RB.isBusy()) {

        }

        dispatchMotors("stopAllMotors", 0, 0);

    }

    public void turnRight(double velocity, long time) throws InterruptedException {
        LF.setVelocity(velocity);
        LB.setVelocity(velocity);
        RF.setVelocity(-velocity);
        RB.setVelocity(-velocity);

        wait(time);

        dispatchMotors("stopAllMotors", 0, 0);
    }

    public void turnLeft(double velocity, long time) throws InterruptedException {
        LF.setVelocity(-velocity);
        LB.setVelocity(-velocity);
        RF.setVelocity(velocity);
        RB.setVelocity(velocity);

        wait(time);

        dispatchMotors("stopAllMotors", 0, 0);
    }

    protected void dispatchMotors(String action, int intTarget, double velocity) {
        switch(action) {
            case "setTargetPosition":
                LF.setTargetPosition(intTarget);
                RF.setTargetPosition(intTarget);
                RB.setTargetPosition(intTarget);
                LB.setTargetPosition(intTarget);
                break;
            case "setModeToRunUsingEncoder":
                LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                break;
            case "setModeToRunToPosition":
                LF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                RF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                RB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                break;
            case "stopAllMotors":
                LF.setPower(0);
                LB.setPower(0);
                RF.setPower(0);
                RB.setPower(0);
                break;
        }

    }
}
