package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    // TODO
    public static BaseShape create_e() {
        return null;
    }

    // TODO
    public static BaseShape create_a() {
        return null;
    }

    public static BaseShape create_C() {
        Ellipse mainBody = new Ellipse(maxWidth, maxHeight);
        Ellipse middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
        BaseShape rightToRremove = new Rectangle(halfMaxWidth, maxHeight/1.5).translate(new Point2d(halfMaxWidth/2, 0.0));

        mainBody.remove(middleToRemove);
        mainBody.remove(rightToRremove);
        return mainBody;
    }

    // TODO
    public static BaseShape create_l() {
        return null;
    }

    // TODO
    public static BaseShape create_i() {
        return null;
    }

    // TODO
    public static BaseShape create_A() {
        return null;
    }

    // TODO
    public static BaseShape create_V() {
        return null;
    }

    // TODO
    public static BaseShape create_n() {
        return null;
    }

    // TODO
    public static BaseShape create_r() {
        return null;
    }

    // TODO
    public static BaseShape create_B() {
        return null;
    }
}
