package Painting_Canvas_9;

import java.awt.Color;

public class Line extends Shape {

    /*
    * This Class is about Dimensions
    * The Height and Width
    * The Size of the Line
    * The Slope [ Is the most important part in this Class ]
    * etc...
    * */

    int size;
    float m; // slope - مــيــــل

    // [[ Constructor Line ]] Method
    // X and Y are the Starting Point
    // X2 and Y2 are the Ending Point
    public Line(int x, int y, int x2, int y2, Color c, int size) {
        super(x, y, x2, y2, c);
        this.size = size;

        if (x2 != x) {
            this.m = (float) (y2 - y) / (x2 - x); //slope for the equation
        } else {
            this.m = 1;
        }
    }

    // [[ Move ]] Method
    @Override
    public void move(int x, int y) {

        this.w = (x - this.x) + this.w;  //w is x2
        this.h = (y - this.y) + this.h;  // h is y2
        this.x = x;
        this.y = y;
    }

    // [[ Contains ]] Method
    @Override
    public boolean contains(int x, int y) {

        if ((this.w >= this.x) && (this.y >= this.h)) {
            if (x >= this.x && x <= this.w && y <= this.y && y >= this.h) {
                return control(x, y);
            }
        } else if ((this.w >= this.x) && (this.y <= this.h)) {
            if (x >= this.x && x <= this.w && y >= this.y && y <= this.h) {
                return control(x, y);
            }
        } else if ((this.x >= this.w) && (this.y >= this.h)) {
            if (x <= this.x && x >= this.w && y <= this.y && y >= this.h) {
                return control(x, y);
            }
        } else if ((this.x >= this.w) && (this.y <= this.h)) {
            if (x <= this.x && x >= this.w && y >= this.y && y <= this.h) {
                return control(x, y);
            }
        }
        return false;
    }


    // [[ Control ]] Method
    // It's about Dimensions Stuff.
    public boolean control(float x, float y) {
        for (int i = -20; i < 20; i++) {
            if ((int) (this.y - (y + i)) == (int) (m * (this.x - x))) {
                return true;
            }
        }
        for (int i = -20; i < 20; i++) {
            if ((int) (this.y - y) == (int) (m * (this.x - (x + i)))) {
                return true;
            }
        }
        return false;
    }


    // [[ Get Size ]] Method
    public int getSize() {
        return size;
    }

    // [[ Set Size ]] Method
    public void setSize(int size) {
        this.size = size;
    }


}
