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
		// TODO Auto-generated method stub

	}
	/**
	 * sets angle to zero
	 * returns void
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		zeroAngle = getRawAngle();
	}
    /**
	 * gets the current angle of the robot
	 * returns a double vaule of the angle
	 */
	@Override
	public double getAngle() {
		// TODO Auto-generated method stub
		return getRawAngle() - zeroAngle;
	}
	/**
	 * gets the rate of the robot
	 * returns a double value
	 */
	@Override
	public double getRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void free() {
		// TODO Auto-generated method stub

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