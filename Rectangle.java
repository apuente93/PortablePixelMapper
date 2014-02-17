///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             Rectangle.java
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
 * This class contains the rectangle shape to draw to the ppm file.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class Rectangle extends Shape
{
	//This variable holds the width of the rectangle as a percentage.
	private double widthPercentage;
	//This variable holds the height of the rectangle as a percentage.
	private double heightPercentage;	
	
	/**
	 * Constructor for the rectangle, that contains the same variables as any 
	 * shape in addition to the height an width of the rectangle as a 
	 * percentage.
	 */
	
	public Rectangle(Color c, double originX, double originY, 
			double widthPercentage, double heightPercentage)
	{
		super(c, originX, originY);
		this.widthPercentage = widthPercentage;
		this.heightPercentage = heightPercentage;

	}

	/**
	 * Draws the specified shape to the ppm file, which in this case is the
	 * rectangle.
	 *
	 * @param ppm the ppm file to draw to.
	 */
	
	public void drawTo(PPM ppm) 
	{ 
		//This variable holds the starting column to draw the shape.
		int startColumn = (int)(xRatio*ppm.getWidth());
		//This variable holds the starting row to draw the shape.
		int startRow = (int)(yRatio*ppm.getHeight());

		//This variable holds the ending column to draw the shape.
		int endColumn = ((int) (getWidthPercentage() * ppm.getWidth())) 
				+ startColumn;
		//This variable holds the ending row to draw the shape.
		int endRow = ((int) (getHeightPercentage() * ppm.getHeight())) 
				+ startRow;
		for (int i = startRow; i < endRow && i < ppm.getHeight(); i++)
		{
			for (int j = startColumn; j < endColumn && j < ppm.getWidth(); j++)
			{
				ppm.setPixel(i, j, color);
			}
		}
	}

	/**
	 * @return the width of the rectangle as a percentage.
	 */
	
	public double getWidthPercentage()
	{
		return this.widthPercentage;
	}

	/**
	 * @return the height of the rectangle as a percentage.
	 */
	
	public double getHeightPercentage()
	{
		return this.heightPercentage;
	}
}
