import java.util.*;

public class Main {
    private static float ACCELERATION = -9.81f;

    public static void main(String args[]) {
        int option;
        double height;
        double angle;
        double velocity;
        double division;
        double time = 0.0;
        double horizontalVelocity;
        double verticalVelocity;

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Press 1 to create a new simulation");
            System.out.println("Press 2 to quit the program");
            option = keyboard.nextInt();
            if (option == 1) {
                System.out.print("Please enter the initial height (in meters): ");
                height = keyboard.nextDouble();
                System.out.print("Please enter the initial angle for release (from 0 to 90 degrees): ");
                angle = keyboard.nextDouble();
                System.out.print("Please enter the initial velocity (in meter per second m/s): ");
                velocity = keyboard.nextDouble();
                System.out.print("Please enter the number of divisions per second (e.g. 100): ");
                division = keyboard.nextDouble();

                division = 1 / division;
                horizontalVelocity = velocity * Math.cos((angle / 180) * 3.14);
                verticalVelocity = velocity * Math.sin((angle / 180) * 3.14);

                Object object = new Object(height, horizontalVelocity, verticalVelocity);

                System.out.println("\t\tTheoretical\t\t\t\tEuler Approximation");
                System.out.println("Time\tHorizontal\tVertical\tHorizontal\tVertical");

                while (true) {
                    double theoreticalX = horizontalVelocity * time;
                    double theoreticalY = 0.5 * ACCELERATION * Math.pow(time, 2) + verticalVelocity * time + height;
                    if (theoreticalY >= 0) {
                        String temp = String.format("%4.3f\t%7.2f\t\t%7.3f || \t%7.2f\t\t%7.3f",
                                time, theoreticalX, theoreticalY, object.getPositionX(), object.getPositionY());
                        System.out.println(temp);
                    } else {
                        //as the object goes up, "a" should be a positive value
                        double raiseTime = Math.abs(verticalVelocity / ACCELERATION);
                        double totalDistanceInAir = 0.5 * ACCELERATION * (Math.pow(raiseTime, 2)) + verticalVelocity * raiseTime + height;
                        double fallTime = Math.sqrt(Math.abs(totalDistanceInAir * 2 / ACCELERATION));
                        double totalTimeInAir = raiseTime + fallTime;

                        double X = horizontalVelocity * totalTimeInAir;
                        double Y = 0.5 * ACCELERATION * (Math.pow(totalTimeInAir, 2)) + verticalVelocity * totalTimeInAir + height;
                        object.update(totalTimeInAir - time);
                        String temp = String.format("%4.3f\t%7.2f\t\t%7.3f || \t%7.2f\t\t%7.3f",
                                totalTimeInAir, X, Y, object.getPositionX(), object.getPositionY());
                        System.out.println(temp);
                        break;
                    }
                    object.update(division);
                    time += division;
                }
            } else if (option == 2) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
    /*
        //create a new projectile
        var object = Projectile(initialHeight: height, vX: horizontalVelocity, vY: verticalVelocity)

        print("\tTheoretical\t\t\t\tEuler Approximation")
        print("Time\tHorizontal\tVertical\tHorizontal\tVertical")

        //keep calculate the position, time and velosity until touch the ground
        while(true){
            //get the theoretical position of the object
            let theoreticalX = horizontalVelocity * time
            let theoreticalY = 0.5 * acceleration * (time * time) + verticalVelocity * time + height

            if(theoreticalY >= 0){       //if not under the ground
                //string format
                let temp = String(format: "%4.3f\t%7.2f\t\t%7.3f || \t%7.2f\t\t%7.3f", arguments:[time, theoreticalX, theoreticalY, object.getPositionX(), object.getPositionY()])
                print(temp)
            }
            else{
                //when the object is fall underground, re-calculate the moment that the object hit the ground
                //then use this time to get the position and velocity when this object touch the ground

                //as the object goes up, "a" should be a positive value
                let raiseTime = abs(verticalVelocity / acceleration)
                let totalDistanceInAir = 0.5 * acceleration * (pow(raiseTime, 2)) + verticalVelocity * raiseTime + height
                let fallTime = abs(totalDistanceInAir * 2 / acceleration).squareRoot()
                let totalTimeInAir = raiseTime + fallTime

                let X = horizontalVelocity * totalTimeInAir
                let Y = 0.5 * acceleration * (pow(totalTimeInAir, 2)) + verticalVelocity * totalTimeInAir + height
                object.advance(deltaT: (totalTimeInAir - time))
                //string format
                let temp = String(format: "%4.3f\t%7.2f\t\t%7.3f || \t%7.2f\t\t%7.3f", arguments:[totalTimeInAir, X, Y, object.getPositionX(), object.getPositionY()])
                print(temp)
                break
            }
            object.advance(deltaT: division)
            time += division
        }
        */
