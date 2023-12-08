package edu.greenblitz.robotName.subsystems.Arm.Extender;

import com.ctre.phoenixpro.hardware.TalonFX;

public interface IExtender {

    void setSpeed(double power);
    void setPosition(double position);
    void setLengthMetersByPID(double goalAngle, double feedForward);
    void setVoltage(double voltage);
//    void setIdleMode();//TODO
    void updateInputs(ExtenderInputsAutoLogged inputs);
    void setSoftLimit(CANSparkMax.SoftLimitDirection direction, double limit);
    void enableSoftLimit(CANSparkMax.SoftLimitDirection direction, boolean isEnabled);


}
