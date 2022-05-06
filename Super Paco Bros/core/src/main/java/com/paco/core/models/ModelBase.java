package com.paco.core.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.paco.core.controller.controls.types.ModelActions;
import com.paco.core.gui.Graphics;
import com.paco.core.models.elements.ModelFunctions;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class ModelBase extends Sprite implements ModelFunctions{
    public enum Actors {player,pointer;}
    
    private BodyDef bodyDef;
    private FixtureDef fixtureDef;
    private PolygonShape rectShape, polygonShape;
    private MassData massData;
    private EdgeShape baldSpot;
    private Rectangle bnds;
    private World world;
    private boolean character;
    
    public Body collider;
    public MapObject obj;
    public TiledMap map;
    public Fixture objFixture, fistFixture, bodyFixture;
    public Actors actor;
    
    public final ArrayList<Fixture> fixtures = new ArrayList<>();

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
    public final Fixture getBaldFixture() {return fistFixture;}
    public final Fixture getBodyFixture() {return bodyFixture;}
    public final Actors getActor() {return actor;}
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
            fixtures.add(objFixture);
        } else {
            rectShape = new PolygonShape();
            massData = new MassData();
            baldSpot = new EdgeShape();

            bodyDef.position.set(getX() + getWidth() / 2, getY() + getHeight() / 2);
            bodyDef.type = BodyDef.BodyType.DynamicBody;

            collider = world.createBody(bodyDef);

            rectShape.setAsBox((getWidth() / 5) - 2, (getHeight() / 4) - 2);

            fixtureDef.shape = rectShape;

            bodyFixture = collider.createFixture(fixtureDef);
            fixtures.add(bodyFixture);

            baldSpot.set(new Vector2(8, getHeight() / 4), new Vector2(16, getHeight() / 4));

            fixtureDef.shape = baldSpot;
            fixtureDef.isSensor = true;

            fistFixture = collider.createFixture(fixtureDef);
            fixtures.add(fistFixture);

            massData.mass = 1;

            collider.setMassData(massData);
        }
    }
}
