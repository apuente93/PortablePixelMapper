///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             Ring.java
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
 * This class contains the square shape to draw to the ppm file.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class Ring extends Shape
{
	//This variable holds the radius of the inner circle as a percentage.
	private double inRadius;
	//This variable holds the radius of the outer circle as a percentage.
	private double outRadius;
	
	/**
	 * Constructor for the ring, that contains the same variables as any shape
	 * in addition to an inner circle and outer circle radius as a percentage.
	 */
	
	public Ring(Color c, double originX, double originY, 
			double outRadius, double inRadius)
	{
		super(c, originX, originY);
		this.inRadius = inRadius;
		this.outRadius = outRadius;
	}
	
	/**
	 * Draws the specified shape to the ppm file, which in this case is the
	 * ring.
	 *
	 * @param ppm the ppm file to draw to.
	 */
	
	public void drawTo(PPM ppm) 
	 { 
		//This variable holds the starting column to draw the shape.
		 int startColumn = (int)(xRatio*ppm.getWidth());
		//This variable holds the starting row to draw the shape.
		 int startRow = (int)(yRatio*ppm.getHeight());

		 //This variable holds the radius of the inner circle.
		 int inRadius = ((int) (getInRadius() * ppm.getWidth()));
		 //This variable holds the radius of the outer circle.
		 int outRadius = ((int) (getOutRadius() * ppm.getWidth()));
		 
		 for (int i = 0; i < ppm.getHeight(); i++)
		 {
			 for (int j = 0; j < ppm.getWidth(); j++)
			 {
				 if (Math.sqrt(Math.pow((startColumn - j), 2) + 
				     Math.pow((startRow - i), 2)) <= outRadius && 
				     Math.sqrt(Math.pow((startColumn - j), 2) + 
					 Math.pow((startRow - i), 2)) >= inRadius)
				 {
					 ppm.setPixel(i, j, color);
				 }
			 }
		 }
	 }
	
	/**
	 * @return the radius of the inner circle as a percentage.
	 */
	
	public double getInRadius()
	{
		return this.inRadius;
	}
	
	/**
	 * @return the radius of the outer circle as a percentage.
	 */
	
	public double getOutRadius()
	{
		return this.outRadius;
	}
}
