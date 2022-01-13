package com.star.app.screen.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputKeys {

    public static boolean justPressedF6(){
        return Gdx.input.isKeyJustPressed(Input.Keys.F6);
    }

    public static boolean justPressedCtrlF10(){
        if ( Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT) || Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)) {
            return Gdx.input.isKeyJustPressed(Input.Keys.F10);
        }
        return false;
    }

}
