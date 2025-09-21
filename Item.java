import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class Item {
    private int value;
    public Item(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
class Container {
    private Item item;
    private List<Container> containers;
    public Container(Item item) {
        this.item = item;
        this.containers = null;
    }
    public Container(List<Container> containers) {
        this.item = null;
        this.containers = containers;
    }
    public boolean isItem() {
        return item != null;
    }
    public Item getItem() {
        return item;
    }
    public List<Container> getContainers() {
        return containers;
    }
}
class ValueCalculator {
    /**
     * TO-DO: Convert this method to be recursive.
     \*
     * This method sums the value of all Items within a nested container structure.
     * The current approach uses a Stack for an iterative, depth-first traversal.
     \*
     * @param container The top-level container.
     * @return The sum of all values.
     */
    public int calculateTotalValue(Container container) {
/*        int totalValue = 0;
        Stack<Container> stack = new Stack<>();
        stack.push(container);
        while (!stack.isEmpty()) {
            Container current = stack.pop();
            if (current.isItem()) {
                totalValue += current.getItem().getValue();
            } else {
                for (Container nestedContainer : current.getContainers()) {
                    stack.push(nestedContainer);
                }
            }
        }
        return totalValue;*/
        int totalValue = 0;
        if (container.isItem()){
          return   container.getItem().getValue();
        }
            for(Container nestedContainer: container.getContainers()){
                totalValue+= calculateTotalValue(nestedContainer);
        }
            return totalValue;

    }
        public static void main(String[] args) {
            // Create some items
            Item item1 = new Item(10);
            Item item2 = new Item(20);
            Item item3 = new Item(30);

            // Wrap items in containers
            Container container1 = new Container(new Item(10)); // 10
            Container container2 = new Container(new Item(20)); // 20
            Container container3 = new Container(new Item(30)); // 30

            // Create a nested container: container4 contains container1 and container2
            List<Container> subContainers1 = new ArrayList<>();
            subContainers1.add(container1);
            subContainers1.add(container2);
            Container container4 = new Container(subContainers1); // total = 10 + 20 = 30

            // Create another nested container: container5 contains container4 and container3
            List<Container> subContainers2 = new ArrayList<>();
            subContainers2.add(container4);
            subContainers2.add(container3);
            Container container5 = new Container(subContainers2); // total = 10 + 20 + 30 = 60

            // Create ValueCalculator and calculate the total value
            ValueCalculator calculator = new ValueCalculator();
            int totalValue = calculator.calculateTotalValue(container5);

            // Print the result
            System.out.println("Total value of items: " + totalValue);  // Expected: 60
        }
    }
