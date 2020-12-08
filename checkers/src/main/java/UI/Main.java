package UI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500,500));
        Plansza pl = new Plansza();
        frame.add(pl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
