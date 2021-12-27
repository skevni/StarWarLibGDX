package ru.gb.sklyarov.game;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import ru.gb.sklyarov.game.helpers.Poolable;
import ru.gb.sklyarov.screen.ScreenManager;

public class Asteroid implements Poolable {

    private final Vector2 position;
    private float angle;
    private boolean active;
    private Vector2 velocity;

    public Asteroid() {
        this.position = new Vector2(0, 0);
        this.angle = 1.0f;
        this.velocity = new Vector2(0, 0);
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

    @Override
    public boolean isActive() {
        return active;
    }

    public void activate(float x, float y, float vx, float vy) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
