package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class RobotMain19888 extends LinearOpMode {
    private DcMotor motorLeft;
    private DcMotor motorBackLeft;
    private DcMotor motorRight;
    private DcMotor motorBackRight;
    private DcMotor motorWheel;
    private DcMotor motorSlide;
    private Servo servoClaw;
//  private CRServo servoClaw; // servoClaw is not a continuous rotation servo? please double check

    // for autonomous; need to edit the values though
    final double DRIVE_FACTOR = 100;
    final double TURN_FACTOR = 200;

    public void forward (int inch, double power) {
        int ticks = (int) (inch * DRIVE_FACTOR);

        //Reset Encoders
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        motorLeft.setTargetPosition(motorLeft.getCurrentPosition() - ticks);
        motorBackLeft.setTargetPosition(motorBackLeft.getCurrentPosition() - ticks);
        motorRight.setTargetPosition(motorRight.getCurrentPosition() - ticks);
        motorBackRight.setTargetPosition(motorBackRight.getCurrentPosition() - ticks);

        //Set Drive Power
        motorLeft.setPower(0.5 * power);
        motorBackLeft.setPower(0.5 * power);
        motorRight.setPower(0.5 * power);
        motorBackRight.setPower(0.5 * power);

        //Set to RUN_TO_POSITION mode
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (motorLeft.isBusy() && motorBackLeft.isBusy() && motorRight.isBusy() && rb.isBusy()){
            telemetry.addData("lf", -motorLeft.getCurrentPosition());
            telemetry.addData("rf", -motorRight.getCurrentPosition());
            telemetry.addData("lb", -motorBackLeft.getCurrentPosition());
            telemetry.addData("rb", -motorBackRight.getCurrentPosition());
            telemetry.update();
            //Wait Until Target Position is Reached
        }
        sleep(500);
    }

    public void turn (int degree, double power) {
        int ticks = (int) (degree * TURN_FACTOR);

        //Reset Encoders
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        motorLeft.setTargetPosition(motorLeft.getCurrentPosition() - ticks);
        motorBackLeft.setTargetPosition(motorBackLeft.getCurrentPosition() - ticks);
        motorRight.setTargetPosition(motorRight.getCurrentPosition() + ticks);
        motorBackRight.setTargetPosition(motorBackRight.getCurrentPosition() + ticks);

        //Set Drive Power
        motorLeft.setPower(0.5 * power);
        motorBackLeft.setPower(0.5 * power);
        motorRight.setPower(0.5 * power);
        motorBackRight.setPower(0.5 * power);

        //Set to RUN_TO_POSITION mode
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (motorLeft.isBusy() && motorBackLeft.isBusy() && motorRight.isBusy() && motorBackRight.isBusy()){
            telemetry.addData("lf", -motorLeft.getCurrentPosition());
            telemetry.addData("rf", -motorRight.getCurrentPosition());
            telemetry.addData("lb", -motorBackLeft.getCurrentPosition());
            telemetry.addData("rb", -motorBackRight.getCurrentPosition());
            telemetry.update();
            //Wait Until Target Position is Reached
        }
        sleep(500);
    }
}
