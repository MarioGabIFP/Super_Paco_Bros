package com.paco.core.controller.controls;

import com.paco.core.controller.Orchestrator;
import com.paco.core.controller.controls.types.TypeScreen;
import com.paco.core.gui.Graphics;
import com.paco.core.gui.frameable.Level;
import com.paco.core.gui.frameable.Menu;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Charge extends Orchestrator {
    public void initialize(Graphics screen) {
        if (screen instanceof Menu) {
            ts = TypeScreen.mainMenu;
            mainOpts = MainMenu._1p;
        } else if (screen instanceof Level) {
            ts = TypeScreen.level;
            ts.setWorld(1);
            ts.setLevelNum(1);
        } 
    }
}
