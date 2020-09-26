package tp1;

import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        Double a  = widthRadius;
        Double b = heightRadius;
        for(int i = 0; i < widthRadius.intValue(); i++){
            for(int j = 0; j < heightRadius.intValue(); j++) {
                add(new Point2d((double)Math.sqrt((1-(Math.pow(i,2))/Math.pow(a,2))*Math.pow(b,2)),
                        (double)Math.sqrt((1-(Math.pow(j,2))/Math.pow(b,2))*Math.pow(a,2))));
            }
            a--;
            b--;

        }
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
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
    public Ellipse clone() { return new Ellipse(getCoordsDeepCopy()); }
}
