package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/*

***This is the code for the Autonomous Period***

Most of the code is not complete yet.

 */

@Autonomous
public class Autonomous19888 extends RobotMain19888 {

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            // TEST: for drive and turn factors
            // forward(5, 1);
            turn(90, 1);
            done = true;
        }
    }
}

//@Autonomous (name = "autonomous 1")
//public class AutoC358_Red extends AutoEngine358 {
//    private double POWER = 1;
//
//    public void runOpMode() throws InterruptedException {
//
//        initialize(new RobotPosition(0, 0, 90));
//
//
//        while (opModeIsActive()) {
//            forward(POWER, 30);
//            turnTo(0, POWER);
//        }
//    }
//
//}