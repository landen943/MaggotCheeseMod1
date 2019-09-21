package landospuk.maggotcheesemod.blocks;

import landospuk.maggotcheesemod.maggotcheesemod;
import landospuk.maggotcheesemod.init.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class CustomCropBlock extends CropsBlock
{
	public CustomCropBlock(String name) {
		super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP));
		this.setRegistryName(new ResourceLocation(maggotcheesemod.MOD_ID, name));
	}

	@OnlyIn(Dist.CLIENT)
	protected IItemProvider getSeedsItem() 
	{
		return ItemList.maggot_seeds;
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
    	return state.getBlock() instanceof FarmlandBlock;
   	}
	@Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
    	if(!world.isRemote)
		{
			if(this.isMaxAge(state))
			{
				world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.maggot_cheese, 1)));
				world.setBlockState(pos, this.withAge(0));
				return true;
			}
		}		
		return false;
    }

}
