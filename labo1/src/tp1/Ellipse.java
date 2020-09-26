package tp1;

import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        for(int i = 0; i < widthRadius)
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        // ...
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return translate(point);
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return rotate(angle);
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return null; }
}
