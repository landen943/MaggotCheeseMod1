package landospuk.maggotcheesemod.blocks;

import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCropBlock extends CropsBlock 
{

	protected CustomCropBlock(Properties builder) {
		super(builder);
		
	}
	
    @OnlyIn(Dist.CLIENT)
protected IItemProvider getSeedsItem() 
{
  return ItemsList.maggot_cheese;
}

}
