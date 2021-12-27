package ru.gb.sklyarov.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.gb.sklyarov.game.GameController;
import ru.gb.sklyarov.game.WorldRenderer;

public class GameScreen extends AbstractScreen {
    private SpriteBatch spriteBatch;
    private GameController gameController;
    private WorldRenderer worldRenderer;

    public GameScreen(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    @Override
    public void show() {
        this.gameController = new GameController();
        this.worldRenderer = new WorldRenderer(gameController, spriteBatch);
//        super.show();
    }

    @Override
    public void render(float delta) {
        this.gameController.update(delta);
        this.worldRenderer.render();
//        super.render(delta);
    }
}
