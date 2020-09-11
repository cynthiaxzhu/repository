/**
 * Accepts one command-line argument int n and draws a Sierpinski 
 * triangle of order n using recursion.
 *
 * The command-line argument must be a nonnegative integer.
 *
 * Introduction to Computer Science - Spring 2020
 *
 * @author Cynthia Zhu
 */

public class SierpinskiTriangle {

    /**
     * Accepts one command-line argument int n, draws the outline of an 
     * equilateral triangle of side length 1 whose bottom-left vertex is 
     * (0.0, 0.0) and bottom-right vertex is (1.0, 0.0), and draws a 
     * Sierpinski triangle of order n using recursion.
     */
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        double[] x = {0.0, 1.0, 0.5};
        double[] y = {0.0, 0.0, Math.sqrt(3) / 2};

        StdDraw.polygon(x, y);

        drawSierpinski(n, 0.5, 0.0, 0.5);

    }

    /**
     * Draws a Sierpinski triangle of order n such that the largest filled
     * triangle has bottom vertex (x, y) and sides of length.
     */
    public static void drawSierpinski(int n, double x, double y, double length) {

        if (n == 0) {
            return;
        }

        drawFilledTriangle(x, y, length);

        drawSierpinski(n - 1, x - length / 2, y, length / 2);
        drawSierpinski(n - 1, x + length / 2, y, length / 2);
        drawSierpinski(n - 1, x, y + (length * Math.sqrt(3) / 2), length / 2);

    }

    /**
     * Draws a filled equilateral triangle of side length length whose 
     * bottom vertex is (x, y).
     */
    public static void drawFilledTriangle(double x, double y, double length) {

	    double[] arr1 = {x, x - (length / 2), x + (length / 2)};
        double[] arr2 = {y, y + computeHeight(length), y + computeHeight(length)};

        StdDraw.filledPolygon(arr1, arr2);

    }

    /**
     * Computes the height of an equilateral triangle of side length 
     * length.
     */
    public static double computeHeight(double length) {

	    double height = (length / 2) * Math.sqrt(3);

        return height;

    }

}