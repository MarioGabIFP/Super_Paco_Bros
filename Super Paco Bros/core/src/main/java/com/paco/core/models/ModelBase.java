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
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.paco.core.controller.controls.types.ModelActions;
import com.paco.core.gui.Graphics;
import com.paco.core.models.elements.ModelFunctions;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class ModelBase extends Sprite implements ModelFunctions{
    private BodyDef bodyDef;
    private FixtureDef fixtureDef;
    private CircleShape circleShape;
    private PolygonShape polygonShape;
    private MassData massData;
    private EdgeShape baldSpot;
    private World world;
    private Rectangle bnds;
    
    public Body collider;
    public MapObject obj;
    public TiledMap map;
    public Fixture objFixture, baldFixture, bodyFixture;
    
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
    
    public final void setCharacter(boolean character) {this.character = character;}
    public final Fixture getObjFixture() {return objFixture;}
    public final Fixture getBaldFixture() {return baldFixture;}
    public final Fixture getBodyFixture() {return bodyFixture;}
    public final boolean isCharacter() {return character;}
    
    public void setAction(ModelActions.PlayerAction a, boolean ggLeft) {}
    public void setAction(ModelActions.PointerAction a, boolean ggLeft) {}
    
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
            objFixture = collider.createFixture(fixtureDef);
        } else {
            circleShape = new CircleShape();
            massData = new MassData();
            baldSpot = new EdgeShape();

            bodyDef.position.set(getX() + getWidth() / 2, getY() + getHeight() / 2);
            bodyDef.type = BodyDef.BodyType.DynamicBody;

            collider = world.createBody(bodyDef);

            circleShape.setRadius(getWidth() / 4);

            fixtureDef.shape = circleShape;

            bodyFixture = collider.createFixture(fixtureDef);

            baldSpot.set(new Vector2(-4, getHeight() / 4), new Vector2(4, getHeight() / 4));

            fixtureDef.shape = baldSpot;
            fixtureDef.isSensor = true;

            baldFixture = collider.createFixture(fixtureDef);

            massData.mass = 1;

            collider.setMassData(massData);
        }
    }
}
