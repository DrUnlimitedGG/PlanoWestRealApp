package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Autonomous")
@Disabled
public class Autonomous extends OpMode
{
    // Declare OpMode members.
    private RobotBuilder robot;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        robot = new RobotBuilder(hardwareMap);
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {}

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        robot.drivetrain.driveForward(0.5, 5000);
        // using encoder ticks instead of time

        // doing seconds instead of degrees because too lazy
        try { robot.drivetrain.turnLeft(0.5, 3); } catch (InterruptedException ignored) {}
        try { robot.drivetrain.turnRight(0.5, 6); } catch (InterruptedException ignored) {}

        try { robot.arm.openArm(0.3, 2); } catch (InterruptedException ignored) {}
        try { robot.arm.closeArm(0.3, 2); } catch (InterruptedException ignored) {}

        robot.claw.updateClawPos(0.7);
        robot.claw.updateClawPos(0);


    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {}

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {}

}
