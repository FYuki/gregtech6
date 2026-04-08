package net.minecraft.util;
import java.util.HashMap;
/** PHASE3: stub — IntHashMap removed from MC; replaced by standard HashMap or int arrays */
public class IntHashMap<V> {
    private final HashMap<Integer, V> map = new HashMap<>();
    public void addKey(int key, V value) { map.put(key, value); }
    public V removeObject(int key) { return map.remove(key); }
    public V lookup(int key) { return map.get(key); }
    public boolean containsItem(int key) { return map.containsKey(key); }
    public void clearMap() { map.clear(); }
}
