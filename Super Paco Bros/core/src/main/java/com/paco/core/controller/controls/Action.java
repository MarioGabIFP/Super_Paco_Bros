package com.paco.core.controller.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.paco.core.controller.Orchestrator;
import com.paco.core.controller.ScreenController;
import com.paco.core.controller.controls.types.ModelActions;
import com.paco.core.gui.Graphics;
import com.paco.core.gui.frameable.Level;
import com.paco.core.models.ModelBase;
import com.paco.core.models.Player;
import com.paco.core.models.Pointer;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Action extends Orchestrator {    
    private Player pl;
    private Pointer ptr;
    
    private final Graphics screen;
    
    public Action(Graphics screen) {this.screen = screen;}
    
    public void pressKey(Input i, ModelBase actor) {
        if (actor.getActor() == ModelBase.Actors.player) {
            pl = (Player) actor; 
        } else if (actor.getActor() == ModelBase.Actors.pointer) {
            ptr = (Pointer) actor; 
        }
        
        switch (ts.getScreen()) {
            case mainMenu: {
                if (ptr != null) {
                    if (i.isKeyJustPressed(Input.Keys.DOWN) && mainOpts == MainMenu._1p) {
                        ptr.setAction(ModelActions.PointerAction.swwitch, false);
                        mainOpts = MainMenu._2p;

                    } else if (i.isKeyJustPressed(Input.Keys.UP) && mainOpts == MainMenu._2p) {
                        ptr.setAction(ModelActions.PointerAction.swwitch, true);
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
            }
                
            case level: {
                time = time + Gdx.graphics.getDeltaTime();
                if (pl != null) {
                    if (i.isKeyPressed(Input.Keys.RIGHT)) pl.setAction(ModelActions.PlayerAction.run, false);
                    if (i.isKeyPressed(Input.Keys.LEFT)) pl.setAction(ModelActions.PlayerAction.run, true);
                    if (i.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) pl.setAction(ModelActions.PlayerAction.jump, pl.isFlipX());
                    
                    if (pl.isDead()) {
                        if ((time - pl.getDeadTime()) > 3) {
                            ScreenController.getInst().showScreen(new Level());
                        }
                    } else {
                        pl.setDeadTime(time);
                    }
                }
            }
        }
    }
}
