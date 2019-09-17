package landospuk.maggotcheesemod;

import landospuk.maggotcheesemod.lists.FoodList;

import org.apache.logging.log4j.LogManager;

import landospuk.maggotcheesemod.config.Config;
import landospuk.maggotcheesemod.lists.BlockList;
import landospuk.maggotcheesemod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import landospuk.maggotcheesemod.lists.ItemList;

@Mod("maggotcheesemod")
public class maggotcheesemod
{
	public static maggotcheesemod instance;
	public static final String modid = "maggotcheesemod";
	public static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(modid);
	public static final MaggotCheeseItemGroup breffItemGroup = new MaggotCheeseItemGroup();
	public static final String LOGGER = null;
	
	private void setup1(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		Logger.info("Setup method registered.");
	}
	
public maggotcheesemod()
	{
		instance = this;
	
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup1);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("breffmod-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("breffmod-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		Logger.info("Setup method registered");
	}
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		Logger.info("clientRegistries method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems1(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.maggot_cheese_ore = new BlockItem(BlockList.maggot_cheese_ore, new Item.Properties().group(breffItemGroup)).setRegistryName(BlockList.maggot_cheese_ore.getRegistryName()),
					
					ItemList.maggot_cheese =  new Item(new Item.Properties().food(FoodList.maggotcheeseFood).group(breffItemGroup)).setRegistryName(location("maggot_cheese")),
					ItemList.crispy_maggot_cheese =  new Item(new Item.Properties().food(FoodList.crispymaggotcheeseFood).group(breffItemGroup)).setRegistryName(location("crispy_maggot_cheese")),
					ItemList.burnt_maggot_cheese =  new Item(new Item.Properties().food(FoodList.burntmaggotcheeseFood).group(breffItemGroup)).setRegistryName(location("burnt_maggot_cheese")),
					ItemList.ashes =  new Item(new Item.Properties().group(breffItemGroup)).setRegistryName(location("ashes"))
			);
			Logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.maggot_cheese_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.STONE)).setRegistryName(location("maggot_cheese_ore"))
			);
		}
	
	}
}
