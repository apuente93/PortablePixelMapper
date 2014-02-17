///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             Circle.java
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

/**
 * This class contains the circle shape to draw to the ppm file.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class Circle extends Shape
{
	//This variable holds the radius of the circle as a percentage.
	private double radius;
	
	/**
	 * Constructor for the circle, that contains the same variables as any shape
	 * in addition to the circle radius as a percentage.
	 */
	
	public Circle(Color c, double originX, double originY, 
			double radius)
	{
		super(c, originX, originY);
		this.radius = radius;
	}
	
	/**
	 * Draws the specified shape to the ppm file, which in this case is the
	 * circle.
	 *
	 * @param ppm the ppm file to draw to.
	 */
	
	public void drawTo(PPM ppm) 
	 { 
		//This variable holds the starting column to draw the shape.
		 int startColumn = (int)(xRatio*ppm.getWidth());
		//This variable holds the starting row to draw the shape.
		 int startRow = (int)(yRatio*ppm.getHeight());

		 //This variable contains the radius of the circle.
		 int radius = ((int) (getRadius() * ppm.getWidth()));
		 
		 
		 for (int i = 0; i < ppm.getHeight(); i++)
		 {
			 for (int j = 0; j < ppm.getWidth(); j++)
			 {
				 if (Math.sqrt(Math.pow((startColumn - j), 2) + 
				     Math.pow((startRow - i), 2)) <= radius)
				 {
					 ppm.setPixel(i, j, color);
				 }
			 }
		 }
	 }
	
	/**
	 * @return the radius of the circle as a percentage.
	 */
	
	public double getRadius()
	{
		return this.radius;
	}
}
