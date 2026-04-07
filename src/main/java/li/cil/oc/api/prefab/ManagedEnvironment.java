package li.cil.oc.api.prefab;
// PHASE8: stub for compat
public abstract class ManagedEnvironment implements li.cil.oc.api.network.ManagedEnvironment { private li.cil.oc.api.network.Node node; public li.cil.oc.api.network.Node node() { return node; } public void onConnect(li.cil.oc.api.network.Node n) {} public void onDisconnect(li.cil.oc.api.network.Node n) {} public void onMessage(li.cil.oc.api.network.Message m) {} }
