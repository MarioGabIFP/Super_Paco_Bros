package com.paco.core.gui.frameable;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.paco.core.gui.Graphics;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Map extends Graphics {
    BodyDef bdf;
    PolygonShape shape;
    FixtureDef fixDef;
    Body collider;
    
    public Map() {
        map = mapLoader.load(mapDir + "1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 2);
        fixDef = new FixtureDef();
        shape = new PolygonShape();
        bdf = new BodyDef();
    }
    
    public void createWorldCollaiders() {
        for (MapObject groundBrick : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle r = ((RectangleMapObject) groundBrick).getRectangle();
            
            bdf.type = BodyDef.BodyType.StaticBody;
            bdf.position.set((r.getX() + r.getWidth() / 2) * 2, (r.getY() + (r.getHeight() / 2)) * 2);
            
            collider = world.createBody(bdf);
            
            shape.setAsBox((r.getWidth() / 2) * 2, (r.getHeight() / 2) * 2);
            fixDef.shape = shape;
            collider.createFixture(fixDef);
        }
        
        for (MapObject pipe : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle r = ((RectangleMapObject) pipe).getRectangle();
            
            bdf.type = BodyDef.BodyType.StaticBody;
            bdf.position.set((r.getX() + r.getWidth() / 2) * 2, (r.getY() + (r.getHeight() / 2)) * 2);
            
            collider = world.createBody(bdf);
            
            shape.setAsBox((r.getWidth() / 2) * 2, (r.getHeight() / 2) * 2);
            fixDef.shape = shape;
            collider.createFixture(fixDef);
        }
        
        for (MapObject brick : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle r = ((RectangleMapObject) brick).getRectangle();
            
            bdf.type = BodyDef.BodyType.StaticBody;
            bdf.position.set((r.getX() + r.getWidth() / 2) * 2, (r.getY() + (r.getHeight() / 2)) * 2);
            
            collider = world.createBody(bdf);
            
            shape.setAsBox((r.getWidth() / 2) * 2, (r.getHeight() / 2) * 2);
            fixDef.shape = shape;
            collider.createFixture(fixDef);
        }
    }
}