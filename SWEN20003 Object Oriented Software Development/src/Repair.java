import org.newdawn.slick.SlickException;

/** Present all the repair*/
public class Repair extends Item {
	/**Repair image*/
	private static final String REPAIR_PATH= Game.ASSETS_PATH + "/items/repair.png";

	/** Create a repair object.
	 * @param x The repair's x position;
	 * @param y The repair's y position;
	 * @throws SlickException
	 */
	public Repair(double x,double y)
		throws SlickException{
			super(x,y,REPAIR_PATH);
		}	
	/** Change player's stats.
	 * @param player Need to call method in the player class
	 */
	public void changestuff(Player player){
		player.changerepair();
	} 
	
}

