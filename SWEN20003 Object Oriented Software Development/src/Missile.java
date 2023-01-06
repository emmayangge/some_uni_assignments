import org.newdawn.slick.SlickException;

/**Present all the player's missile */
public class Missile extends GameObject{
	/** Missile's image.*/
	private static final String missileimg= Game.ASSETS_PATH + "/units/missile-player.png";	
		/** Create a player missile object.
		 *@param x The missile's x position.
		 *@param y The missile's y position.
		 **/
		public Missile(double x,double y)
			throws SlickException｛
				super(x,y,missileimg);
			}
		
		/** Update Missile's position. 
		* @param delta Time passed since last frame (milliseconds).
		* @param world The world the missile is on (to check blocking).
        * @param cam The current camera (to check blocking).
        * */
		public void update(int delta, World world, Camera cam){
			double change = delta * getSpeed();
	        moveto(world, x, y-change);
		}
		
		 /** Get missile's speed.*/
		 private double getSpeed(){
		        return 0.7;
		    }
		 
		/** Check the collision.
		 * */
	    private void moveto(World world, double x, double y){
	        if (!world.terrainBlocks(x-halfWidth(), y+halfHeight()) && !world.terrainBlocks(x+halfWidth(), y-halfHeight()) && !world.terrainBlocks(x-halfWidth(), y-halfHeight()) && !world.terrainBlocks(x+halfWidth(), y+halfHeight())){
	            this.setX(x);
	            this.setY(y);
	        }

	       else if (!world.terrainBlocks(this.getX()-halfWidth(), y-halfHeight()) && !world.terrainBlocks(this.getX()+halfWidth(), y+halfHeight()) && !world.terrainBlocks(this.getX()+halfWidth(), y-halfHeight()) && !world.terrainBlocks(this.getX()-halfWidth(), y+halfHeight())){
	            this.setY(y);
	        }

	        else if (!world.terrainBlocks(x+halfWidth(), this.getY()-halfHeight()) && !world.terrainBlocks(x-halfWidth(), this.getY()-halfHeight()) && !world.terrainBlocks(x+halfWidth(), this.getY()+halfHeight()) && !world.terrainBlocks(x-halfWidth(), this.getY()+halfHeight())){
	            this.setX(x);
	        }
	    }

}
