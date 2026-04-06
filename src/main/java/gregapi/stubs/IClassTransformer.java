package gregapi.stubs;
// PHASE6: IClassTransformer removed — use Mixin in 1.21
@SuppressWarnings("unused")
public interface IClassTransformer {
    byte[] transform(String name, String transformedName, byte[] basicClass);
}
