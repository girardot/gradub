package com.jgt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.Dimension;

public class GameStage extends Stage {

    private final static int DELTA_MOVE = 5;

    private final Image player;

    private final Image monster;

    private final KeyboardListener keyboardListener = new KeyboardListener();

    public GameStage() {
        super();

        player = new Image(new Texture("spaceship.png"));
        float playerScreenCenterX = Gdx.graphics.getWidth() / 2 - player.getWidth() / 2;
        float playerScreenCenterY = Gdx.graphics.getHeight() / 2 - player.getHeight() / 2;
        player.setPosition(playerScreenCenterX, playerScreenCenterY);

        monster = new Image(new Texture("badlogic.jpg"));
        monster.setPosition(0,0);
        monster.setSize(50,50);

        addListener(keyboardListener);
        this.setKeyboardFocus(player);

        this.addActor(player);
        this.addActor(monster);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        movePlayer(DELTA_MOVE);
    }

    private void movePlayer(int increment) {
        Vector2 position = new Vector2(player.getX(), player.getY());
        if (keyboardListener.isLeftPressed()) {
            position.x -= increment;
        }
        if (keyboardListener.isRightPressed()) {
            position.x += increment;
        }
        if (keyboardListener.isDownPressed()) {
            position.y -= increment;
        }
        if (keyboardListener.isUpPressed()) {
            position.y += increment;
        }

        boundWithScreen(position, player);
        player.setPosition(position.x, position.y);
    }

    private void boundWithScreen(Vector2 position, Actor targetActor) {
        {
            if (position.x < 0) {
                position.x = 0;
            }
            float maxX = Gdx.graphics.getWidth() - targetActor.getWidth();
            if (position.x > maxX) {
                position.x = maxX;
            }
        }
        {
            if (position.y < 0) {
               position.y = 0;
            }
            float maxY = Gdx.graphics.getHeight() - targetActor.getHeight();
            if (position.y > maxY) {
                position.y = maxY;
            }
        }
    }
}
