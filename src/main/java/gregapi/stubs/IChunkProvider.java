package gregapi.stubs;

import net.minecraft.world.level.chunk.LevelChunk;

// PHASE5: IChunkProvider removed. ChunkSource is the modern equivalent.
// Stub for compilation during Phase 2; real implementation deferred to Phase 5.
@SuppressWarnings("unused")
public interface IChunkProvider {
	LevelChunk provideChunk(int x, int z);
	boolean chunkExists(int x, int z);
}
