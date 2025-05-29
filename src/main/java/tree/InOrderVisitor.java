package tree;

public class InOrderVisitor implements TreeVisitor{
    @Override
    public String visit(Empty node) {
        return "";
    }

    @Override
    public String visit(Node node) {
        return node.leftChild().accept(this) + node.data().toString() + node.rightChild().accept(this);
    }
}
