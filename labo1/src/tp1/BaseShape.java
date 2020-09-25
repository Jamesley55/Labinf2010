package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        // ...
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        // ...
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public BaseShape add(Point2d coord) {
        // ...
        return null;
    }
    public BaseShape add(BaseShape shape) {
        // ...
        return null;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        // ...
        return null;
    }
    public BaseShape remove(Point2d coord) {
        // ...
        return null;
    }
    public BaseShape remove(BaseShape shape) {
        // ...
        return null;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        // ...
        return null;
    }

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return null;
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
        return null;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        return null;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        return null;
    }

    // TODO donner la plus grande valeur en X
    public Double getMaxX() {
        return null;
    }

    // TODO donner la plus grande valeur en Y
    public Double getMaxY() {
        return null;
    }

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {
        return null;
    }

    // TODO donner la plus petite valeur en X
    public Double getMinX() {
        return null;
    }
    // TODO donner la plus petite valeur en Y
    public Double getMinY() {
        return null;
    }

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        return null;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        return this;
    }
}
