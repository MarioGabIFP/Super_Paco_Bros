package com.paco.core.gui.elements;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import static com.paco.core.gui.elements.Assets.musicAssets;
import com.badlogic.gdx.audio.Sound;

/**
 * @author Brad Lopez
 * @author Paolo
 */
public interface FX extends Base {
    Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle(musicAssets + "1.mp3", FileType.Internal));
    
    Sound pause = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "2.mp3", FileType.Internal));
    Sound bigger = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "3.mp3", FileType.Internal));
    Sound coin = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "4.mp3", FileType.Internal));
    Sound jump = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "5.mp3", FileType.Internal));
    Sound lose = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "6.mp3", FileType.Internal));
    Sound win = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "7.mp3", FileType.Internal));
    Sound gameOver = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "8.mp3", FileType.Internal));
    Sound drink = Gdx.audio.newSound(Gdx.files.getFileHandle(musicAssets + "9.mp3", FileType.Internal));
}
