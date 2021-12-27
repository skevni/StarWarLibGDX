package ru.gb.sklyarov.game;

public class GameController {
    private Background background;
    private Hero hero;
    private BulletController bulletController;
    private AsteroidController asteroidController;


    public GameController() {
        this.background = new Background(this);
        this.hero = new Hero(this);
        this.asteroidController = new AsteroidController(this);
        this.bulletController = new BulletController();
    }

    public void update(float dt) {
        background.update(dt);
        hero.update(dt);
        asteroidController.update(dt);
        bulletController.update(dt);
        checkCollisions();
    }

    private void checkCollisions() {
        for (int i = 0; i < bulletController.getActiveList().size(); i++) {
            Bullet bullet = bulletController.getActiveList().get(i);
            for (Asteroid asteroid: asteroidController.getActiveList()) {
                if (asteroid.getPosition().dst(bullet.getPosition()) < 128) {
                    bullet.deactivate();
                    asteroid.deactivate();
                }
            }
        }
    }

    public Hero getHero() {
        return hero;
    }

    public Background getBackground() {
        return background;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public BulletController getBulletController() {
        return bulletController;
    }


}
