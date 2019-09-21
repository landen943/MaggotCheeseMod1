package landospuk.maggotcheesemod;

import org.apache.logging.log4j.LogManager;

import landospuk.maggotcheesemod.config.Config;
import landospuk.maggotcheesemod.world.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("maggotcheesemod")
public class maggotcheesemod
{
	public static maggotcheesemod instance;
	public static final String modid = "maggotcheesemod";
	public static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(modid);
	public static final MaggotCheeseItemGroup MaggotCheeseItemGroup = new MaggotCheeseItemGroup();
	public static final org.apache.logging.log4j.Logger LOGGER = null;
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
}
