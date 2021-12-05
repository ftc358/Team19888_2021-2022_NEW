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



 */

@TeleOp (name = "teleop 19888 1")
public class TeleOp19888 extends RobotMain19888 {

    //declaring motors

//  commenting these motor declarations out because we already inherited RobotMain19888
//    private DcMotor motorLeft;
//    private DcMotor motorBackLeft;
//    private DcMotor motorRight;
//    private DcMotor motorBackRight;


//    private DcMotor motorWheel;
//    private DcMotor motorSlide;
//    private Servo servoClaw;
//    private CRServo servoClaw;


    public void runOpMode() throws InterruptedException {
        //initializing motors/servos
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorWheel = hardwareMap.dcMotor.get("motorWheel");
        motorSlide = hardwareMap.dcMotor.get("motorSlide");
        servoClaw = hardwareMap.servo.get("servoClaw");

        waitForStart();

        while (opModeIsActive()) {
            //foward back left right
                motorLeft.setPower(gamepad1.left_stick_y);
                motorBackLeft.setPower(gamepad1.left_stick_y);
                motorRight.setPower(-gamepad1.right_stick_y);
                motorBackRight.setPower(-gamepad1.right_stick_y);


            //lift
            motorSlide.setPower(-gamepad2.right_stick_y);
            motorSlide.setPower(-gamepad2.left_stick_y);


            //claw
            if (gamepad2.a) {
                servoClaw.setPosition(servoClaw.getPosition()+0.1);
            }else if (gamepad2.b) {
                servoClaw.setPosition(servoClaw.getPosition()-0.1);
            }

            //wheel
            if (gamepad2.x) {
                motorWheel.setPower(1);
            }else if(gamepad2.y){
                motorWheel.setPower(-1);
            }else{
                motorWheel.setPower(0);
            }
        }
    }

}