package ru.gb.sklyarov.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import ru.gb.sklyarov.game.helpers.ObjectPool;
import ru.gb.sklyarov.screen.ScreenManager;

public class AsteroidController extends ObjectPool<Asteroid> {
    private final GameController gameController;
    private final Texture texture;

    @Override
    protected Asteroid newObject() {
        return new Asteroid();
    }

    public AsteroidController(GameController gameController) {
        this.gameController = gameController;
        this.texture = new Texture("asteroid.png");
        setup(MathUtils.random(0, ScreenManager.SCREEN_WIDTH), MathUtils.random(0, ScreenManager.SCREEN_HEIGHT),
                100,100);
    }

    public void render(SpriteBatch batch) {
        for (Asteroid asteroid : activeList) {
            batch.draw(texture, asteroid.getPosition().x - 128, asteroid.getPosition().y - 128);
        }
    }

    public void setup(float x, float y, float vx, float vy){
        getActiveElement().activate(x, y, vx, vy);
    }

    public void update(float dt){
        for (Asteroid asteroid : activeList) {
            asteroid.update(dt);
        }
        checkPool();
    }
}
