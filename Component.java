import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Component {
    private String id;
    private boolean enabled = true;
    private List<Component> children = new ArrayList<>();
    public Component(String id) {
        this.id = id;
    }
    public void add(Component component) {
        children.add(component);
    }
    public List<Component> getChildren() {
        return children;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        System.out.println("Component " + id + " set to " + (enabled ? "enabled" : "disabled"));
    }
}
class ComponentManager {
    /**
     * TO-DO: Refactor this iterative method into a recursive one.
     \*
     * This method disables a component and all of its descendants. The current
     * implementation uses a Queue to perform a breadth-first traversal.
     \*
     * @param root The component to start with.
     */
    public void disableAll(Component root) {
//        Queue<Component> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            Component current = queue.poll();
//            current.setEnabled(false);
//            for (Component child : current.getChildren()) {
//                queue.offer(child);
//            }
        root.setEnabled(false);
        for(Component child: root.getChildren()){
            if (child==null) return;
            disableAll(child);
        }
    }
    public static void main(String[] args) {
        // Create components
        Component root = new Component("root");
        Component child1 = new Component("child1");
        Component child2 = new Component("child2");
        Component grandChild1 = new Component("grandChild1");
        Component grandChild2 = new Component("grandChild2");

        // Build the component tree
        child1.add(grandChild1);
        child2.add(grandChild2);
        root.add(child1);
        root.add(child2);

        // Create the manager
        ComponentManager manager = new ComponentManager();

        // Disable all components starting from root
        System.out.println("Disabling all components:");
        manager.disableAll(root);
    }
}