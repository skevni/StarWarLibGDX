package ru.gb.sklyarov;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private final Texture texture;
    private final Vector2 position;
    private final float angle;

    public Asteroid() {
        this.texture = new Texture("asteroid.png");
        this.position = new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH), MathUtils.random(0, ScreenManager.SCREEN_HEIGHT));
        this.angle = 1.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 128, position.y - 128, 128, 128,
                256, 256, 1, 1,
                angle, 0, 0, 256, 256, false, false);
    }

    public void update(float dt) {
        // появление астероида пока предсказуемо. Сделал так, как вы говорили.
        if (position.y > ScreenManager.SCREEN_HEIGHT + 130) {
            position.y -= ScreenManager.SCREEN_HEIGHT + 260;
//            position.x = MathUtils.random(-130, ScreenManager.SCREEN_WIDTH + 130);
        }

        if (position.x < -130) {
            position.x += ScreenManager.SCREEN_WIDTH + 260;
//            position.y = MathUtils.random(-130, ScreenManager.SCREEN_HEIGHT + 130);
        }
        position.x -= MathUtils.cosDeg(angle) * 50.0f * dt;
        position.y += MathUtils.sinDeg(angle * 55) * 50.0f * dt;


    }
}
