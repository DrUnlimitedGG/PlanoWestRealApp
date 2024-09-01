package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Arm {
    private DcMotorEx arm;

    public Arm(DcMotorEx arm) {
        this.arm = arm;
    }

    public void openArm(double power, long duration) throws InterruptedException {
        arm.setPower(power);
        wait(duration);
        arm.setPower(0);
    }

    public void closeArm(double power, long duration) throws InterruptedException {
        arm.setPower(-power);
        wait(duration);
        arm.setPower(0);
    }
}
