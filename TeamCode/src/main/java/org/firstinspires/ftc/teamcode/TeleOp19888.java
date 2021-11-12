package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

/*

***This is the code the for Driver Control Period***

These are the controls as of right now.
Feel free to edit these as you edit this code

right joystick --> Moving the robot forward/backward
left joystick --> Making the robot turn left/right
right trigger --> Spinning wheel
right bumper --> moving the linear slide up
left bumper --> moving the linear slide down
a --> open claw
b --> close claw

 */

@TeleOp (name = "teleop 19888 1")
public class TeleOp19888 extends LinearOpMode {
    //declaring motors
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorWheel;
    private DcMotor motorSlide;
    private Servo servoClaw;
//    private CRServo servoClaw;


    public void runOpMode() throws InterruptedException {
        //initializing motors/servos
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorWheel = hardwareMap.dcMotor.get("motorWheel");
        motorSlide = hardwareMap.dcMotor.get("motorSlide");
        servoClaw = hardwareMap.servo.get("servoClaw");

        waitForStart();

        while (opModeIsActive()) {
            //foward back left right
            motorLeft.setPower(-gamepad1.right_stick_y);
            motorRight.setPower(-gamepad1.left_stick_y);

            //lift
            if (gamepad1.left_bumper || gamepad1.right_bumper) {
                motorSlide.setPower(1);
            }else if ((gamepad1.left_trigger != 0) || (gamepad1.right_trigger != 0)) {
                motorSlide.setPower(-1);
            }else {
                motorSlide.setPower(0);
            }

            //claw
            if (gamepad1.a) {
                servoClaw.setPosition(servoClaw.getPosition()+0.1);
            }else if (gamepad1.b) {
                servoClaw.setPosition(servoClaw.getPosition()-0.1);
            }

            //wheel
            if (gamepad1.x) {
                motorWheel.setPower(1);
            }else{
                motorWheel.setPower(0);
            }
        }
    }

}