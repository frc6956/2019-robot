# 2019-robot

## Subsystems

Drivetrain
- TeleopDrive
- DriveDistance
- TurnAngle

HatchDeployer
- Deploy

CargoHandler
- Pickup
- Place
- SetPosition

## Standalone Sensors
- Gyro (PigeonIMU)
- LineFollower
- VisionTracking
- DriverVision

## Command Groups
- AutoScoreHatch
- AutoScoreCargo
- AutoClimb
- AutoDriveToCS

## Operator Interface
Operator
- deployHatch
- intakeCargo
- placeCargo
- setCargoPosition

Driver
- tankLeft
- tankRight
- arcadeX
- arcadeY
- isTankDrive - evaulate arcade/split arcade/tank
