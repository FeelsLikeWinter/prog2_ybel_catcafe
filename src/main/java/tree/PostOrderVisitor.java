package tree;

public class PostOrderVisitor implements TreeVisitor{
    @Override
    public String visit(Empty node) {
        return "";
    }

    @Override
    public String visit(Node node) {
        return node.leftChild().accept(this) + node.rightChild().accept(this) + node.data().toString();
    }
}
