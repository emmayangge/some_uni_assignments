import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.newdawn.slick.SlickException;

/** To get the enemies' positions from a text file.*/
public class Read_file {
	/** File name*/
	private File filename;
	/** Build ArrayList to store the enemies's initial positions.*/
	ArrayList<Integer> Asteroidx = new ArrayList<Integer>();
	ArrayList<Integer> Asteroidy = new ArrayList<Integer>();
	ArrayList<Integer> Fighterx = new ArrayList<Integer>();
	ArrayList<Integer> Fightery = new ArrayList<Integer>();
	ArrayList<Integer> Dronex = new ArrayList<Integer>();
	ArrayList<Integer> Droney = new ArrayList<Integer>();
	
	/** Since there's only one boss, just set the boss's x position to 1301.*/
    private static final int BOSSX=1301;
    /** Set the boss's y position to 144*/
    private static final int BOSSY=144;
    
    /** Catch the enemy names in the text file.*/
	private String enemyname;
	
	/** Check if there's a new line*/
	private boolean right=true;
	
	/** read all the x position.*/
	private int readx;
	/** read all the y position.*/
	private int ready;
	/** File path*/
	private static final String FILEPATH = Game.ASSETS_PATH + "/data/units.txt";
	/** Set a scanner */
	private Scanner fileIn;
	
	/** Start to read file*/
	public Read_file()
		throws SlickException{
			filename= new File(FILEPATH);
		}

	/** Reading file and put the x, y position to the related arraylist.*/
	public void read_file(){		 
		try{
			FileInputStream stream = new FileInputStream(filename);
			fileIn = new Scanner(stream);
			// If there's a new line, read it.
			while(right){
				enemyname = fileIn.next();		     
				if(enemyname.equals("Asteroid")){
					readx=fileIn.nextInt();
					Asteroidx.add(readx);					
					ready=fileIn.nextInt();					
					Asteroidy.add(ready);																							
					fileIn.nextLine();										
				}		     
				if(enemyname.equals("Fighter")){
					readx=fileIn.nextInt();
					Fighterx.add(readx);					
					ready=fileIn.nextInt();					
					Fightery.add(ready);																							
					fileIn.nextLine();
				} 
				if(enemyname.equals("Drone")){
					readx=fileIn.nextInt();
					Dronex.add(readx);					
					ready=fileIn.nextInt();					
					Droney.add(ready);																							
					fileIn.nextLine();
				} 
				if(!fileIn.hasNextLine()){
						right=false;			
					}				
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);			
		}	
		fileIn.close();	
	}
	
	/** Get the boss's x position.*/
	public int get_bossx(){
		return BOSSX;
	}
	/** Get the boss's y position.*/
	public int get_bossy(){
		return BOSSY;
	}
	
}

