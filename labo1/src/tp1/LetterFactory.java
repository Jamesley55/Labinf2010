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
        Double spacing = stripeThickness * 2;
        Ellipse ellipse = new Ellipse(maxHeight, maxWidth);
        Rectangle rect = new Rectangle(maxWidth, stripeThickness);
        ellipse.add(rect);
        Rectangle smallSpace = new Rectangle(halfStripeThickness, halfStripeThickness);
        ellipse.remove(smallSpace);
        return ellipse;
    }

    // TODO
    public static BaseShape create_a() {
        Rectangle rect = new Rectangle(stripeThickness, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, stripeThickness);

        return rect.remove(rect2);
    }

    public static BaseShape create_C() {
        Rectangle rect = new Rectangle(stripeThickness, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, stripeThickness);

        return rect.remove(rect2);
    }

    // TODO
    public static BaseShape create_l() {
        return new Rectangle(stripeThickness, maxHeight);
    }

    // TODO
    public static BaseShape create_i() {
        Rectangle rect = new Rectangle(stripeThickness, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, stripeThickness);

        return rect.remove(rect2);
    }

    // TODO
    public static BaseShape create_A() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        return ellipse.add(rect2);

    }

    // TODO
    public static BaseShape create_V() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        return ellipse.add(rect2);
    }

    // TODO
    public static BaseShape create_n() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        return ellipse.add(rect2);
    }

    // TODO
    public static BaseShape create_r() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        return ellipse.add(rect2);
    }

    // TODO
    public static BaseShape create_B() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Rectangle rect2 = new Rectangle(stripeThickness, maxHeight);
        return ellipse.add(rect2);
    }
}
