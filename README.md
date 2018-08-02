# Conway's Game of Life
An Android implementation of John Conway's 1970 cellular automaton. Part of <a href="https://seal.ece.ucsb.edu/">UCSB SEAL</a>'s high school outreach program.

## Contributors
Program Manager, Teacher: Brandon Tran
Student: 
Student: Andrew Xie

## Rules
In the <a href="https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Game of Life</a>, every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, or generation, the following transitions occur.
1. Any live cell with fewer than two live neighbors dies, as if by under population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

# Our App
We have two Activities: MainActivity and Game.

<img src="https://github.com/brandontran24/GameOfLife/blob/master/Menu.png" width="203">   <img src="https://github.com/brandontran24/GameOfLife/blob/master/GameActivity.png" width="200">

Pressing play from the MainActivity will take the user to the Game activity, which can be played in a sandbox manner, or the user can upload Toad and Beacon presets. The user can also see the generation number on the bottom right.

## Cells
We wrote the cell class to contain its status (alive or dead), and included member functions to "kill" or "resurrect" the cell to change its state. An array of these cells are mapped onto an array of ImageViews. The cells the user sees are all ImageViews, each displaying a black box (live cell). When the corresponding cell object is killed, the connected ImageView's alpha (transparency) is set to 1.0 (completely transparent). This way, we did not have to worry about changing the images of the ImageViews, only their transparency.

## Toad
The "toad" is an example of an oscillating pattern, meaning that the initial condition will cycle through a set of cell configurations if left undisturbed. Below are the two states of the toad.

<img src="https://github.com/brandontran24/GameOfLife/blob/master/Frog1.png" width="200">   <img src="https://github.com/brandontran24/GameOfLife/blob/master/Frog2.png" width="200">

## Beacon
The "beacon" is another oscillating pattern. Below are its two states.

<img src="https://github.com/brandontran24/GameOfLife/blob/master/Beacon1.png" width="200">   <img src="https://github.com/brandontran24/GameOfLife/blob/master/Beacon2.png" width="200">

# Challenges
The biggest challenge I and the students encountered was a seemingly impassable bug where dead cells were not responding to being toggled back to life, while live cells were able to be toggled dead. After an hour I realized we had been using a function setVisibility, which we had mistaken for the behavior of setAlpha. SetVisibility essentially erases an ImageView from the scope of the rest of the program, so each time a cell was killed, its ImageView was essentially erased from the game. This taught us always to check the API we are utilizing.
