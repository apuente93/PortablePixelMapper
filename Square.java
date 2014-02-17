///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             Square.java
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

public class Square extends Shape
{
	//This variable holds the size of the square as a percentage.
	private double size;
	
	/**
	 * Constructor for the square, that contains the same variables as any 
	 * shape in addition to the size of the square as a percentage.
	 */
	
	public Square(Color c, double originX, double originY, 
			double size)
	{
		super(c, originX, originY);
		this.size = size;
	}
	
	/**
	 * Draws the specified shape to the ppm file, which in this case is the
	 * square.
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
		 int endColumn = ((int) (getSize() * ppm.getWidth())) 
				 + startColumn;
		 
		//This variable holds the ending row to draw the shape.
		 int endRow = ((int) (getSize() * ppm.getWidth())) 
				 + startRow;
		 
		 if (startColumn < 0)
		 {
			 startColumn = 0;
		 }
		 
		 if (startRow < 0)
		 {
			 startRow = 0;
		 }
		 
		 for (int i = startRow; i < endRow && i < ppm.getHeight(); i++)
		 {
			 for (int j = startColumn; j < endColumn && j < ppm.getWidth(); j++)
			 {
				 ppm.setPixel(i, j, color);
			 }
		 }
	 }
	
	/**
	 * @return the size of the square as a percentage.
	 */
	
	public double getSize()
	{
		return this.size;
	}
}
