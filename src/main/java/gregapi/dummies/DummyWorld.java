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

package gregapi.dummies;

// PHASE5: DummyWorld completely stubbed — Level constructor/API changed too much.
// Real DummyWorld (mock Level for recipe simulation) will be rewritten in Phase 5.
// In 1.21.4 the recipe simulation should use RecipeManager and avoid needing a Level entirely.

import java.util.Random;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class DummyWorld {

	public class GT_IteratorRandom extends Random {
		private static final long serialVersionUID = 1L;
		public int mIterationStep = Integer.MAX_VALUE;
		@Override public int nextInt(int aParameter) {
			if (mIterationStep == 0 || mIterationStep > aParameter) mIterationStep = aParameter;
			return --mIterationStep;
		}
	}

	public GT_IteratorRandom mRandom = new GT_IteratorRandom();
	public ItemStack mLastSetBlock = null;

	/** PHASE5: Returns null - DummyWorld is not a real Level until Phase 5. */
	public Level asLevel() { return null; }

	/** PHASE5: Stub - block placement simulation deferred to Phase 5. */
	public boolean setBlock(int aX, int aY, int aZ, Block aBlock, int aMeta, int aFlags) {
		return false;
	}
}
