package landospuk.maggotcheesemod.init;

import landospuk.maggotcheesemod.maggotcheesemod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemSeedsMCM extends BlockNamedItem {
	
	private static final ItemGroup MaggotCheeseItemGroup = maggotcheesemod.MaggotCheeseItemGroup;

	public ItemSeedsMCM(String name, Block crop)
	{
        super(crop, new Properties().maxStackSize(64).group(MaggotCheeseItemGroup));
        this.setRegistryName(new ResourceLocation(maggotcheesemod.MOD_ID, name));
    }
}
