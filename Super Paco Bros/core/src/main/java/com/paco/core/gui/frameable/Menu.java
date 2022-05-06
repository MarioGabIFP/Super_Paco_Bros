package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.paco.core.gui.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paco.core.controller.controls.Action;
import static com.paco.core.gui.elements.Assets.titles;
import com.paco.core.models.Pointer;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Menu extends Dummy {
    private final Pointer pointer= new Pointer();
    private final ArrayList<Image> opts = new ArrayList<>();
    private final Image title = loadImage(new Texture(titles + "1.png"), windowW - 450, windowH - 200, 400, 144);

    public Menu() {
        super();
        
        opts.add(loadImage(new Texture(titles + "2.png"), windowW - 370, windowH - 250, 236, 14));
        opts.add(loadImage(new Texture(titles + "3.png"), windowW - 370, windowH - 300, 236, 14));
        
        pointer.setBounds(windowW - 410, windowH - 250, 14, 14);
        pointer.initialize();
    }
    
    @Override public void listen() {((Action) a).pressKey(Gdx.input, pointer); }
    @Override public void initControl(Graphics screen) {c.initialize(screen);}
    @Override public void update(float delta) {pointer.update(delta);}

    @Override
    public void buildStage() {
        for (Image sOpt : opts) addActor(sOpt);
        if (renderer != null) renderer.setView(cam);
        
        addActor(title);
        addSp(pointer);
    }

    @Override
    public void dispose() {
        pointer.dispose();
        super.dispose();
    }
}
