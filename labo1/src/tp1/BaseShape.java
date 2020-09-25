package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        coords =  new ArrayList<Point2d>();

    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<Point2d>();
        for (Point2d point : coords) {
            add(point);
        }
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public BaseShape add(Point2d coord) {
        coords.add(coord);
        return this;
    }
    public BaseShape add(BaseShape shape) {
        coords.addAll(shape.coords);
        return this;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
        return this;
    }
    public BaseShape remove(Point2d coord) {
        this.coords.remove(coord);
        return this;
    }
    public BaseShape remove(BaseShape shape) {
        this.coords.removeAll(shape.coords);
        return this;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
        return this;
    }

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return this.coords;
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
         List<Point2d>newCoords =  new ArrayList<Point2d>();
        for (Point2d points : coords) {
            newCoords.add(points.clone());
        }
        return  newCoords;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        for (Point2d points : coords) {
            points.translate(point);
        }
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        for (Point2d points : coords) {
            points.rotate(angle);
        }
        return this;
    }

    // TODO donner la plus grande valeur en X
    public Double getMaxX() {
        double coorX = 0.0;
        for (Point2d point : coords) {
            if (coorX < point.X()) {
                coorX = point.X();
            }

        }
        return coorX;
    }

    // TODO donner la plus grande valeur en Y
    public Double getMaxY() {
        double coorY = 0.0;
        for (Point2d point : coords) {
            if (coorY < point.Y()) {
                coorY = point.Y();
            }

        }
        return coorY;
    }

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {
        double coorX = 0.0;
        double coorY = 0.0;
        for (Point2d point : coords) {
            if (coorX < point.X()) {
                coorX = point.X();
            }
            if (coorY < point.Y()) {
                coorY = point.Y();
            }
        }
        return new Point2d(coorX, coorY);
    }

    // TODO donner la plus petite valeur en X (hardcoded)
    public Double getMinX() {
        double coorX= 1.0;
        for (Point2d point : coords) {
            if (coorX > point.X()) {
                coorX = point.X();
            }

        }
        return coorX;
    }
    // TODO donner la plus petite valeur en Y (hardcoded)
    public Double getMinY() {
        double coorY = 0.0;
        for (Point2d point : coords) {
            if (coorY > point.Y()) {
                coorY = point.Y();
            }

        }
        return coorY;
    }

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        double coorX = 1.0;
        double coorY = 0.0;
        for (Point2d point : coords) {
            if (coorX > point.X()) {
                coorX = point.X();
            }
            if (coorY > point.Y()) {
                coorY = point.Y();
            }
        }
        return new Point2d(coorX, coorY);
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        return new BaseShape(coords);
    }
}
