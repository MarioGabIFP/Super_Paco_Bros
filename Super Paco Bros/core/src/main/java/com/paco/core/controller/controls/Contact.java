package com.paco.core.controller.controls;

import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Contact implements ContactListener {

    @Override
    public void beginContact(com.badlogic.gdx.physics.box2d.Contact contact) {
        System.out.println("com.paco.core.controller.controls.Contact.beginContact()");
    }

    @Override
    public void endContact(com.badlogic.gdx.physics.box2d.Contact contact) {
        System.out.println("com.paco.core.controller.controls.Contact.endContact()");
    }

    @Override
    public void preSolve(com.badlogic.gdx.physics.box2d.Contact contact, Manifold oldManifold) {
        System.out.println("com.paco.core.controller.controls.Contact.preSolve()");
    }

    @Override
    public void postSolve(com.badlogic.gdx.physics.box2d.Contact contact, ContactImpulse impulse) {
        System.out.println("com.paco.core.controller.controls.Contact.postSolve()");
    }
    
}
