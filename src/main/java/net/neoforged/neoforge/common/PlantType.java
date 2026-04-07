package net.neoforged.neoforge.common;
// PHASE8: stub - PlantType was removed/merged in NeoForge 21.4.x
public final class PlantType {
    public static final PlantType PLAINS  = new PlantType("plains");
    public static final PlantType DESERT  = new PlantType("desert");
    public static final PlantType BEACH   = new PlantType("beach");
    public static final PlantType CAVE    = new PlantType("cave");
    public static final PlantType WATER   = new PlantType("water");
    public static final PlantType NETHER  = new PlantType("nether");
    public static final PlantType CROP    = new PlantType("crop");
    private final String name;
    private PlantType(String name) { this.name = name; }
    @Override public String toString() { return name; }
}
