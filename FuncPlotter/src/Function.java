import java.awt.Color;

public interface Function {
	/**
	 * calculates the function
	 * 
	 * @param x
	 *            the function input
	 * @return the function output
	 */
	int calc(int x);

	/**
	 * @return a color
	 */
	Color getColor();
}
