package ru.gb.sklyarov.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldRenderer {
    private GameController gameController;
    private SpriteBatch batch;

    public WorldRenderer(GameController gameController, SpriteBatch spriteBatch) {
        this.gameController = gameController;
        this.batch = spriteBatch;
    }

    public void render() {
        ScreenUtils.clear(0.0f, 0.1f, 0.5f, 1);
        batch.begin();
        gameController.getBackground().render(batch);
        gameController.getHero().render(batch);
        gameController.getAsteroidController().render(batch);
        gameController.getBulletController().render(batch);
        batch.end();
    }
}
