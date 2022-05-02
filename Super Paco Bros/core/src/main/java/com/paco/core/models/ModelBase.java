package com.paco.core.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.paco.core.gui.Graphics;
import com.paco.core.models.elements.ModelFunctions;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class ModelBase extends Sprite implements ModelFunctions{
    BodyDef bodyDef;
    Body collider;
    FixtureDef fixtureDef;
    CircleShape circleShape;
    PolygonShape polygonShape;
    MassData massData;
    EdgeShape baldSpot;
    MapObject obj;
    World world;
    TiledMap map;
    Rectangle bnds;
    
    boolean character;

    public ModelBase() {}
    
    public ModelBase(Graphics screen, MapObject obj) {
        this.world = screen.world;
        this.map = screen.map;
        this.obj = obj;
        this.bnds = ((RectangleMapObject) obj).getRectangle();
    }
    
    public ModelBase(Graphics screen) {
        this.world = screen.world;
        this.map = screen.map;
    }
    
    public boolean isCharacter() {return character;}
    public void setCharacter(boolean character) {this.character = character;}
    
    public void initModel() {   
        bodyDef = new BodyDef();
        fixtureDef = new FixtureDef();
        
        if (!isCharacter()) {
            polygonShape = new PolygonShape();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((bnds.getX() + bnds.getWidth() / 2) * 2, (bnds.getY() + bnds.getHeight()/ 2) * 2);

            collider = world.createBody(bodyDef);

            polygonShape.setAsBox((bnds.getWidth() / 2) * 2, (bnds.getHeight() / 2) * 2);
            fixtureDef.shape = polygonShape;
            collider.createFixture(fixtureDef);
        } else {
            circleShape = new CircleShape();
            massData = new MassData();
            baldSpot = new EdgeShape();

            bodyDef.position.set(getX() + getWidth() / 2, getY() + getHeight() / 2);
            bodyDef.type = BodyDef.BodyType.DynamicBody;

            collider = world.createBody(bodyDef);

            circleShape.setRadius(getWidth() / 4);

            fixtureDef.shape = circleShape;

            collider.createFixture(fixtureDef);

            baldSpot.set(new Vector2(-4, getHeight() / 4), new Vector2(4, getHeight() / 4));

            fixtureDef.shape = baldSpot;
            fixtureDef.isSensor = true;

            collider.createFixture(fixtureDef).setUserData("baldSpot");

            massData.mass = 1;

            collider.setMassData(massData);
        }
    }
}
