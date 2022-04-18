/**
 * 
 */
package com.paco.model;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * @author Grupo2
 *
 */
public interface SoundElements {

	Sound jump = Gdx.audio.newSound(Gdx.files.getFileHandle("SoundEffects/Jump.mp3", FileType.Internal));
	Sound lose = Gdx.audio.newSound(Gdx.files.getFileHandle("SoundEffects/Lose.mp3", FileType.Internal));
	Sound coin = Gdx.audio.newSound(Gdx.files.getFileHandle("SoundEffects/Coin.mp3", FileType.Internal));
	Sound bigger = Gdx.audio.newSound(Gdx.files.getFileHandle("SoundEffects/Bigger.mp3", FileType.Internal));
	Sound win = Gdx.audio.newSound(Gdx.files.getFileHandle("SoundEffects/Win.mp3", FileType.Internal));
	
}
