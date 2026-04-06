package gregapi.stubs;

import java.io.File;

// PHASE3: net.minecraftforge.common.config.Configuration removed.
// NeoForge uses ModConfigSpec (TOML). This stub keeps GT6 code compiling during migration.
@SuppressWarnings("unused")
public class Configuration {
	public static final String CATEGORY_GENERAL = "general";

	public Configuration(File file) {}
	public Configuration(File file, boolean caseSensitiveCustomCategories) {}

	public Property get(String category, String key, boolean defaultValue) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, boolean defaultValue, String comment) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, int defaultValue) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, int defaultValue, String comment) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, double defaultValue) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, double defaultValue, String comment) { return new Property(String.valueOf(defaultValue)); }
	public Property get(String category, String key, String defaultValue) { return new Property(defaultValue); }
	public Property get(String category, String key, String defaultValue, String comment) { return new Property(defaultValue); }
	public Property get(String category, String key, String[] defaultValue) { return new Property(defaultValue.length > 0 ? defaultValue[0] : ""); }
	public Property get(String category, String key, String[] defaultValue, String comment) { return get(category, key, defaultValue); }
	public Property get(String category, String key, int[] defaultValue) { return new Property("0"); }
	public Property get(String category, String key, int[] defaultValue, String comment) { return get(category, key, defaultValue); }

	public boolean hasChanged() { return false; }
	public void load() {}
	public void save() {}
	public java.util.Set<String> getCategoryNames() { return java.util.Collections.emptySet(); }
	public void setCategoryComment(String category, String comment) {}
	public void setComment(String category, String key, String comment) {}
	public boolean hasCategory(String category) { return false; }
	public void removeCategory(String category) {}
}
