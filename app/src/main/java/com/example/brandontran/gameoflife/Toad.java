package com.example.brandontran.gameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Toad extends AppCompatActivity {

    ImageView[] views = new ImageView[36];
    Cell[][] cells = new Cell[6][6];
    Cell[][] newcells = new Cell[6][6];
    int generation = 0;
    int cellCount = 0;
    int runSpeed = 500;

    private void startClock(){
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(200);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                update();
                                generation++;

                                cellCount = 0;
                                for(int i = 0; i < 6; i++){
                                    for(int j = 0; j < 6; j++)
                                    {
                                        if(cells[i][j].isAlive()){
                                            cellCount++;
                                        }
                                    }
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    public void update() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                System.out.println("Cell" + r + ", " + c);
                ArrayList<Cell> adjacentcells = new ArrayList<>();
                int[] offsetx = new int[]{-1, 0, 1};
                int[] offsety = new int[]{-1, 0, 1};

                for(int m = 0; m < 3; m++){
                    for(int n = 0; n < 3; n++){
                        if(m == 1 && n == 1){
                            continue;
                        }
                        if((r + offsetx[m] >= 0) && (r + offsetx[m] < 6) && (c + offsety[n] >= 0) && (c + offsety[n] < 6)){
                            adjacentcells.add(cells[r + offsetx[m]][c + offsety[n]]);
                        }
                    }
                }
                /*
                for (int i = 0; i <= 7; i++) {
                    if (r + pos[i][0] >= 0 && c + pos[i][1] >= 0) {
                        adjacentcells.add(cells[r + pos[i][0]][c + pos[i][1]]);
                    }
                }
                */

                int alivecount = 0;
                for (int j = 0; j < adjacentcells.size(); j++) {
                    if (adjacentcells.get(j).isAlive()) {
                        alivecount++;
                    }
                }

                if (cells[r][c].isAlive() && (alivecount < 2 || alivecount > 3)) {
                    newcells[r][c].kill();
                    System.out.print(" killed by too few/too many neighbors");
                }

                if (cells[r][c].isAlive() && (alivecount == 2 || alivecount == 3)){
                    newcells[r][c].ressurrect();
                    System.out.print(" ressurrected by 2-3 neighbors");
                }


                if (!cells[r][c].isAlive()) {
                    if (alivecount == 3) {
                        newcells[r][c].ressurrect();
                        System.out.print(" ressurrected by 3 neighbors");
                    }
                }


            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                cells[i][j] = newcells[i][j];
            }
        }

        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                if(newcells[i][j].isAlive()) {
                    views[6 * j + i].setVisibility(View.VISIBLE);
                    System.out.println("visible-painting views with newcell");
                }
                else
                    views[6*j+i].setVisibility(View.INVISIBLE);
                System.out.println("invisible-painting views with newcell");
                newcells[i][j] = new Cell(i, j);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toad);

        views[0] = findViewById(R.id.cell_0);
        views[1] = findViewById(R.id.cell_1);
        views[2] = findViewById(R.id.cell_2);
        views[3] = findViewById(R.id.cell_3);
        views[4] = findViewById(R.id.cell_4);
        views[5] = findViewById(R.id.cell_5);
        views[6] = findViewById(R.id.cell_6);
        views[7] = findViewById(R.id.cell_7);
        views[8] = findViewById(R.id.cell_8);
        views[9] = findViewById(R.id.cell_9);
        views[10] = findViewById(R.id.cell_10);
        views[11] = findViewById(R.id.cell_11);
        views[12] = findViewById(R.id.cell_12);
        views[13] = findViewById(R.id.cell_13);
        views[14] = findViewById(R.id.cell_14);
        views[15] = findViewById(R.id.cell_15);
        views[16] = findViewById(R.id.cell_16);
        views[17] = findViewById(R.id.cell_17);
        views[18] = findViewById(R.id.cell_18);
        views[19] = findViewById(R.id.cell_19);
        views[20] = findViewById(R.id.cell_20);
        views[21] = findViewById(R.id.cell_21);
        views[22] = findViewById(R.id.cell_22);
        views[23] = findViewById(R.id.cell_23);
        views[24] = findViewById(R.id.cell_24);
        views[25] = findViewById(R.id.cell_25);
        views[26] = findViewById(R.id.cell_26);
        views[27] = findViewById(R.id.cell_27);
        views[28] = findViewById(R.id.cell_28);
        views[29] = findViewById(R.id.cell_29);
        views[30] = findViewById(R.id.cell_30);
        views[31] = findViewById(R.id.cell_31);
        views[32] = findViewById(R.id.cell_32);
        views[33] = findViewById(R.id.cell_33);
        views[34] = findViewById(R.id.cell_34);
        views[35] = findViewById(R.id.cell_35);

        for(int k = 0; k < 36; k++)
        {
            views[k].setVisibility(View.INVISIBLE);
            System.out.println("Initialize invisible views");
        }

        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                cells[i][j] = new Cell(i,j);
                newcells[i][j] = new Cell(i, j);
            }
        }

        cells[2][2].ressurrect();
        cells[2][3].ressurrect();
        cells[2][4].ressurrect();
        cells[3][1].ressurrect();
        cells[3][2].ressurrect();
        cells[3][3].ressurrect();
        views[6*2+2].setVisibility(View.VISIBLE);
        views[6*3+2].setVisibility(View.VISIBLE);
        views[6*4+2].setVisibility(View.VISIBLE);
        views[6*1+3].setVisibility(View.VISIBLE);
        views[6*2+3].setVisibility(View.VISIBLE);
        views[6*3+3].setVisibility(View.VISIBLE);
        System.out.println("initialize visible toad");

        startClock();
    }
}
