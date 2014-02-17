///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             SVG.java
// Semester:         CS302 Fall 2013
//
// Author: Alejandro Puente
// CS Login: alejandr
// Lecturer's Name: Melissa Tress
// Lab Section: 341
//
// PAIR PROGRAMMERS COMPLETE THIS SECTION
// Pair Partner: Hildegarde Tineo
// CS Login: hildegard
// Lecturer's Name: Melissa Tress
// Lab Section: 341
//////////////////////////// 80 columns wide //////////////////////////////////

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class stores an unbounded collection of Shapes (depending on the input
 * file) and can plot them to a PortablePixmap.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class SVG 
{
	//This variable holds the ArrayList of shapes that need to be drawn to the
	//ppm file.
	private ArrayList<Shape> shapes;
	//This variable holds the input file.
	private File input;
	
	/**
	 * A constructor taking no arguments that creates an SVG with no shapes.
	 */
	
	public SVG()
	{
		this.shapes = new ArrayList<Shape>();
	}
	
	/**
	 * A constructor taking a String argument representing the name of an 
	 * SVG-encoded image file. All shapes are read from this file and added 
	 * to the SVG. If the file cannot be found, a java.io.FileNotFoundException 
	 * is thrown. 
	 */
	
	public SVG (File input)
	{
		this.input = input;
		this.shapes = new ArrayList<Shape>();
		readFile(input);
	}
	
	/**
	 * This method reads from a file and formats each line from the input file
	 * to determine what shape it wants and then adds the shape to the ArrayList
	 * of shapes.
	 *
	 * @param input The input file to read from.
	 */
	
	public void readFile(File input)
	{
		try
		{
			//This variable allows for reading of the input file.
			Scanner in = new Scanner(input);
			while (in.hasNextLine())
			{
				//This variable holds the String in each line of the input file.
				String line = in.nextLine();
				//This variable stores each element of the line, so it can easily
				//be processed.
				String[] shapeContent = line.split(" ");
				//This variable holds the red RGB value.
				int red = Integer.parseInt(shapeContent[1]); 
				//This variable holds the green RGB value.
				int green = Integer.parseInt(shapeContent[2]);
				//This variable holds the blue RGB value.
				int blue = Integer.parseInt(shapeContent[3]);
				//This variable holds the x starting point of the shape as a 
				//percentage
				double x = Double.parseDouble(shapeContent[4]);
				//This variable holds the y starting point of the shape as a 
				//percentage
				double y = Double.parseDouble(shapeContent[5]);

				if (shapeContent[0].equals("rectangle"))
				{
					//This variable holds the rectangle to draw.
					Rectangle rectangle = new Rectangle(new Color (red, green, blue)
					, x, y, Double.parseDouble(shapeContent[6]), 
					Double.parseDouble(shapeContent[7]));
					shapes.add(rectangle);
				}
				else if (shapeContent[0].equals("square"))
				{
					//This variable holds the square to draw.
					Square square = new Square(new Color (red, green, blue)
					, x, y, Double.parseDouble(shapeContent[6]));
					shapes.add(square);
				}
				else if (shapeContent[0].equals("circle"))
				{
					//This variable holds the circle to draw.
					Circle circle = new Circle(new Color (red, green, blue)
					, x, y, Double.parseDouble(shapeContent[6]));
					shapes.add(circle);
				}
				else
				{
					//This variable holds the ring to draw.
					Ring ring = new Ring(new Color (red, green, blue)
					, x, y, Double.parseDouble(shapeContent[6]), 
					Double.parseDouble(shapeContent[7]));
					shapes.add(ring);
				}
			}
			in.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry, unable to read from " + this.input.
					getPath() + ".");
		}
	}
	
	/**
	 * @return the ArrayList containing all the shapes that need to be drawn.
	 */
	
	public ArrayList<Shape> getShapes()
	{
		return this.shapes;
	}
}
