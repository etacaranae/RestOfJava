import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.google.gson.Gson;

import graphics.Canvas;

public class Program {
    
    // Canvas to be used for all drawings.
    private static Canvas _canvas = new Canvas(-200, -120, 200, 120, 2);
    
    // Array of Shapes to be drawn on the canvas.
    private static AllShapes _shapes = new AllShapes();
    
    
    private static void loadShapes(String fileName) {
    	
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
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        _canvas.open();
        
        // create a bunch of shapes
        _shapes.createShapes();
        
        // draw them all on the canvas
        _shapes.drawShapes(_canvas);
        _canvas.pause();
        
        // translate all shapes by 20 on X and -15 on Y.
        _canvas.clear();
        _shapes.translateShapes(20, -15);
        _shapes.drawShapes(_canvas);
        _canvas.pause();
        
        saveShapes("vector.json");
        
        // close the canvas
        _canvas.close();
    }
}
