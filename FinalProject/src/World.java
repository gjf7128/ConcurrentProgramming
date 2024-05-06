import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Node> resourceNodes;

    public World() {
        resourceNodes = new ArrayList<>();
        List<Node> nodes = List.of(new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.TREE, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20),
                new Node(NodeType.ANIMAL, 2, 20));
        resourceNodes.addAll(nodes);
    }

    public Node selectNode(int index) {
        return this.resourceNodes.get(index);
    }

    public void showNodes() {
        for (Node node : resourceNodes) {
            System.out.println(node);
        }
    }
}
