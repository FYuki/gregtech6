package gregapi.stubs;
// PHASE4: LanguageRegistry removed — use assets/lang/*.json in 1.21
@SuppressWarnings("unused")
public class LanguageRegistry {
    public static LanguageRegistry instance() { return new LanguageRegistry(); }
    public void addStringLocalization(String key, String value) {}
    public void addStringLocalization(String key, String lang, String value) {}
}
