package gregapi.stubs;

// PHASE3: net.minecraftforge.common.config.Property removed.
// Stub to keep compilation during migration to NeoForge ModConfigSpec.
@SuppressWarnings("unused")
public class Property {
	private String mValue;

	public Property(String value) { this.mValue = value; }

	public String getString() { return mValue; }
	public boolean getBoolean() { return Boolean.parseBoolean(mValue); }
	public boolean getBoolean(boolean defaultValue) { try { return Boolean.parseBoolean(mValue); } catch (Throwable e) { return defaultValue; } }
	public int getInt() { try { return Integer.parseInt(mValue); } catch (Throwable e) { return 0; } }
	public int getInt(int defaultValue) { try { return Integer.parseInt(mValue); } catch (Throwable e) { return defaultValue; } }
	public double getDouble() { try { return Double.parseDouble(mValue); } catch (Throwable e) { return 0.0; } }
	public double getDouble(double defaultValue) { try { return Double.parseDouble(mValue); } catch (Throwable e) { return defaultValue; } }
	public String[] getStringList() { return new String[]{mValue}; }
	public int[] getIntList() { return new int[0]; }

	public Property setComment(String comment) { return this; }
	public Property setMinValue(int min) { return this; }
	public Property setMaxValue(int max) { return this; }
	public Property setMinValue(double min) { return this; }
	public Property setMaxValue(double max) { return this; }
	public Property setDefaultValue(String val) { return this; }
	public Property setLanguageKey(String key) { return this; }

	public boolean wasRead() { return false; }
	public boolean hasChanged() { return false; }
	public String getName() { return ""; }
}
