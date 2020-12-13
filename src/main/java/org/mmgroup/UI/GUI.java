package org.mmgroup.UI;

import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Field;
import org.mmgroup.gamelogic.Game;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    GamePanel panel = new GamePanel();
    public GUI(){
        this.setVisible(true);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
