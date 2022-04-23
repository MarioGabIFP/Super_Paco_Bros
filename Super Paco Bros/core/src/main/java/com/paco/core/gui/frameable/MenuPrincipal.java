package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.paco.core.gui.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paco.core.controller.controls.Action;
import com.paco.core.controller.controls.Charge;
import static com.paco.core.gui.elements.Assets.titles;
import com.paco.core.models.elements.MenuModel;
import java.util.ArrayList;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class MenuPrincipal extends Background implements MenuModel{
    ArrayList<Image> opts;
    Image title;
    
    Action a = new Action();
    Charge c = new Charge();

    public MenuPrincipal() {
        super();
        opts = new ArrayList<>();
        
        title = loadImage(new Texture(titles + "1.png"), windowW - 450, windowH - 200, 400, 144);
        opts.add(loadImage(new Texture(titles + "2.png"), windowW - 370, windowH - 250, 236, 14));
        opts.add(loadImage(new Texture(titles + "3.png"), windowW - 370, windowH - 300, 236, 14));
        
        pointer.setBounds(windowW - 410, windowH - 250, 14, 14);
        pointer.initialize();
    }

    @Override
    public void buildStage() {
        Gdx.gl.glClearColor(0.435f, 0.518f, 1f, 0);
        
        for (Image sOpt : opts) addActor(sOpt);
        for (Image image : mapArr) addActor(image);
        
        addActor(title);
        addSp(pointer);
    }

    @Override
    public void dispose() {
        atlas.dispose();
        pointer.dispose();
        super.dispose();
    }
    
    @Override
    public void listen() {
        a.pressKey(Gdx.input);
    }

    @Override
    public void initControl(Graphics screen) {
        c.initialize(screen);
    }

    @Override
    public void update(float delta) {
        pointer.update(delta);
    }
}
