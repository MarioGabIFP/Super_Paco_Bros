package com.paco.core.controller.controls;

import com.badlogic.gdx.Input;
import com.paco.core.controller.Orchestrator;
import com.paco.core.controller.ScreenController;
import com.paco.core.gui.frameable.Level;
import com.paco.core.models.Player;
import com.paco.core.models.Pointer;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Action extends Orchestrator {    
    public void pressKey(Input i) {
        switch (ts.getScreen()) {
            case mainMenu: {
                if (i.isKeyJustPressed(Input.Keys.DOWN) && mainOpts == MainMenu._1p) {
                    pointer.setAction(Pointer.Action.swwitch, false);
                    mainOpts = MainMenu._2p;
                    
                } else if (i.isKeyJustPressed(Input.Keys.UP) && mainOpts == MainMenu._2p) {
                    pointer.setAction(Pointer.Action.swwitch, true);
                    mainOpts = MainMenu._1p;
                    
                } else if (i.isKeyJustPressed(Input.Keys.SPACE)) {
                    switch (mainOpts.getSelected()) {
                        case _1p: 
                            ScreenController.getInst().showScreen(new Level());
                            break;
                        case _2p: 
                            System.out.println(MainMenu._2p);
                            break;
                    }
                }
            }
                
            case level: {
                if (i.isKeyPressed(Input.Keys.RIGHT)) player.setAction(Player.Action.run, false);
                if (i.isKeyPressed(Input.Keys.LEFT)) player.setAction(Player.Action.run, true);
                if (i.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) player.setAction(Player.Action.jump, player.isFlipX());
            }
        }
    }
}
