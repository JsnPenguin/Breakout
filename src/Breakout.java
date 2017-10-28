/*
 * Names: Justin Peng and Stephen Hamlin
 * Section Leader: Katherine Erdman
 * This program lets you play a game of breakout with a display of the score and the lives remaining until the user wins or loses
 */

import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator
import java.awt.*;         // Color
import java.awt.event.*;   

public class Breakout extends BreakoutProgram {
	private GRect paddle = new GRect ((CANVAS_WIDTH/2) - (PADDLE_WIDTH/2), CANVAS_HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
	private GOval ball;
	private double velocity = VELOCITY_Y;
	private double xVelocity = startingVelocity(); 
	private static final int LABEL_HEIGHT = 50;
	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");
		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		makeBall();
		createBricks();
		movingBall();
	}
	/*
	 * Creates rows based off of how many rows there are
	 * precondition: There are no bricks
	 * postcondition: There are bricks and a paddle
	 */
	private void createBricks(){
		for (int i = 0; i < NBRICK_ROWS; i++){
			createRow(i);
			add(paddle);
			paddle.setFilled(true);
		}
	}
	/*
	 * Creates a row and has color assignment for each one
	 * precondition: The ball, title text, and canvas dimensions were made
	 * postcondition: The configuration for a row is made
	 */
	private void createRow(int row){
		double offsetY = BRICK_Y_OFFSET + row*(BRICK_SEP + BRICK_HEIGHT);
		double offsetX = 0;
		int colorGroup = (row + 1) % 10;
		for (int i=0; i < NBRICK_COLUMNS; i++){ //Uses a for loop for the amount of columns and fills each row with colors
			offsetX = BRICK_SEP + i*(BRICK_SEP + BRICK_WIDTH); 
			GRect brick = new GRect (offsetX, offsetY, BRICK_WIDTH, BRICK_HEIGHT);
			brick.setFilled(true);
			if(colorGroup == 1 || colorGroup == 2){
				brick.setColor(Color.RED);
			}else if(colorGroup == 3 || colorGroup == 4){
				brick.setColor(Color.ORANGE);
			}else if(colorGroup == 5 || colorGroup == 6){
				brick.setColor(Color.YELLOW);
			}else if(colorGroup == 7 || colorGroup == 8){
				brick.setColor(Color.GREEN);
			}else{
				brick.setColor(Color.CYAN);
			}
			add(brick);
		}
	}
	/*
	 * Creates the ball and puts it in the middle of the screen
	 * precondition: The title text and canvas dimensions were created
	 * postcondition: There is a ball in the middle of the screen
	 */
	private void makeBall() {
		double ballX = getWidth()/2 - BALL_RADIUS;
		double ballY = getHeight()/2 - BALL_RADIUS; 
		ball = new GOval (ballX, ballY, 2*BALL_RADIUS, 2*BALL_RADIUS);
		add(ball);
		ball.setFilled(true);
	}
	/*
	 * Assigns a random x-velocity between -3.0 and 3.0 with a random number generator at the
	 * beginning of the game and after each turn lost until the game is lost or won
	 * precondition: The game or new turn has started
	 * postcondition: The ball is at the center of the screen with a random x-velocity and direction
	 */
	private double startingVelocity() {
		double initialVelocity = RandomGenerator.getInstance().nextDouble(100, 300);
		boolean nextVelocity = RandomGenerator.getInstance().nextBoolean();
			if(nextVelocity) {
				initialVelocity = -1*initialVelocity;
			}
		return initialVelocity;	
	}
	/*
	 * Creates a new scoreboard every time a brick is broken or a turn is lost. Reverses the x-vecloty when the left or right wall is hit by the wall and the y-velocity is
	 * reversed when the top wall is hit. The ball destroys a brick everytime it hits a brick. Keeps track of the score and amount of turns left until the score is 0 or the 
	 * amount of turns is 0. When the score is 100, the winning screen is shown. When the turn amount is 0, the losing screen is shown.
	 * precondition: The game has just started after the interface is setup
	 * postcondition: The game is over
	 */
	private void movingBall() { 
		int score = 0;
		int turns = NTURNS;
		GLabel scoreboard;
		while(score < (NBRICK_ROWS*NBRICK_COLUMNS) && turns > 0) {
			scoreboard = new GLabel("Score: " + score +", Turns " + turns, 0, LABEL_HEIGHT );
			scoreboard.setFont(SCREEN_FONT);
			add(scoreboard);
			ball.move(xVelocity, velocity);
			pause(DELAY);
			if(ball.getY() <= 0 ){
				velocity = velocity*-1;
			}else if(ball.getX() <= 0 || ball.getX() + 2*BALL_RADIUS >= getWidth()){
				xVelocity = xVelocity*-1;
			}
			GObject maybeABrick = notHitBricks();
			if(maybeABrick == paddle){
				velocity = velocity*-1;
				xVelocity = (ball.getCenterX() - paddle.getCenterX())/10;
			}else if (maybeABrick != null && maybeABrick != scoreboard){
				velocity = -1*velocity;
				remove (maybeABrick);
				score++;
			}else if(ball.getY() + 2*BALL_RADIUS >= getHeight()) {
				turns--;
				resetGame();
			}
			remove (scoreboard);
		}
		scoreboard = new GLabel("Score: " + score +", Turns " + turns, 0, LABEL_HEIGHT );
		scoreboard.setFont(SCREEN_FONT);
		add(scoreboard);
		if(turns == 0) {
			losingScreen();
		}else{
			winningScreen();
		}
	}
	/*
	 * Resets the game when the ball hits the ground
	 * precondition: The ball has hit the ground
	 * postcondition: The ball is back at the center of the screen with a random x-velocity
	 */
	private void resetGame(){
		remove (ball);
		makeBall();
		xVelocity = startingVelocity();
	}
	/*
	 * The screen shown when the user has lost
	 * precondition: The turns have gone to 0
	 * postcondition: The losing text is shown
	 */
	private void losingScreen() {
		remove(ball);
		remove(paddle);
		GLabel loser = new GLabel("GAME OVER", getWidth()/2, getHeight()/2);
		loser.setFont(SCREEN_FONT);
		loser.setLocation(getWidth()/2 - loser.getWidth()/2 ,getHeight()/2 - loser.getHeight()/2);
		add(loser);
	}
	/*
	 * The screen shown when the user has won
	 * precondition: The score is 100
	 * postcondition: The winning text is shown
	 */
	private void winningScreen() {
		remove(ball);
		remove(paddle);
		GLabel winner = new GLabel("YOU WIN", getWidth()/2 , getHeight()/2);
		winner.setFont(SCREEN_FONT);
		winner.setLocation(getWidth()/2 - winner.getWidth()/2 ,getHeight()/2 - winner.getHeight()/2);
		add(winner);
	}
	/*
	 * Checks the object that the ball is touching when it is touching another object besides GLabels
	 * precondition: The ball has touched a brick or the paddle
	 * postcondition: The object touched is identified and given to the movingBall method
	 */
	private GObject notHitBricks(){
		double leftX = ball.getX();
		double topY = ball.getY();
		double rightX = ball.getX() + 2*BALL_RADIUS;
		double bottomY = ball.getY() + 2*BALL_RADIUS;
		if (getElementAt(leftX,topY) != null){
			return getElementAt(leftX,topY);
		}else if (getElementAt(leftX,bottomY) != null || getElementAt(leftX,bottomY) == paddle){
			return getElementAt(leftX,bottomY);
		}else if (getElementAt(rightX,topY) != null || getElementAt(leftX,bottomY) == paddle){
			return getElementAt(rightX,topY);
		}else if (getElementAt(rightX,bottomY) != null || getElementAt(leftX,bottomY) == paddle){
			return getElementAt(rightX,bottomY);
		}else{
			return null;
		}
	}
	/*
	 * Has the paddle follow the x location of the mouse with the middle of the paddle at a set y coordinate
	 * precondition: The mouse is somewhere on the screen
	 * postcondition: The middle of the paddle follows the x-coordinate of the mouse
	 */
	public void mouseMoved(MouseEvent event){
		double newX = event.getX() - paddle.getWidth()/2;
		
		if(event.getX() - paddle.getWidth()/2 > 0 && event.getX() + paddle.getWidth()/2 < getWidth()){
			paddle.setLocation(newX, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}else if(event.getX() - paddle.getWidth()/2 < 0){
			paddle.setLocation(0, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}else{
			paddle.setLocation(getWidth() - PADDLE_WIDTH, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}
	}
	/*
	 * Does the same thing as mouseMoved except is applicable when the mouse is being dragged
	 * precondition: The mouse has been clicked somewhere on the screen
	 * postcondition: The middle of the paddle follows the x-coordinate of the mouse
	 */
	public void mouseDragged(MouseEvent event){
		double newX = event.getX() - paddle.getWidth()/2;
		
		if(event.getX() - paddle.getWidth()/2 > 0 && event.getX() + paddle.getWidth()/2 < getWidth()){
			paddle.setLocation(newX, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}else if(event.getX() - paddle.getWidth()/2 < 0){
			paddle.setLocation(0, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}else{
			paddle.setLocation(getWidth() - PADDLE_WIDTH, CANVAS_HEIGHT - paddle.getHeight() - PADDLE_Y_OFFSET);
		}
	}
}
