package edu.greenblitz.robotName.subsystems.Arm.Extender;

import com.revrobotics.CANSparkMax;
import edu.greenblitz.robotName.RobotConstants;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import org.littletonrobotics.junction.Logger;

import static edu.greenblitz.robotName.subsystems.Arm.Extender.ExtenderConstants.*;


public class SimulationExtender implements IExtender{

    ElevatorSim extenderSimulation;
    private double appliedVoltage;

    public SimulationExtender(){
        extenderSimulation = new ElevatorSim(
                DCMotor.getFalcon500Foc(NUMBER_OF_MOTORS),
                GEAR_RATIO,
                CARRIAGE_MASS,
                GEAR_RADIUS,
                BACKWARDS_LIMIT,
                FORWARD_LIMIT,
                false,
                STARTING_HEIGHT
        );
    }


    @Override
    public void setSpeed(double power) {
        setVoltage(power * RobotConstants.SimulationConstants.BATTERY_VOLTAGE);
    }

    @Override
    public void setPosition(double position) {
        Logger.recordOutput("Arm/Extender", "tried to set the position to " + position);
    }

    @Override
    public void setLengthMetersByPID(double length, double feedForward) {
        Logger.recordOutput("CubeController/Elevator", "tried setting the goal angle to " + length + " with feed  forward of " + feedForward);
    }

    @Override
    public void setVoltage(double voltage) {
        appliedVoltage = MathUtil.clamp(voltage, -RobotConstants.SimulationConstants.MAX_MOTOR_VOLTAGE, RobotConstants.SimulationConstants.MAX_MOTOR_VOLTAGE);
        extenderSimulation.setInputVoltage(appliedVoltage);
    }

//    @Override
//    public void setIdleMode(CANSparkMax.IdleMode idleMode) {//TODO
//        Logger.recordOutput("CubeController/Elevator", "tried setting the idleMode to " + idleMode.name());
//    }

    @Override
    public void updateInputs(ExtenderInputsAutoLogged inputs) {
        extenderSimulation.update(RobotConstants.SimulationConstants.TIME_STEP);

        inputs.appliedOutput = appliedVoltage;
        inputs.outputCurrent = extenderSimulation.getCurrentDrawAmps();
        inputs.position = extenderSimulation.getPositionMeters();
        inputs.velocity = extenderSimulation.getVelocityMetersPerSecond();
        inputs.absoluteEncoderPosition = extenderSimulation.getPositionMeters();
        inputs.absoluteEncoderVelocity = extenderSimulation.getVelocityMetersPerSecond();
    }
}
