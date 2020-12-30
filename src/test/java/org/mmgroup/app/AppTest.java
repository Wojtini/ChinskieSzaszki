package org.mmgroup.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mmgroup.UI.FinalWindow;
import org.mmgroup.UI.GUI;
import org.mmgroup.UI.GamePanel;
import org.mmgroup.UI.MainMenu;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        new MainMenu();
        assertTrue( true );
        new FinalWindow("Test");
    }
}
