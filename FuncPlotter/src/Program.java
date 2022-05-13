import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();
        Function[] functions = new Function[5];
        functions[0] = (x) -> {return x;};
        functions[1] = (x) -> {return (int) (200 * Math.sin(Math.PI * x / 360));};
        functions[2] = (x) -> {return ((x - 200) * (x + 200)) / 250;};
        functions[3] = (x) -> {return (int) (20 * Math.log(x));};
        functions[4] = (x) -> {return (int) ((Math.pow(x, 3)) / 200000);};

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        
        for (int x = 0; x < 100; x++) {
            canvas.plot(x, functions[0].calc(x));
        }
        
        // draw a sine wave in blue
        canvas.pause();
        canvas.setColor(Color.blue);
        
        for (int x = -360; x < 360; x++) {
            canvas.plot(x, functions[1].calc(x));
        }
        
        // draw a quadratic in green
        canvas.pause();
        canvas.setColor(Color.green);
        for (int x = -360; x < 360; x++) {
            canvas.plot(x, functions[2].calc(x));
        }
        
        // draw a log graph in black
        canvas.pause();
        canvas.setColor(Color.black);
        for (int x = -360; x < 360; x++) {
            canvas.plot(x, functions[3].calc(x));
        }
        
        // draw a cubic in orange
        canvas.pause();
        canvas.setColor(Color.orange);
        for (int x = -360; x < 360; x++) {
            canvas.plot(x, functions[4].calc(x));
        }

        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
    }
    
    public static void plotFunctions(Function[] functions) {
    	for (Function f: functions) {
    		canvas.pause();
            canvas.setColor(Color.orange);
            for (int x = -360; x < 360; x++) {
                canvas.plot(x, f.calc(x));
            }
    	}
    }
}
