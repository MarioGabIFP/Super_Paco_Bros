/**
 * 
 */
package com.paco.model;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * @author Brad lopez
 *
 */
public interface MusicElements {
	Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle("Sound/MusicBackground.mp3", FileType.Internal));

}
