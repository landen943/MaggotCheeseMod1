package landospuk.maggotcheesemod.init;

import landospuk.maggotcheesemod.maggotcheesemod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class FoodList extends Item {

	public FoodList(String name, int hunger, float saturation, ItemGroup MaggotCheeseItemGroup)
	{
	    super(new Properties().group(MaggotCheeseItemGroup).food(new Food.Builder().saturation(saturation).hunger(hunger).build()));
	    this.setRegistryName(new ResourceLocation(maggotcheesemod.MOD_ID, name));
	}

	public static Food maggotcheeseFood = (new Food.Builder()).hunger((int) -1.5).saturation(0.6F).build();
	public static Food crispymaggotcheeseFood = (new Food.Builder()).hunger(4).saturation(0.7F).build();
	public static Food burntmaggotcheeseFood = (new Food.Builder()).hunger((int) -2.5).saturation(0.6F).build();
	
}