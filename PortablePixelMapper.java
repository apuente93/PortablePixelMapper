///////////////////////////////////////////////////////////////////////////////
// ALL STUDENTS COMPLETE THESE SECTIONS
// Title: PortablePixelMapper
// Files: PortablePixelMapper.java, PPM.java, SVG.java, Shape.java, Circle.java,
//		  Ring.java, Square.java, Rectangle.java
// Semester: CS302 Fall 2013
//
// Author: Alejandro Puente
// Email: apuente@wisc.edu
// CS Login: alejandr
// Lecturer's Name: Melissa Tress
// Lab Section: 341
//
// PAIR PROGRAMMERS COMPLETE THIS SECTION
// Pair Partner: Hildegarde Tineo
// Email: tineopaz@wisc.edu
// CS Login: hildegard
// Lecturer's Name: Melissa Tress
// Lab Section: 341
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.File;

/**
 * This class contains the main interface that puts together all the other 
 * classes in the program. It reads in an input file and creates an output
 * file depending on the input file.
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente & Hildegarde Tineo
 */

public class PortablePixelMapper 
{
	
	/**
	 * The main method starts the entire program's execution. This main 
	 * method creates a file and produces an output file. The arguments given
	 * by the user, determine the names and the size of the output file.
	 */

	public static void main(String[] args)
	{	
		try
		{
			//This variable contains the height of the output file.
			final int WIDTH;
			//This variable contains the height of the output file.
			final int HEIGHT;

			if (args.length != 4)
			{
				throw new IllegalArgumentException();
			}

			if (!isInteger(args[1]) || !isInteger(args[2]))
			{
				throw new IllegalArgumentException();
			}

			WIDTH = Integer.parseInt(args[1].trim());
			HEIGHT = Integer.parseInt(args[2].trim());

			//This variable holds the input file as described by the arguments.
			File file1 = new File(args[0].trim());
			//This variable holds the output file as described by the arguments.
			File file2 = new File(args[3].trim());

			//This variable is used to manipulate the input file.
			SVG svgFile = new SVG(file1);
			//This variable is used to manipulate the output file.
			PPM ppmFile = new PPM(WIDTH, HEIGHT);

			for (int i = 0; i < svgFile.getShapes().size(); i++)
			{
				svgFile.getShapes().get(i).drawTo(ppmFile);
			}

			ppmFile.writeToFile(file2);
			
			/*for (int i = 0; i < args.length; i++)
			{
				System.out.print(args[i] + " ");
			}*/
		}
		catch (IllegalArgumentException e)
		{
			System.out.print(usageMessage());
		}
	}		
	
	/**
	 * This method provides the usage message. It just helps minimize the main
	 * method.
	 *
	 * @return the usage message as a String.
	 */
	
	public static String usageMessage()
	{
		//This variable holds the usage message.
		String message = "Usage:" + "\n" +
	"java PortablePixelMapper <inFile> <width> <height> <outFile>" + "\n" + "\n"
	+"<inFile> is the name of an input file with svg shape information" + "\n" +
	"<width> is the result image width in pixels" + "\n" +
	"<height> is the result image height in pixels" + "\n" +
	"<outFile> is the name of the ppm file to create" + "\n" + "\n" +
	"Example:" + "\n" +
	"java PortablePixelMapper sample01.txt 100 100 image01.ppm";
		return message;
	}
	
	/**
	 * This method is used to check that args[1] and args[2] are in fact
	 * integer values.
	 *
	 * @param s The String that will be checked to see if it's an integer
	 * 			String.
	 * @return whether it is an integer or not.
	 */
	
	public static boolean isInteger(String s) {
	    try 
	    { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException e) 
	    { 
	        return false; 
	    }
	    return true;
	}

}
