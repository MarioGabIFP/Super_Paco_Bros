package com.paco.core.gui.frameable;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.paco.core.gui.Graphics;
import com.paco.core.models.Beer;
import com.paco.core.models.BeginCollider;
import com.paco.core.models.Brick;
import com.paco.core.models.EndCollider;
import com.paco.core.models.Gap;
import com.paco.core.models.Ground;
import com.paco.core.models.ModelBase;
import com.paco.core.models.Pipe;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Map extends Graphics{
    ModelBase pipe;
    ModelBase brick;
    ModelBase ground;
    ModelBase beer;
    ModelBase gap;
    ModelBase beginCollider;
    ModelBase endCollider;
    
    public Map() {
        map = mapLoader.load(mapDir + "2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 2);
        fixDef = new FixtureDef();
        shape = new PolygonShape();
        bdf = new BodyDef();
        
        for (MapObject obj : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            ground = new Ground(super.getMe(), obj);
            ground.initModel(); 
            ground.getObjFixture().setUserData(ground);
        }
        
        for (MapObject obj : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            pipe = new Pipe(super.getMe(), obj);
            pipe.initModel();
            pipe.getObjFixture().setUserData(pipe);
        }
        
        for (MapObject obj : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            beer = new Beer(super.getMe(), obj);
            beer.initModel();
            beer.getObjFixture().setUserData(beer);
        }
        
        for (MapObject obj : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
            brick = new Brick(super.getMe(), obj);
            brick.initModel();
            brick.getObjFixture().setUserData(brick);
        }
        
        for (MapObject obj : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)) {
            gap = new Gap(super.getMe(), obj);
            gap.initModel();
            gap.getObjFixture().setUserData(gap);
        }
        
        for (MapObject obj : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
            beginCollider = new BeginCollider(super.getMe(), obj);
            beginCollider.initModel();
            beginCollider.getObjFixture().setUserData(beginCollider);
        }
        
        for (MapObject obj : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class)) {
            endCollider = new EndCollider(super.getMe(), obj);
            endCollider.initModel();
            endCollider.getObjFixture().setUserData(endCollider);
        }
    }
}