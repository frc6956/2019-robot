package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class GyroNavX implements Gyro {

	private AHRS navX = new AHRS(Port.kMXP);
	double zeroAngle;
	public GyroNavX() {
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
		double roll;
		roll = navX.getRoll();
		return roll;
	}


	@Override
	public void close() throws Exception {

	}
	

}