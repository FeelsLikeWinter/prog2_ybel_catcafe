package catcafe;

import static java.util.Objects.requireNonNull;

import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

/** A cat café takes care of a number of cats. */
public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    /**
     * Add a new cat to the cat café.
     *
     * @param cat cat to be added
     */
    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    /**
     * Count the number of cats in the cat café.
     *
     * @return number of cats in the café
     */
    public long getCatCount() {
        return clowder.size();
    }

    /**
     * Pick up the first cat in the café with a given name.
     *
     * @param name name of the cat
     * @return cat with the given name
     */
    public Optional<FelineOverLord> getCatByName(String name) {
        // Wenn name leer wird empty zurückgegeben verhindert NullPointer
        if (name == null) return Optional.empty();

        // Stream erzeugen
        return clowder.stream()
            // Nur katzen mit dem passendem Namen werden rausgesucht
            .filter(c -> c.name().equals(name))
            // Waehlt die erste Katze mit dem Namen
            .findFirst();
    }

    /**
     * Pick up the first cat in the café with a weight within the specified limits.
     *
     * @param minWeight lower weight limit (inclusive)
     * @param maxWeight upper weight limit (exclusive)
     * @return cat within the weight limits
     */
    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {

        // Wenn die eingabe ungueltig ist wird empty zurueckgegeben
        if (minWeight < 0 || maxWeight < minWeight) return Optional.empty();

        // Stream erzeugen
        return clowder.stream()
            // Nur katzen mit dem passendem Gewicht werden rausgesucht
            .filter(c -> c.weight() >= minWeight && c.weight() < maxWeight)
            // Waehlt die erste Katze mit dem Gewicht
            .findFirst();
    }

    /**
     * Accept a visitor to this cat café.
     *
     * <p>The visitor needs to do all the heavy lifting, i.e. it needs to implement not only how to
     * process the node's data but also how to traverse the children of this node/leaf.
     *
     * @param visitor The visitor, which will work on this node (must not be {@code null})
     * @return a string representation as result of the traversal process
     * @throws NullPointerException if visitor is {@code null}
     */
    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
