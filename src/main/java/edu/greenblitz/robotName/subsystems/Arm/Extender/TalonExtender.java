package edu.greenblitz.robotName.subsystems.Arm.Extender;

import com.ctre.phoenixpro.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenixpro.hardware.TalonFX;

import static edu.greenblitz.robotName.subsystems.Arm.Extender.ExtenderConstants.TalonExtender.*;

public class TalonExtender implements IExtender{

    static TalonFX motor;

    public TalonExtender(){
        motor = new TalonFX(ID);//canbus?

        motor.getConfigurator().apply(CURRENT_LIMITS_CONFIGS);
        motor.getConfigurator().apply(MOTION_MAGIC_CONFIGS);
        motor.getConfigurator().apply(CLOSED_LOOP_RAMPS_CONFIGS);
        motor.getConfigurator().apply(SOFTWARE_LIMIT_SWITCH_CONFIGS);

        //TODO natural mode
    }

    @Override
    public void setSpeed(double power) {
        motor.set(power);
    }

    @Override
    public void setPosition(double position) {
        motor.setRotorPosition(position);
    }

    @Override
    public void setLengthMetersByPID(double goalAngle, double feedForward) {

    }

    @Override
    public void setVoltage(double voltage) {
        motor.setVoltage(voltage);
    }

    @Override
    public void updateInputs(ExtenderInputsAutoLogged inputs) { //TODO do
        inputs.appliedOutput = motor.getAppliedOutput();
        inputs.outputCurrent = motor.getOutputCurrent();
        inputs.position = motor.getEncoder().getPosition();
        inputs.velocity = motor.getEncoder().getVelocity();
    }

    @Override
    public void setSoftLimit(CANSparkMax.SoftLimitDirection direction, double limit) { //TODO do

    }

    @Override
    public void enableSoftLimit(CANSparkMax.SoftLimitDirection direction, boolean isEnabled) { //TODO do

    }
}
