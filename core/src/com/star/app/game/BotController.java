package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.star.app.game.helpers.ObjectPool;

public class BotController extends ObjectPool<Bot> {
    private GameController gc;

    @Override
    protected Bot newObject() {
        return new Bot(gc);
    }

    public BotController(GameController gc) {
        this.gc = gc;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Bot bot = activeList.get(i);

            batch.draw(bot.texture, bot.getPosition().x - 30, bot.getPosition().y - 30);
        }
    }

    public void setup(float x, float y, float probability) {
        if (MathUtils.random() <= probability) {
            getActiveElement().activate( x, y,0,0, 30);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
