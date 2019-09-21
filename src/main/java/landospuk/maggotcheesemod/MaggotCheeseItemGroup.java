package landospuk.maggotcheesemod;

import landospuk.maggotcheesemod.init.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MaggotCheeseItemGroup extends ItemGroup
{	
	public MaggotCheeseItemGroup()
	{
		super("maggotcheesemod");
	}
	
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.maggot_cheese);
	}
}