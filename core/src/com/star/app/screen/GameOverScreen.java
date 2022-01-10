package com.star.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.utils.Assets;
import com.star.app.screen.utils.ProcessingResult;
import com.star.app.screen.utils.Result;

public class GameOverScreen extends AbstractScreen {
    private BitmapFont font72;
    private BitmapFont font24;
    private Stage stage;
    private int score;
    private int hp;
    private int money;

    public GameOverScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        this.stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
        this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf");
        this.font24 = Assets.getInstance().getAssetManager().get("fonts/font24.ttf");

        Gdx.input.setInputProcessor(stage);
        Result result = ProcessingResult.deserialize();
        this.score = result.getScore();
        this.money = result.getMoney();
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1.0f);
        batch.begin();
        font72.draw(batch, "GAME OVER", 0, 600, ScreenManager.SCREEN_WIDTH, Align.center, false);
        font24.draw(batch, "SCORE: " + score + "\nMONEY: " + money,
                0, 300, ScreenManager.SCREEN_WIDTH, Align.center, false);

        font24.draw(batch, "Press F5 to load main menu...",
                0, 100, ScreenManager.SCREEN_WIDTH, Align.center, false);
        batch.end();
        stage.draw();
    }

    private void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.F5)) {
            ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.MENU);
        }
        stage.act(delta);
    }
}
