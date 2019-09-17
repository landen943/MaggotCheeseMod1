package landospuk.maggotcheesemod.lists;

import net.minecraft.item.Food;

public class FoodList
{

	public static Food maggotcheeseFood = (new Food.Builder()).hunger((int) -1.5).saturation(0.6F).build();
	public static Food crispymaggotcheeseFood = (new Food.Builder()).hunger(4).saturation(0.7F).build();
	public static Food burntmaggotcheeseFood = (new Food.Builder()).hunger((int) -2.5).saturation(0.6F).build();
	
}