package landospuk.maggotcheesemod.init;

import landospuk.maggotcheesemod.ModRegistry;
import landospuk.maggotcheesemod.entities.MaggotEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class MaggotEntities 
{
	public static EntityType<?> MAGGOT_ENTITY = EntityType.Builder.create(MaggotEntity::new, EntityClassification.CREATURE).build(ModRegistry.MODID + ":maggot_entity").setRegistryName(ModRegistry.location("maggot_entity"));
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			ItemList.maggot_entity_egg = registerEntitySpawnEgg(MAGGOT_ENTITY, 0xd6d6b8, 0xbdbd39, "maggot_entity_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(MAGGOT_ENTITY, Biomes.PLAINS, Biomes.BEACH, Biomes.SWAMP, Biomes.SWAMP_HILLS, Biomes.NETHER, Biomes.JUNGLE);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ModRegistry.MaggotCheeseItemGroup));
		item.setRegistryName(ModRegistry.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
