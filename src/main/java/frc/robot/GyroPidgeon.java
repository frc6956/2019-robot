package frc.robot;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Gyro;

public class GyroPidgeon implements Gyro {

	private PigeonIMU pigeon = new PigeonIMU(0);;
	double zeroAngle;
	public GyroPidgeon() {
		reset();
	}
	@Override
	public void calibrate() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		zeroAngle = getRawAngle();
	}

	@Override
	public double getAngle() {
		// TODO Auto-generated method stub
		return getRawAngle() - zeroAngle;
	}

	@Override
	public double getRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void free() {
		// TODO Auto-generated method stub

	}
	private double getRawAngle() {
		double [] ypr = new double [3];
		pigeon.getYawPitchRoll(ypr);
		return -ypr[0];
	}

	@Override
	public void close() throws Exception {

	}
	

}