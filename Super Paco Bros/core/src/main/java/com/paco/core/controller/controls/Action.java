package com.paco.core.controller.controls;

import com.badlogic.gdx.Input;
import com.paco.core.controller.Orchestrator;
import com.paco.core.controller.ScreenController;
import com.paco.core.gui.frameable.Level;
import com.paco.core.models.Player;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Action extends Orchestrator {    
    public void pressKey(Input i) {
        switch (ts.getScreen()) {
            case mainMenu: {
                if (i.isKeyJustPressed(Input.Keys.DOWN) && mainOpts == MainMenu._1p) {
                    pointer.getPointerImage().setY(pointer.getPointerImage().getY() - 50);
                    mainOpts = MainMenu._2p;
                    
                } else if (i.isKeyJustPressed(Input.Keys.UP) && mainOpts == MainMenu._2p) {
                    pointer.getPointerImage().setY(pointer.getPointerImage().getY() + 50);
                    mainOpts = MainMenu._1p;
                    
                } else if (i.isKeyJustPressed(Input.Keys.SPACE)) {
                    switch (mainOpts.getSelected()) {
                        case _1p: {
                            ScreenController.getInst().showScreen(new Level());
                            break;
                        }
                        case _2p: {
                            System.out.println(MainMenu._2p);
                            break;
                        }
                    }
                }
            }
                
            case level: {
                if (i.isKeyJustPressed(Input.Keys.RIGHT)) player.setDir(Player.Dir.right);
                if (i.isKeyJustPressed(Input.Keys.LEFT)) player.setDir(Player.Dir.left);
                if (i.isKeyPressed(Input.Keys.RIGHT)) player.run();
                if (i.isKeyPressed(Input.Keys.LEFT)) player.run();
            }
        }
    }
}
