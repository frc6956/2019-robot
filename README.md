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

# The Ten Commandments of Coding

- Thou shalt camel caseth names of variables and methods and capitalizeth names of classes.
- Thou shalt placeth opening brackets on the line of their corresponding declaration.
- Thou shalt placeth a space before all opening curly brackets.
- Thou shalt placeth a space before the parentheses of an if, else if, or switch.
- Thou shalt NOT placeth a space before the parentheses of method calls or method declarations.
- Thou shalt placeth a space after but not before all commas.
- Thou shalt placeth a space on either side of all logic operators.
- Thou shalt placeth a blank line between two sets of unrelated code (for example, between method declarations).
- When commenting, thou shalt placeth the comment one line above the code thou art commenting about.
- Thou shalt indenteth using spaces, and thy editor's space count shall be 4. If thou dost not obey this rule, thou shalt be shunned as if thou art a spider and the team is collectively dear old Miss Muffet herself.