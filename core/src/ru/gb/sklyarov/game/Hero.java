package ru.gb.sklyarov.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import ru.gb.sklyarov.screen.ScreenManager;

public class Hero {
    private GameController gameController;
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private float angle;
    private float enginePower;
    private float fireTimer;


    public Vector2 getVelocity() {
        return velocity;
    }

    public Hero(GameController gameController) {
        this.gameController = gameController;
        this.texture = new Texture("ship.png");
        this.position = new Vector2(ScreenManager.SCREEN_WIDTH / 2, ScreenManager.SCREEN_HEIGHT / 2);
        this.velocity = new Vector2(0, 0);
        this.angle = 0.0f;
        this.enginePower = 300.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32,
                64, 64, 1, 1,
                angle, 0, 0, 64, 64, false, false);
    }

    public void update(float dt) {
        fireTimer += dt;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if (fireTimer > 0.2f) {
                fireTimer = 0.0f;
                gameController.getBulletController().setup(position.x, position.y,
                        MathUtils.cosDeg(angle) * 500.0f + velocity.x ,
                        MathUtils.sinDeg(angle) * 500.0f + velocity.y );
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.x += MathUtils.cosDeg(angle) * enginePower * dt;
            velocity.y += MathUtils.sinDeg(angle) * enginePower * dt;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.x -= MathUtils.cosDeg(angle) * (enginePower / 2) * dt;
            velocity.y -= MathUtils.sinDeg(angle) * (enginePower / 2) * dt;
        }
        position.mulAdd(velocity, dt);

        float stopCoefficient = 1.0f - 0.8f * dt;
        if (stopCoefficient < 0.0f) {
            stopCoefficient = 0.0f;
        }
        velocity.scl(stopCoefficient);

        if (position.x < 32) {
            position.x = 32;
            velocity.x *= -0.5f;
        }

        if (position.x > ScreenManager.SCREEN_WIDTH - 32) {
            position.x = ScreenManager.SCREEN_WIDTH - 32;
            velocity.x *= -0.5f;
        }

        if (position.y < 32) {
            position.y = 32;
            velocity.y *= -0.5f;
        }

        if (position.y > ScreenManager.SCREEN_HEIGHT - 32) {
            position.y = ScreenManager.SCREEN_HEIGHT - 32;
            velocity.y *= -0.5f;
        }


    }
}
