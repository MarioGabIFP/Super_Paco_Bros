package com.paco.core.controller.controls;

import com.badlogic.gdx.Input;
import com.paco.core.controller.Orchestrator;
import com.paco.core.controller.ScreenController;
import com.paco.core.controller.controls.types.ModelActions;
import com.paco.core.gui.frameable.Level;
import com.paco.core.models.ModelBase;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Action extends Orchestrator {    
    public void pressKey(Input i, ModelBase actor) {
        switch (ts.getScreen()) {
            case mainMenu: {
                if (i.isKeyJustPressed(Input.Keys.DOWN) && mainOpts == MainMenu._1p) {
                    actor.setAction(ModelActions.PointerAction.swwitch, false);
                    mainOpts = MainMenu._2p;
                    
                } else if (i.isKeyJustPressed(Input.Keys.UP) && mainOpts == MainMenu._2p) {
                    actor.setAction(ModelActions.PointerAction.swwitch, true);
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
                if (i.isKeyPressed(Input.Keys.RIGHT)) actor.setAction(ModelActions.PlayerAction.run, false);
                if (i.isKeyPressed(Input.Keys.LEFT)) actor.setAction(ModelActions.PlayerAction.run, true);
                if (i.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) actor.setAction(ModelActions.PlayerAction.jump, actor.isFlipX());
            }
        }
    }
}
