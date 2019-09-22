package landospuk.maggotcheesemod.client.renders;

import landospuk.maggotcheesemod.ModRegistry;
import landospuk.maggotcheesemod.client.models.MaggotEntityModel;
import landospuk.maggotcheesemod.entities.MaggotEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MaggotEntityRender extends LivingRenderer<MaggotEntity, MaggotEntityModel>
{
	public MaggotEntityRender(EntityRendererManager manager) 
	{
		super(manager, new MaggotEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(MaggotEntity entity) 
	{
		return ModRegistry.location("textures/entity/maggot_entity.png");
	}

	public static class RenderFactory implements IRenderFactory<MaggotEntity>
	{
		@Override
		public EntityRenderer<? super MaggotEntity> createRenderFor(EntityRendererManager manager) 
		{
			return new MaggotEntityRender(manager);
		}
		
	}
}