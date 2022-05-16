package io.github.artificial_intellicrafters.merlin_ai.api.region;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.NonExtendable
public interface ChunkSectionRegion {
	int id();

	boolean contains(int x, int y, int z);

	void forEach(ForEach action);

	interface ForEach {
		void accept(int x, int y, int z);
	}
}