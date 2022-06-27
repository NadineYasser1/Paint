/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;

/**
 *
 * @author nadineyasser
 */
public class Triangle extends Shape {
    private int[] x;
    private int[] y;

    public Triangle(int[] x, int[] y, Color color) {
        super(color);
        this.x = x;
        this.y = y;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int[] getY() {
        return y;
    }
    
    
}
