package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pionek {
    private int x;
    private int y;
    boolean zaznaczony = false;
    public  Ellipse2D elipsa;
    //private Rectangle rectangle = new Rectangle(20,20);
    private Color color = Color.lightGray;
    private boolean isActive = false;
    public Pionek(int i,int j){
        this.x=j*20;
        this.y=i*20;
        this.elipsa = new Ellipse2D.Float(this.x,this.y,20,20);
        //this.isActive=isActive;
        //this.setBounds(rectangle);
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){return color;}
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setPionekStatus(boolean status){
        this.isActive = status;
    }
    public boolean getPionekStatus(){
        return isActive;
    }
    public Ellipse2D getElipsa(){
        return elipsa;
    }

}
