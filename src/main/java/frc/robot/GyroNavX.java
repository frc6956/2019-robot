package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;
/**
 * This class provides an interface for the NavX Gyro
 */
public class GyroNavX implements Gyro {

	private AHRS navX = new AHRS(Port.kMXP);
	double zeroAngle;
	/**
	 * this is the constructor of the class
	 */
	public GyroNavX() {
		reset();
	}
	@Override
	public void calibrate() {
	}
	/**
	 * sets current angle to zero
	 */
	@Override
	public void reset() {
		zeroAngle = getRawAngle();
	}
	/**
	 * calculates current angle
	 * returns a double value of the current angle
	 */
	@Override
	public double getAngle() {
		return getRawAngle() - zeroAngle;
	}
	/**
	 * gets the rate of the robot
	 * returns double value of the robot rate
	 */
	@Override
	public double getRate() {
		return 0;
	}

	@Override
	public void free() {
	}
	/**
	 * calculates total rotation of robot
	 * @return double total angle
	 */
	private double getRawAngle() {
		double roll;
		roll = navX.getRoll();
		return roll;
	}

	@Override
	public void close() throws Exception {

	}
	

}