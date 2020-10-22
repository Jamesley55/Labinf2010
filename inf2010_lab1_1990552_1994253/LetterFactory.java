package tp1;

import org.w3c.dom.css.Rect;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    // TODO
    public static BaseShape create_e() {
        BaseShape Ellipse = new Ellipse(maxWidth, maxHeight);
        for (int i = 0; i < halfMaxWidth / 2 + 10; i++) {
            BaseShape littleCircle = new Rectangle(halfMaxWidth - i, maxHeight / 3 - i);
            Ellipse.remove(littleCircle);

        }
        Rectangle rect = new Rectangle(maxWidth - 5.0, halfStripeThickness / 2).translate(new Point2d(-halfMaxHeight / 3, 10.0));
        Ellipse.add(rect);
        return Ellipse;
    }

    // TODO
    public static BaseShape create_a() {
        BaseShape Ellipse = new Ellipse(maxWidth, maxHeight);
        for (int i = 0; i < halfMaxWidth / 2 + 10; i++) {
            BaseShape littleCircle = new Rectangle(stripeThickness - i, maxHeight - i).translate(new Point2d(halfMaxWidth / 1.5, -maxHeight / 2));
            Ellipse.add(littleCircle);

        }
        return Ellipse;
    }

    public static BaseShape create_C() {
        BaseShape Ellipse = new Ellipse(maxWidth, maxHeight);
        for (int i = 0; i < halfMaxWidth / 2 ; i++) {
            BaseShape littleCircle = new Rectangle(halfMaxWidth - i, maxWidth  - i*2);
            Ellipse.remove(littleCircle);

        }
        return Ellipse;
    }

    // TODO
    public static BaseShape create_l() {
        return new Rectangle(stripeThickness, maxHeight);
    }

    // TODO
    public static BaseShape create_i() {

        Rectangle rect = new Rectangle(stripeThickness, maxHeight/1.5);
        Rectangle rect3 = new Rectangle(maxWidth/3, stripeThickness).translate( new Point2d(0.0, -maxHeight/3));
rect.add(rect3);

        return rect;
    }

    // TODO
    public static BaseShape create_A() {
        Rectangle Rect1 = new Rectangle(stripeThickness, maxHeight).rotate(Math.toRadians(15));
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight).rotate(Math.toRadians(-15));
        Rectangle rect3 = new Rectangle(maxWidth, stripeThickness).translate( new Point2d(-maxWidth/2.9, maxHeight/2));

        Rect1.add(rect2);
        Rect1.add(rect3);
        return Rect1;

    }

    // TODO
    public static BaseShape create_V() {
        Rectangle Rect1 = new Rectangle(stripeThickness, maxHeight).rotate(Math.toRadians(165));
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight).rotate(Math.toRadians(-165));
        Rect1.add(rect2);
        return Rect1;
    }

    // TODO
    public static BaseShape create_n() {
        Rectangle Rect1 = new Rectangle(stripeThickness, maxHeight).translate( new Point2d(-maxWidth,-halfMaxHeight));
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        for (int i = 0; i < maxWidth/2 ; i++) {
            BaseShape littleCircle = new Rectangle( maxWidth -i ,halfMaxWidth-i*2);
            ellipse.remove(littleCircle);

        }

        Rect1.add(ellipse);
        return Rect1;
    }

    // TODO
    public static BaseShape create_r() {

        Rectangle Rect1 = new Rectangle(halfStripeThickness, maxHeight/2).translate( new Point2d(-maxWidth/2, maxHeight/4));
        BaseShape Circle = new Ellipse(halfMaxWidth, halfMaxHeight);
        for (int i = 0; i < maxWidth ; i++) {
            BaseShape littleCircle = new Rectangle(maxWidth - i, maxHeight  - i);
            Circle.remove(littleCircle);

        }
        for (int i = 0; i < maxWidth ; i++) {
            BaseShape littleCircle = new Rectangle(maxWidth + i, maxHeight  + i);
            Circle.remove(littleCircle);

        }
        Circle.translate( new Point2d(-maxWidth/4, halfMaxHeight/4));
       Rect1.add(Circle);
        return Rect1;
    }

    // TODO
    public static BaseShape create_B() {
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        rect2.translate(new Point2d(-maxWidth / 1.6, -maxHeight / 4));

        BaseShape ellipse = new Circle(maxHeight / 2);
        BaseShape ellipse2 = new Circle(maxHeight / 2).translate(new Point2d(0.0, maxHeight / 2));
        rect2.add(ellipse);
        return rect2.add(ellipse2);
    }
}
