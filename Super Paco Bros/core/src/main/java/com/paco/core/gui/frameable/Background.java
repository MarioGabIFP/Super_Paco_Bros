package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paco.core.gui.Graphics;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Background extends Graphics {
    ArrayList<Image> mapArr;
    TextureAtlas atlas;
    
    public Background() {
        int x;
        int y;
        int h;
        Image tile;
        mapArr = new ArrayList<>();
        atlas = new TextureAtlas(Gdx.files.internal(level + "LevelTextures.atlas"));
        
        x = 0;
        y = 16;
        for (int i = 0; i < 64; i++) {
            tile = new Image(atlas.findRegion("0"));
            tile.setBounds(x, y, 16, 16);
            y += 32; 
            if (y == 80) {
                x += 32;
                y = 16;
            }
            mapArr.add(tile);
        }
        
        x = 16;
        y = 16;
        for (int i = 0; i < 64; i++) {
            tile = new Image(atlas.findRegion("4"));
            tile.setBounds(x, y, 16, 16);
            y += 32; 
            if (y == 80) {
                x += 32;
                y = 16;
            }
            mapArr.add(tile);
        }
        
        x = 0;
        y = 0;
        for (int i = 0; i < 64; i++) {
            tile = new Image(atlas.findRegion("1"));
            tile.setBounds(x, y, 16, 16);
            y += 32; 
            if (y == 64) {
                x += 32;
                y = 0;
            }
            mapArr.add(tile);
        }
        
        x = 16;
        y = 0;
        for (int i = 0; i < 64; i++) {
            tile = new Image(atlas.findRegion("5"));
            tile.setBounds(x, y, 16, 16);
            y += 32; 
            if (y == 64) {
                x += 32;
                y = 0;
            }
            mapArr.add(tile);
        }
        
        tile = new Image(atlas.findRegion("38"));
        tile.setBounds(64, 128, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("42"));
        tile.setBounds(80, 128, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("46"));
        tile.setBounds(80, 112, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("39"));
        tile.setBounds(96, 96, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("46"));
        tile.setBounds(96, 80, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("39"));
        tile.setBounds(48, 96, 16, 16);
        mapArr.add(tile);
        
        tile = new Image(atlas.findRegion("46"));
        tile.setBounds(48, 80, 16, 16);
        mapArr.add(tile);
        
        x = 96;
        y = 128;
        h = 4;
        for (int i = 0; i < h; i++) {
            tile = new Image(atlas.findRegion("51"));
            tile.setBounds(x, y, 16, 16);
            mapArr.add(tile);
            mapArr.add(tile);
            y -= 16;
            
            tile = new Image(atlas.findRegion("50"));
            tile.setBounds(x, y, 16, 16);
            mapArr.add(tile);
            x += 16;
            
            if (i == (h - 1)) {
                tile = new Image(atlas.findRegion("51"));
                tile.setBounds(x, y, 16, 16);
                mapArr.add(tile);
                mapArr.add(tile);
            }
        }
        
        x = 48;
        y = 128;
        h = 4;
        for (int i = 0; i < h; i++) {
            tile = new Image(atlas.findRegion("54"));
            tile.setBounds(x, y, 16, 16);
            mapArr.add(tile);
            mapArr.add(tile);
            y -= 16;
            
            tile = new Image(atlas.findRegion("47"));
            tile.setBounds(x, y, 16, 16);
            mapArr.add(tile);
            x -= 16;
            
            if (i == (h - 1)) {
                tile = new Image(atlas.findRegion("54"));
                tile.setBounds(x, y, 16, 16);
                mapArr.add(tile);
                mapArr.add(tile);
            }
        }
    }
}
