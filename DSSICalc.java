/* This short bit of code is used for calculating how many
 * Double Chests or Shulker Boxes needed of an item that
 * also displays a remainder of stacks and items.
 */

import java.util.*;

public class DSSICalc
{
    public static void main (String[] args)
    {
    	//Gets User Input
    	Scanner myObj = new Scanner(System.in);
    	System.out.println("1. Enter an integer of the amount of items needed dividing by.");
		System.out.println("2. For a double chest calculation input '0' for a shulker box calculation input '1'");
		System.out.println("Ex. 6276, 1");
		System.out.println("Note: It probably will not work if you put anything other than 'Number, Number' so don't");
		String rawItems = myObj.nextLine();

		//The section that divides the input into two values, and int and a boolean.
		int rawLen = rawItems.length();
		int numLength = 0;
		String getItems = "";
		String getBoolean = "";
		int items = 0;
		boolean type = false;
		if(rawLen <= 2) //Used for too short responses that might break it
		{
			System.out.println("Your imput is most likley incorrect, please format it like this '6276, 1'");
		}
		else
		{
			for(int spot = 3; spot < rawLen + 1; spot++)
			{
				if(spot == rawLen)
				{
					numLength = spot - 3;
					getItems = rawItems.substring(0, numLength);
					items = Integer.parseInt(getItems);
					getBoolean = rawItems.substring(rawItems.length() -1 , rawItems.length());
					if(getBoolean.equals("1"))
						type = true;
					else
						type = false;
				}
				else
				{
					spot = spot;
				}
			}
		}

		//Basic calculations to get final result
		int mainStoreType = 0;
		int leftStacks = 0;
		int leftItems = 0;
		String singleChest = "";
		String storeType = "";
		if(type == true)
		{
			mainStoreType = (items / 1728);
			leftStacks = ((items % 1728) / 64);
			leftItems = (items % 64);
			storeType = " Shulker Box(es), ";
		}
		else
		{
			mainStoreType = (items / 3456);
			if((items % 3456) > 1728)
			{
				singleChest = "1 Single Chest, ";
				leftStacks = ((items % 1728) / 64);
				leftItems = (items % 64);
			}
			else
			{
				leftStacks = ((items % 3456) / 64);
				leftItems = (items % 64);
			}
			storeType = " Double Chest(s), ";
		}
		//Final print / result
		System.out.println(mainStoreType + storeType + singleChest + leftStacks + " Stack(s), " + leftItems + " Item(s).");
    }
}