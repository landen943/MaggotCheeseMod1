package landospuk.maggotcheesemod.entities;

import landospuk.maggotcheesemod.init.MaggotEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class MaggotEntity extends CreatureEntity{

	@SuppressWarnings("unchecked")
	public MaggotEntity(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		super((EntityType<? extends AnimalEntity>) MaggotEntities.MAGGOT_ENTITY, worldIn);
	}

	@Override
	protected void registerGoals() 
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.4d));
		this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
//		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new FleeSunGoal(this, 0.6d));
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.4d, true));
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, interpTargetHeadYaw));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4d);
	}

//	@Override
//	public AgeableEntity createChild(AgeableEntity arg0) {
//		return super.createChild(arg0)
//	}
}
