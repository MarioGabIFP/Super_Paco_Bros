package com.paco.core.controller;

import com.paco.core.controller.controls.types.TypeScreen;
import com.paco.core.controller.elements.Options;
import com.paco.core.models.elements.LevelModel;
import com.paco.core.models.elements.MenuModel;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Orchestrator implements LevelModel, MenuModel, Options{
    public static MainMenu mainOpts;
    public static TypeScreen ts;
}
