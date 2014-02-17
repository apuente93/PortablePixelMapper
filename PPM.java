///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PortablePixelMapper.java
// File:             PPM.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.Color;

/**
 * Depending on the input file, this class creates an output .ppm file that
 * contains the drawings of the shapes in ppm format.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class PPM 
{
	//This variable holds the width of the color array.
	private int width;
	//This variable holds the height of the color array.
	private int height;
	//This variable holds the 2D array that is used to draw to
	private Color[][] colorArray; 
	//This variable holds the output file.
	private File output;
	
	/**
	 * A constructor that takes in a width and height and creates a completely 
	 * white image having the specified dimensions and all elements set to 
	 * java.awt.Color.WHITE. The dimensions are constant.
	 */
	
	public PPM(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.colorArray = new Color[height][width];
		
		for (int i = 0; i < colorArray.length; i++)
		{
			for (int j = 0; j < colorArray[i].length; j++)
			{
				colorArray[i][j] = Color.WHITE;
			}
		}
	}
		
	/**
	 * This method writes the ppm information to the output file. If the file
	 * doesn't exist, it throws a FileNotFoundException.
	 *
	 * @param output the output ppm.
	 */
	
	public void writeToFile(File output)
	{
		try
		{
			this.output = output;
			//This variable allows writing to the output file.
			PrintWriter out = new PrintWriter(output);
			out.print(text());
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry, unable to write to " 
					+ this.output.getPath() + ".");
		}
	}
	
	/**
	 * This method creates the text version of the ppm file in row major
	 * order.
	 *
	 * @return the text version of the ppm file.
	 */
	
	public String text()
	{
		//This variable holds the text information of the ppm file.
		String text = "P3" + "\n";
		text += getWidth() + " " + getHeight() + "\n";
		text += "255" + "\n";
		
		for (int i = 0; i < this.colorArray.length; i++)
		{
			for (int j = 0; j < this.colorArray[i].length; j++)
			{
				text += this.colorArray[i][j].getRed() + 
						" " + this.colorArray[i][j].getGreen() +
						" " + this.colorArray[i][j].getBlue() +
						"\n";
			}
		}
		return text;
	}
	
	/**
	 * Sets the pixel at the position specified by the row and column to the 
	 * specified color. 
	 *
	 * @param row the row in the array where to paint.
	 * @param column the column in the array where to paint.
	 * @param color the color to use for painting.
	 */
	
	public void setPixel(int row, int column, Color color)
	{
		this.colorArray[row][column] = color;
	}
	
	/**
	 * @return the image width.
	 */
	
	public int getWidth()
	{
		return this.width;
	}
	
	/**
	 * @return the image height.
	 */
	
	public int getHeight()
	{
		return this.height;
	}
}
