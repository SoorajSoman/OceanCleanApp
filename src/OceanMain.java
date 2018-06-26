import constant.Constants;
import pojo.Robot;

public class OceanMain {

    // Initial limits seabed limit  5,5
    int limitx = 5, limity = 5;

    public static void main(String[] args) throws Exception {

        /**
         *
         * These are the input as mentioned in the coding challenge
         *
         *          1,2,N
         *        LMLMLMLMM
         * **/

        int x = 1, y = 2;

        char dir = 'N';

        //Input command as string
        String inpCommand = "LMLMLMLMM";




        //command array index
        int k = 0;

        //Converting string commands in to  char array of commands
        char[] cmdArray = inpCommand.toCharArray();


        //Creating robot object and copying to initial object
        Robot initRobot = new Robot(x, y, dir);
        Robot robotUpdate = initRobot;



        //creating OceanMain class  object
        OceanMain oceanMain = new OceanMain();


        //for better understanding input given  along  the question
        System.out.println("<----INPUT----->");
        System.out.println("*********\n");
        System.out.println(oceanMain.limitx+", "+oceanMain.limity);
        System.out.println(robotUpdate.getX() + ", " + robotUpdate.getY() + ", " + robotUpdate.getCurrentdirection());
        System.out.println(inpCommand);
        System.out.println("*********\n");
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("LOOPING");
        System.out.println("*********\n");

        while (k < cmdArray.length) {

            robotUpdate = oceanMain.updateRobotObject(robotUpdate.getCurrentdirection(), cmdArray[k], robotUpdate);

            k++;
        }

        System.out.println("*********");
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("<----OUTPUT----->");
        System.out.println("\n*********\n");

        System.out.println(robotUpdate.getX() + ", " + robotUpdate.getY() + ", " + robotUpdate.getCurrentdirection());


    }


    /**
     * UPDATE ROBOT OBJECTS
     **/
    public Robot updateRobotObject(char direction, char command, Robot robotObject) {
        Robot robot = null;
        try {
            if ((robotObject.getX() <= limitx) && (robotObject.getY() <= limity)) {
                System.out.println("----------");
                System.out.println("command " + command);
                System.out.println("x-coordinate: " + robotObject.getX());
                System.out.println("y-coordinate: " + robotObject.getY());
                System.out.println("direction: " + robotObject.getCurrentdirection());
                System.out.println("------------");
                switch (direction) {

                    case Constants.NORTH:
                        robot = computeDirectionN(command, robotObject);

                        break;
                    case Constants.SOUTH:
                        robot = computeDirectionS(command, robotObject);
                        break;
                    case Constants.EAST:
                        robot = computeDirectionE(command, robotObject);
                        break;
                    case Constants.WEST:
                        robot = computeDirectionW(command, robotObject);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return robot;
    }


    /**
     * compute new X,Y,D with  for
     * current direction W
     **/

    private Robot computeDirectionW(char command, Robot robotObject) {
        Robot r = null;
        try {
            if (command == Constants.LEFT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.SOUTH);


            } else if (command == Constants.RIGHT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.NORTH);

            } else if (command == Constants.MOVE) {
                r = new Robot(robotObject.getX() - 1, robotObject.getY(), robotObject.getCurrentdirection());

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * compute new X,Y,D with  for
     * current direction E
     **/
    private Robot computeDirectionE(char command, Robot robotObject) {
        Robot r = null;
        try {
            if (command == Constants.LEFT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.NORTH);
            } else if (command == Constants.RIGHT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.SOUTH);
            } else if (command == Constants.MOVE) {
                r = new Robot(robotObject.getX() + 1, robotObject.getY(), robotObject.getCurrentdirection());

            }
        } catch (NullPointerException e) {

            e.printStackTrace();
        }
        return r;
    }

    /**
     * compute new X,Y,D with  for
     * current direction S
     **/

    private Robot computeDirectionS(char command, Robot robotObject) {
        Robot r = null;
        try {
            if (command == Constants.LEFT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.EAST);
            } else if (command == Constants.RIGHT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.WEST);
            } else if (command == Constants.MOVE) {
                r = new Robot(robotObject.getX(), robotObject.getY() - 1, robotObject.getCurrentdirection());

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * compute new X,Y,D with  for
     * current direction N
     **/
    private Robot computeDirectionN(char command, Robot robotObject) {
        Robot r = null;
        try {
            if (command == Constants.LEFT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.WEST);
            } else if (command == Constants.RIGHT) {
                r = new Robot(robotObject.getX(), robotObject.getY(), Constants.EAST);
            } else if (command == Constants.MOVE) {

                r = new Robot(robotObject.getX(), robotObject.getY() + 1, robotObject.getCurrentdirection());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return r;
    }

}
