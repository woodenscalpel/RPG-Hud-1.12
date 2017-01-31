package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementTexture;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementJumpBarTexture extends HudElementTexture{

	public HudElementJumpBarTexture() {
		super(HudElementType.JUMP_BAR, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.player.getRidingEntity() instanceof EntityLivingBase;
	}
	
	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		bind(INTERFACE);
		ScaledResolution res = new ScaledResolution(mc);
		int height = res.getScaledHeight();
		int adjustedWidth = res.getScaledWidth() / 2;
		float var14 = this.mc.player.getHorseJumpPower();
		int color = (int) (var14 * 100.0F);
		gui.drawTexturedModalRect(adjustedWidth - 71, height - 80, 0, 160, 141, 10);
		gui.drawTexturedModalRect(adjustedWidth - 71, height - 80, 0, 150, (int) (141.0D * (color / 100.0D)), 10);

		this.bind(Gui.ICONS);
	}

}