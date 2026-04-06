/**
 * Copyright (c) 2019 Gregorius Techneticies
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.render;

import static gregapi.data.CS.*;

// PHASE4: import IIconRegister removed — use TextureAtlasSprite
import net.minecraft.client.renderer.texture.TextureMap;
// PHASE4: import IIcon removed — use TextureAtlasSprite
import net.minecraft.resources.ResourceLocation;

public class IconContainerDefault implements IIconContainer {
	public final ResourceLocation mTextureFile;
	public final IIcon mIcon;
	public final short[] mRGBa;
	
	public IconContainerDefault(IIcon aIcon, short[] aRGBa, ResourceLocation aTextureFile) {
		mIcon = aIcon; mRGBa = aRGBa; mTextureFile = aTextureFile;
	}
	
	public IconContainerDefault(IIcon aIcon, short[] aRGBa, boolean aIsBlockTexture) {
		mIcon = aIcon; mRGBa = aRGBa; mTextureFile = (aIsBlockTexture ? TextureMap.locationBlocksTexture : TextureMap.locationItemsTexture);
	}
	
	public IconContainerDefault(IIcon aIcon, short[] aRGBa) {
		mIcon = aIcon; mRGBa = aRGBa; mTextureFile = TextureMap.locationBlocksTexture;
	}
	
	public IconContainerDefault(IIcon aIcon, ResourceLocation aTextureFile) {
		mIcon = aIcon; mRGBa = UNCOLOURED; mTextureFile = aTextureFile;
	}
	
	public IconContainerDefault(IIcon aIcon, boolean aIsBlockTexture) {
		mIcon = aIcon; mRGBa = UNCOLOURED; mTextureFile = (aIsBlockTexture ? TextureMap.locationBlocksTexture : TextureMap.locationItemsTexture);
	}
	
	public IconContainerDefault(IIcon aIcon) {
		mIcon = aIcon; mRGBa = UNCOLOURED; mTextureFile = TextureMap.locationBlocksTexture;
	}
	
	@Override
	public IIcon getIcon(int aRenderPass) {
		return mIcon;
	}
	
	@Override
	public boolean isUsingColorModulation(int aRenderPass) {
		return mRGBa == UNCOLOURED;
	}
	
	@Override
	public short[] getIconColor(int aRenderPass) {
		return mRGBa;
	}
	
	@Override
	public int getIconPasses() {
		return 1;
	}
	
	@Override
	public ResourceLocation getTextureFile() {
		return mTextureFile;
	}
	
	@Override
	public void registerIcons(IIconRegister aIconRegister) {
		//
	}
}
