package edu.greenblitz.robotName.subsystems.Arm.Extender;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenixpro.configs.ClosedLoopRampsConfigs;
import com.ctre.phoenixpro.configs.CurrentLimitsConfigs;
import com.ctre.phoenixpro.configs.MotionMagicConfigs;
import com.ctre.phoenixpro.configs.SoftwareLimitSwitchConfigs;

import javax.swing.plaf.metal.MetalToggleButtonUI;

public class ExtenderConstants {
    public static final double BACKWARDS_LIMIT = 0;
    public static final double FORWARD_LIMIT = 1;
    public static final double GEAR_RADIUS = 1;
    public static final double CARRIAGE_MASS = 1;
    public static final double GEAR_RATIO = 1;
    public static final int NUMBER_OF_MOTORS = 1;
    public static final double STARTING_HEIGHT = 0;

    public class TalonExtender {
        public static final int ID = 0;
        public static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;
        public static final CurrentLimitsConfigs CURRENT_LIMITS_CONFIGS = new CurrentLimitsConfigs();
        static {
            CURRENT_LIMITS_CONFIGS.StatorCurrentLimit = 15;
            CURRENT_LIMITS_CONFIGS.StatorCurrentLimitEnable = true;
            CURRENT_LIMITS_CONFIGS.SupplyCurrentLimit = 7;
            CURRENT_LIMITS_CONFIGS.SupplyCurrentLimitEnable = true;
        }

        public static final ClosedLoopRampsConfigs CLOSED_LOOP_RAMPS_CONFIGS = new ClosedLoopRampsConfigs();
        static {
            CLOSED_LOOP_RAMPS_CONFIGS.DutyCycleClosedLoopRampPeriod = 0.02;
            CLOSED_LOOP_RAMPS_CONFIGS.TorqueClosedLoopRampPeriod = 21;
        }

        public static final MotionMagicConfigs MOTION_MAGIC_CONFIGS = new MotionMagicConfigs();
        static {
            MOTION_MAGIC_CONFIGS.MotionMagicAcceleration = 4;
            MOTION_MAGIC_CONFIGS.MotionMagicCruiseVelocity = 68;
            MOTION_MAGIC_CONFIGS.MotionMagicJerk = 100;
        }

        public static final SoftwareLimitSwitchConfigs SOFTWARE_LIMIT_SWITCH_CONFIGS = new SoftwareLimitSwitchConfigs();
        static {
            SOFTWARE_LIMIT_SWITCH_CONFIGS.ForwardSoftLimitEnable = true;
            SOFTWARE_LIMIT_SWITCH_CONFIGS.ForwardSoftLimitThreshold = 5;
            SOFTWARE_LIMIT_SWITCH_CONFIGS.ReverseSoftLimitEnable = true;
            SOFTWARE_LIMIT_SWITCH_CONFIGS.ReverseSoftLimitThreshold = 7;
        }
    }
}
