/*
 * Name: Stephen Hamlin
 * Section Leader: Katherine Erdman
 * Displays a picture of 8-bit Link and other features
 */
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class Artistry extends GraphicsProgram {
	private static final double SQUARE_SIZE = 25;
	private static final Color BROWN = new Color (153, 51, 0);
	private static final Color BEIGE = new Color (255, 204, 102);
	public void run() {
		backdrop();
		row1();
		row2();
		row3();
		row4();
		row5();
		row6();
		row7();
		row8();
		row9();
		row10();
		row11();
		row12();
		row13();
		row14();
		row15();
		row16();
		koolDude();
		myName();
	}
	private void backdrop(){
		GOval backdrop = new GOval(SQUARE_SIZE, 0, SQUARE_SIZE*15, SQUARE_SIZE*16);
		backdrop.setFilled(true);
		add(backdrop);
	}
	private void row1(){
		for (int i = 6; i < 12; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, 0, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			pixel.setFillColor(Color.GREEN);
			add (pixel);
		}
	}
	private void row2(){
		for (int i = 5; i < 13; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			pixel.setFillColor(Color.GREEN);
			add (pixel);
		}
	}
	private void row3(){
		for (int i=3; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*2, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==3 || i==14){
				pixel.setFillColor(BEIGE);
			}else if(i==4 || i==13){
				remove(pixel);
			}else if(i==5 || i==12){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row4(){
		for (int i=3; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*3, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==3 || i==14){
				pixel.setFillColor(BEIGE);
			}else if(i==4 || i==13){
				remove(pixel);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}	
	}
	private void row5(){
		for (int i=3; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*4, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>=3 && i<=4 || i>=13 && i<=14 || i==6 || i==11 || i>=8 && i<=9){
				pixel.setFillColor(BEIGE);
			}else if(i==7 || i==10){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row6(){
		for (int i=3; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*5, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>=3 && i<=4 || i>=13 && i<=14 || i==6 || i==11 || i>=8 && i<=9){
				pixel.setFillColor(BEIGE);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row7(){
		for (int i=4; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*6, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>3 && i<14){
				pixel.setFillColor(BEIGE);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row8(){
		for (int i=4; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*7, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>5 && i<8 || i>9 && i<12){
				pixel.setFillColor(BEIGE);
			}else if(i>=4 && i<6 || i>11 && i<14){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row9(){
		for (int i=2; i < 16; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*8, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>6 && i<11){
				pixel.setFillColor(BEIGE);
			}else if(i>10 && i<13){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row10(){
		for (int i=1; i < 16; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*9, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==3 || i==13){
				pixel.setFillColor(BEIGE);
			}else if(i>7 && i<13){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row11(){
		for (int i=1; i < 16; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*10, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i>1 && i<5 || i==7 || i>11 && i<15){
				pixel.setFillColor(BEIGE);
			}else if(i>9 && i<12){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row12(){
		for (int i=1; i < 16; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*11, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==3 || i==7 || i>12 && i<=15){
				pixel.setFillColor(BEIGE);
			}else if(i==8){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row13(){
		for (int i=1; i < 15; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*12, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==3 || i==7 || i==14){
				pixel.setFillColor(BEIGE);
			}else if(i>9 && i<14){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row14(){
		for (int i=1; i < 13; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*13, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i==7){
				pixel.setFillColor(BEIGE);
			}else if(i>7){
				pixel.setFillColor(Color.GREEN);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}
	}
	private void row15(){
		for (int i=2; i < 13; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*14, SQUARE_SIZE,SQUARE_SIZE);
			pixel.setFilled(true);
			if(i<7){
				pixel.setFillColor(BEIGE);
			}else if(i==8 || i==9){
				remove(pixel);
			}else{
				pixel.setFillColor(BROWN);
			}
			add (pixel);
		}	
	}
	private void row16(){
		for (int i=5; i<8; i++){
			GRect pixel = new GRect (SQUARE_SIZE*i, SQUARE_SIZE*15, SQUARE_SIZE, SQUARE_SIZE);
			pixel.setFilled(true);
			pixel.setFillColor(BROWN);
			add(pixel);
		}
	}
	private void koolDude(){
		GLabel koolDude = new GLabel ("KOOL DUDE", 0, getHeight());
		koolDude.move(150, -koolDude.getHeight());
		add(koolDude);
	}
	private void myName(){
		GLabel name = new GLabel ("Artistry by Stevie Hamlin", getWidth(), getHeight());
		name.move(-name.getWidth(), -name.getHeight());
		add(name);
	}
}
