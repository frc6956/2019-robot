package frc.robot;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.interfaces.Gyro;
/**
 * This class provides an interface for the Pidgeon Gyro
 */
public class GyroPidgeon implements Gyro {

	private PigeonIMU pigeon = new PigeonIMU(0);;
	double zeroAngle;
	/**
	 * this is the constructor of the class
	 */
	public GyroPidgeon() {
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
		double [] ypr = new double [3];
		pigeon.getYawPitchRoll(ypr);
		return -ypr[0];
	}

	@Override
	public void close() throws Exception {

	}
	

}