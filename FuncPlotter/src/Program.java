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
        canvas.setColor(Color.black);
        Function[] functions = new Function[6];
        functions[0] = (x) -> { return x;};
        functions[1] = (x) -> { return (int) (200 * Math.sin(Math.PI * x / 360));};
        functions[2] = (x) -> { return ((x - 200) * (x + 200)) / 250;};
        functions[3] = (x) -> { return (int) (20 * Math.log(x));};
        functions[4] = (x) -> { return (int) ((Math.pow(x, 3)) / 200000);};
        functions[5] = (x) -> {
        						int result = (x <= -100)
        									? (-100)
        									: ((x >= 100 ? (100) : (x)));
        						return result;
        					  };

        // plot the functions
        plotFunctions(functions);
        
        canvas.pause();
        canvas.close();
    }
    
    public static void plotFunctions(Function[] functions) {
    	for (Function f: functions) {
    		canvas.pause();
            for (int x = -360; x < 360; x++) {
                canvas.plot(x, f.calc(x));
            }
    	}
    }
}
