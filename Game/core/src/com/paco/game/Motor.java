package com.paco.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Motor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("cloud.png") {
			@Override
			public int getHeight() {
				// TODO Auto-generated method stub
				return 200;
			}
			
			@Override
			public int getWidth() {
				// TODO Auto-generated method stub
				return 400;
			}
		};
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		batch.draw(img, 200, 800);
		batch.draw(img, 800, 400);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
