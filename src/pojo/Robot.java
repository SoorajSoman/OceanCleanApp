package pojo;
/**
 * Robot class
 *
 * X,Y,Direction
 **/

public class Robot {
    int x,y;
    char currentdirection;

    public Robot(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.currentdirection = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCurrentdirection() {
        return currentdirection;
    }
}
