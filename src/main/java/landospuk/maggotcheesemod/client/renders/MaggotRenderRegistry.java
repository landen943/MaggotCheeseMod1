package landospuk.maggotcheesemod.client.renders;

import landospuk.maggotcheesemod.entities.MaggotEntity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class MaggotRenderRegistry 
{
	public static void registryEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(MaggotEntity.class, new MaggotEntityRender.RenderFactory());
	}
}