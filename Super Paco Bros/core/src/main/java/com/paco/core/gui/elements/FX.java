package com.paco.core.gui.elements;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import static com.paco.core.gui.elements.Assets.musicAssets;

/**
 * @author Brad Lopez
 */
public interface FX extends Base {
    Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle(musicAssets + "1.mp3", FileType.Internal));
}
