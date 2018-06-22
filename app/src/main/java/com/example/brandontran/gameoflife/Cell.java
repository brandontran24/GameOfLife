package com.example.brandontran.gameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.brandontran.gameoflife.Cell;

import java.util.ArrayList;
import java.util.Calendar;

public class Cell{

    private boolean alive;
    private int posx;
    private int posy;

    public int getPosx() {
        return posx;
    }

    public int getPosy(){
        return posy;
    }

    public boolean isAlive(){
        return alive;
    }

    public void ressurrect(){
        alive = true;
    }

    public void kill(){
        alive = false;
    }

    public Cell(int x, int y){
        posx = x;
        posy = y;
        alive = false;
    }
}
