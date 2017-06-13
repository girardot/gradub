package com.jgt.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class KeyboardListener extends InputListener {

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;
    private boolean isUpPressed = false;
    private boolean isDownPressed = false;

    @Override
    public boolean keyUp(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                isLeftPressed = false;
                break;
            case Input.Keys.RIGHT:
                isRightPressed = false;
                break;
            case Input.Keys.UP:
                isUpPressed = false;
                break;
            case Input.Keys.DOWN:
                isDownPressed = false;
                break;
            default:
                break;
        }

        return super.keyUp(event, keycode);
    }

    @Override
    public boolean keyDown(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                isLeftPressed = true;
                break;
            case Input.Keys.RIGHT:
                isRightPressed = true;
                break;
            case Input.Keys.UP:
                isUpPressed = true;
                break;
            case Input.Keys.DOWN:
                isDownPressed = true;
                break;
            default:
                break;
        }
        return super.keyDown(event, keycode);
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }

    public boolean isUpPressed() {
        return isUpPressed;
    }

    public boolean isDownPressed() {
        return isDownPressed;
    }
}
