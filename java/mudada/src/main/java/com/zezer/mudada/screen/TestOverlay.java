package com.zezer.mudada.screen;
/* imports omitted */

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;

@Mod.EventBusSubscriber
public class TestOverlay {

    public static void renderBar(RenderGameOverlayEvent.Post event, int posX, int posY, boolean hasMiddleStep, String name){
        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mudada:textures/bars/"+name+"0.png"));
        for(int  i=0;i<10;i++) {
            Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX+10*i, posY, 0, 0, 8, 8, 8, 8);
        }
        if (hasMiddleStep && (Minecraft.getInstance().player.getHealth()+1)%2!=0){
            Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mudada:textures/bars/"+name+"1.png"));
            Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), (int) (posX+10*(int)(Minecraft.getInstance().player.getHealth()/2.0)), posY, 0, 0, 8, 8, 8, 8);
        }
        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mudada:textures/bars/"+name+"2.png"));
        for(int i=0;i<(int)((Minecraft.getInstance().player.getHealth()+1)/2);i++){
            Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX+10*i, posY, 0, 0, 8, 8, 8, 8);

        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
            int w = event.getWindow().getScaledWidth();
            int h = event.getWindow().getScaledHeight();

            World _world = null;
            double _x = 0;
            double _y = 0;
            double _z = 0;

            PlayerEntity entity = Minecraft.getInstance().player;
            if (entity != null) {
                _world = entity.world;
                _x = entity.getPosX();
                _y = entity.getPosY();
                _z = entity.getPosZ();
            }

            World world = _world;
            double x = _x;
            double y = _y;
            double z = _z;

            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                    GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableAlphaTest();

            renderBar(event, w/2, h/20, false, "weight", entity.getCapability(KindaAnnoyingModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KindaAnnoyingModVariables.PlayerVariables()).weight);

            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableAlphaTest();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

}