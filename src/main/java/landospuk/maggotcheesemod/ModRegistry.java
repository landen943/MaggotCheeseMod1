package landospuk.maggotcheesemod;

import org.apache.logging.log4j.Logger;

import landospuk.maggotcheesemod.blocks.CustomCropBlock;
import landospuk.maggotcheesemod.init.BlockList;
import landospuk.maggotcheesemod.init.FoodList;
import landospuk.maggotcheesemod.init.ItemList;
import landospuk.maggotcheesemod.init.ItemSeedsMCM;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = maggotcheesemod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModRegistry 
{
	public static final ItemGroup MaggotCheeseItemGroup = maggotcheesemod.MaggotCheeseItemGroup;
	public static final Logger LOGGER = maggotcheesemod.LOGGER;
	public static final String MODID = maggotcheesemod.modid;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			ItemList.ashes =  new Item(new Item.Properties().group(MaggotCheeseItemGroup)).setRegistryName(location("ashes")),
			ItemList.burnt_maggot_cheese =  new Item(new Item.Properties().food(FoodList.burntmaggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("burnt_maggot_cheese")),
			ItemList.crispy_maggot_cheese =  new Item(new Item.Properties().food(FoodList.crispymaggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("crispy_maggot_cheese")),
			ItemList.maggot_cheese = new Item(new Item.Properties().food(FoodList.maggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("maggot_cheese")),
			ItemList.maggot_cheese_ore = new BlockItem(BlockList.maggot_cheese_ore, new Item.Properties().group(MaggotCheeseItemGroup)).setRegistryName(BlockList.maggot_cheese_ore.getRegistryName()),
			ItemList.maggot_seeds =  new ItemSeedsMCM("maggot_seeds",  BlockList.maggot_cheese_plant)
		);
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
			BlockList.maggot_cheese_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.STONE)).setRegistryName(location("maggot_cheese_ore")),
			BlockList.maggot_cheese_plant = new CustomCropBlock("maggot_cheese_plant")
		);
}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MODID, name);
	}
}	
