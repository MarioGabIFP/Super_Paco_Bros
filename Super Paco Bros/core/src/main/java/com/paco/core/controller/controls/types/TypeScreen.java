/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.paco.core.controller.controls.types;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public enum TypeScreen {
    mainMenu,
    level(0, 0);

    int world;
    int levelNum;

    private TypeScreen() {}

    TypeScreen(int world, int levelNum) {
        this.world = world;
        this.levelNum = levelNum;
    }

    public int getWorld() {return world;}
    public int getLevelNum() { return levelNum;}
    public void setWorld(int world) {this.world = world;}
    public void setLevelNum(int levelNum) {this.levelNum = levelNum;}
    public TypeScreen getScreen() {return this;}
}
