package io.github.artificial_intellicrafters.merlin_ai.api.region;

import io.github.artificial_intellicrafters.merlin_ai.api.util.ShapeCache;
import it.unimi.dsi.fastutil.shorts.ShortPredicate;
import it.unimi.dsi.fastutil.shorts.ShortSet;
import net.minecraft.util.math.ChunkSectionPos;

import java.util.function.Consumer;

public interface ChunkSectionRegionClassifier {
	void classify(ShapeCache cache, ChunkSectionPos pos, Consumer<ShortSet> regionAdder, ShortPredicate occupied);

	static boolean isLocal(final int x, final int y, final int z) {
		return x >= 0 && x < 16 && y >= 0 && y < 16 && z >= 0 && z < 16;
	}

	static short packLocal(final int x, final int y, final int z) {
		if (!isLocal(x, y, z)) {
			throw new RuntimeException("Local coordinates must be between 0 and 15 inclusive");
		}
		return (short) ((x << 8) | (y << 4) | z);
	}

	static int unpackLocalX(final short packed) {
		return (packed >> 8) & 0xF;
	}

	static int unpackLocalY(final short packed) {
		return (packed >> 4) & 0xF;
	}

	static int unpackLocalZ(final short packed) {
		return packed & 0xF;
	}
}