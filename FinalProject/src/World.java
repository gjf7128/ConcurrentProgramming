import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Node> resourceNodes;
    private List<Worker> workers;

    private List<Node> buildingNodes;

    public World() {
        resourceNodes = new ArrayList<>();
        List<Node> nodesToAdd = List.of(new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20));
        resourceNodes.addAll(nodesToAdd);

        workers = new ArrayList<>();
        List<Worker> workersToAdd = List.of(new Worker(), new Worker());
        workers.addAll(workersToAdd);

        buildingNodes = new ArrayList<>();
        List<Node> buildingsToAdd = List.of(new Node(NodeType.FRIENDLY_BUILDING, 1, 100));
        buildingNodes.addAll(buildingsToAdd);
    }

    public Node selectNode(int index) {
        return this.resourceNodes.get(index);
    }

    public void showNodes() {
        for (Node node : resourceNodes) {
            System.out.println(node + "\n");
        }
    }

    public Worker selectWorker(int index) {
        return this.workers.get(index);
    }

    public void showWorkers() {
        for (Worker worker : workers) {
            System.out.println(worker + "\n");
        }
    }

    public Node selectBuilding(int index) {
        return this.buildingNodes.get(index);
    }

    public void showBuildings() {
        for (Node building : buildingNodes) {
            System.out.println(building + "\n");
        }
    }
}
