import java.awt.Color;

import graphics.Canvas;

public class Program {
	// Canvas GUI instance providing the drawing area on which to plot the functions
	private static Canvas canvas;

	public static void main(String[] args) {

		// Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240]
		// then
		// open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX,
		// pY) coords
		canvas = new Canvas();
		canvas.setRange(-360, -240, 360, 240);
		canvas.open();
		canvas.setColor(Color.black);

		// creates the functions as anonymous classes

		// linear function
		Function fLinear = new Function() {
			public int calc(int x) {
				return x;
			};

			public Color getColor() {
				return Color.red;
			};
		};

		// sine wave function
		Function fSine = new Function() {
			public int calc(int x) {
				return (int) (200 * Math.sin(Math.PI * x / 360));
			};

			public Color getColor() {
				return Color.blue;
			};
		};

		// quadratic function
		Function fQuadratic = new Function() {
			public int calc(int x) {
				return ((x - 200) * (x + 200)) / 250;
			};

			public Color getColor() {
				return new Color(0, 150, 20);
			};
		};

		// logarithmic function
		Function fLog = new Function() {
			public int calc(int x) {
				return (int) (20 * Math.log(x));
			};

			public Color getColor() {
				return Color.orange;
			};
		};

		// cubic function
		Function fCubic = new Function() {
			public int calc(int x) {
				return (int) ((Math.pow(x, 3)) / 200000);
			};

			public Color getColor() {
				return Color.black;
			};
		};

		// stepwise function
		Function fStep = new Function() {
			public int calc(int x) {
				int result = (x <= -100) ? (-100) : ((x >= 100 ? (100) : (x)));
				return result;
			};

			public Color getColor() {
				return Color.gray;
			};
		};

		// create an array with all of the functions
		Function[] functions = new Function[6];
		functions[0] = fLinear;
		functions[1] = fSine;
		functions[2] = fQuadratic;
		functions[3] = fLog;
		functions[4] = fCubic;
		functions[5] = fStep;

		// plot the functions
		plotAllFunctions(functions);

		canvas.pause();
		canvas.close();
	}

	/**
	 * plots functions on the canvas, given an array of functions
	 * 
	 * @param functions
	 *            array of functions to be plotted
	 */
	public static void plotAllFunctions(Function... functions) {
		for (Function f : functions) {
			plotFunction(f);
		}
	}

	/**
	 * plots a function
	 * 
	 * @param f
	 *            the function the method plots
	 */
	public static void plotFunction(Function f) {
		canvas.pause();
		for (int x = -360; x < 360; x++) {
			canvas.setColor(f.getColor());
			canvas.plot(x, f.calc(x));
		}
	}
}
