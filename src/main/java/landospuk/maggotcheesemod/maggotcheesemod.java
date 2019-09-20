package landospuk.maggotcheesemod;

import landospuk.maggotcheesemod.init.FoodList;

import org.apache.logging.log4j.LogManager;

import landospuk.maggotcheesemod.config.Config;
import landospuk.maggotcheesemod.init.BlockList;
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
import landospuk.maggotcheesemod.init.ItemList;

@Mod("maggotcheesemod")
public class maggotcheesemod
{
	public static maggotcheesemod instance;
	public static final String modid = "maggotcheesemod";
	public static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(modid);
	public static final MaggotCheeseItemGroup MaggotCheeseItemGroup = new MaggotCheeseItemGroup();
	public static final String LOGGER = null;
	public static final String MOD_ID = "maggotcheesemod";
	
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
					ItemList.maggot_cheese_ore = new BlockItem(BlockList.maggot_cheese_ore, new Item.Properties().group(MaggotCheeseItemGroup)).setRegistryName(BlockList.maggot_cheese_ore.getRegistryName()),
					ItemList.maggot_cheese_plant = new BlockItem(BlockList.maggot_cheese_plant, new Item.Properties().group(MaggotCheeseItemGroup)).setRegistryName(BlockList.maggot_cheese_plant.getRegistryName()),
					
					ItemList.maggot_cheese = new Item(new Item.Properties().food(FoodList.maggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("crispy_maggot_cheese")),
					ItemList.crispy_maggot_cheese =  new Item(new Item.Properties().food(FoodList.crispymaggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("crispy_maggot_cheese")),
					ItemList.burnt_maggot_cheese =  new Item(new Item.Properties().food(FoodList.burntmaggotcheeseFood).group(MaggotCheeseItemGroup)).setRegistryName(location("burnt_maggot_cheese")),
					ItemList.ashes =  new Item(new Item.Properties().group(MaggotCheeseItemGroup)).setRegistryName(location("ashes"))
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
