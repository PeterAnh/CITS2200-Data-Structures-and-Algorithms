import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestDijkstra{
	public static void main (String[] arg)
	{
		try
		{
			Dijkstra d = new Dijkstra ("input1.txt");
			d.printMat();
			d.print();
		}
		catch(IOException e)
		{	
			System.out.println ("Thua");
		}
	}
}