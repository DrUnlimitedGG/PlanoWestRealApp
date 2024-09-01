package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo claw;

    public Claw(Servo claw) {
        this.claw = claw;
    }

    public void updateClawPos(double position) {
        claw.setPosition(position);
    }
}
