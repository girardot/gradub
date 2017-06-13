package com.jgt.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GradubGame extends Game {
    private GameStage gameStage;

    private ScreenManager screenManager;

    @Override
    public void create() {
        gameStage = new GameStage();
        screenManager = new ScreenManager(gameStage);
        this.setScreen(screenManager);
    }

}
