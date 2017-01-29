package com.ar9013.life07;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import sun.font.TrueTypeFont;
import sun.rmi.runtime.Log;

public class Life07 extends ApplicationAdapter {

	private String TAG = "Life07";
	SpriteBatch batch;
	Texture img;

	private BitmapFont font;
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;

	BitmapFont font_ch;
	FreeTypeFontGenerator generator_ch;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter_ch;

	String strShowText = "Brad 新年快樂 ！！ 奪得先雞"; // 造字檔


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		FileHandle fontFile = Gdx.files.internal("font/yahei_consolas13.ttf");
		generator = new FreeTypeFontGenerator(fontFile);

		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24; // 設定字體大小

		font = generator.generateFont(parameter);

		generator.dispose();

		font.setColor(0.5f, 0.0f, 1.0f, 1); // 設定字體顏色


		Gdx.app.log(TAG, "mBitmapFont.getScaleX() : "+font.getScaleX() +
				", mBitmapFont.getScaleY() " +font.getScaleY());

		// 其他寫法
		generator_ch = new FreeTypeFontGenerator(Gdx.files.internal("font/noto_sans_cjk_tc_reqular.otf"));
		parameter_ch = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter_ch.size=24;
		parameter_ch.characters = strShowText;
		font_ch = generator_ch.generateFont(parameter_ch);
		generator_ch.dispose();

	}

	@Override
	public void render () {
		//Gdx.app.log(TAG,"rendr");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);
		font.draw(batch," FPS:"+Gdx.graphics.getFramesPerSecond(),0,Gdx.graphics.getHeight());
		font_ch.draw(batch,"奪得 ！！ 先雞 \nBrad ！ 新年快樂 !", 0, Gdx.graphics.getHeight()-font.getLineHeight()); // 顯示在 FPS 字串的下方
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
		generator_ch.dispose();
	}
}
