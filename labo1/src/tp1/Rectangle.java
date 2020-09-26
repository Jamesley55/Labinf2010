package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        //ArrayList<Point2d> newRect = new ArrayList<Point2d>();
        for(int i = 0; i < width.intValue(); i++){
            for(int j = 0; j < height.intValue(); j++) {
                add(new Point2d((double)i,(double)j));
            }
        }
    }

    // TODO creer un rectangle avec les dimensions contenu dans un Point.
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    // TODO initialiser le parent.
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        return translate(point);
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        return rotate(angle);
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(this.getCoordsDeepCopy()); }
}
