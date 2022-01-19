package com.star.app.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class Bot extends Ship implements Poolable {
    private float scale;
    private boolean active;
    private float rotationSpeed;
    private Circle lasso;

    public Bot(GameController gc) {
        super(gc, 30, 100);
        this.position = new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH), MathUtils.random(0, ScreenManager.SCREEN_HEIGHT));
        this.velocity = new Vector2(0, 0);
        this.texture = Assets.getInstance().getAtlas().findRegion("ship");
        this.hitArea = new Circle(position, 29);
        this.active = false;
        this.lasso = new Circle(position, 250);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public void activate(float x, float y, float vx, float vy, float scale) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
        hpMax = (int) (8 * scale + gc.getLevel() * 2);
        hp = hpMax;
        angle = MathUtils.random(0.0f, 360.0f);
        rotationSpeed = MathUtils.random(-180.0f, 180.0f);
        this.scale = scale;
        hitArea.setPosition(position);
//        hitArea.setRadius(250f);
    }

    public Circle getLasso() {
        return lasso;
    }
}
