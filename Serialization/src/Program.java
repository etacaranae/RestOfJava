import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;

import graphics.Canvas;

public class Program {

	// Canvas to be used for all drawings.
	private static Canvas _canvas = new Canvas(-200, -120, 200, 120, 2);

	// Array of Shapes to be drawn on the canvas.
	private static AllShapes _shapes = new AllShapes();

	private static void loadShapes(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner reader = new Scanner(inputFile);
		String line = reader.nextLine();

		Gson deserializer = new Gson();
		_shapes = deserializer.fromJson(line, AllShapes.class);

		reader.close();
	}

	/**
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	private static void saveShapes(String fileName) throws FileNotFoundException {
		Gson serializer = new Gson();
		String content = serializer.toJson(_shapes);
		File f = new File(fileName);
		PrintStream writer = new PrintStream(f);
		writer.println(content);
		writer.close();
	}

	/**
	 * Main method.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		_canvas.open();

		// create a bunch of shapes
		_shapes.createShapes();
		loadShapes("vector.json");

		// draw them all on the canvas
		_shapes.drawShapes(_canvas);
		_canvas.pause();

		// translate all shapes by 20 on X and -15 on Y.
		_canvas.clear();
		_shapes.translateShapes(-15, 20);
		_shapes.drawShapes(_canvas);
		_canvas.pause();

		saveShapes("vector.json");

		// close the canvas
		_canvas.close();
	}
}
