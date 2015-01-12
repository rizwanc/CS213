package songs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.*;

public class SongLib extends JFrame
{
	JTextField songList, sontTitle, artist, year;
	 
	
	
	public SongLib() 
	{
		try
		{
      	  // Create file 
	     FileWriter fstream = new FileWriter("artist.txt");
      	  BufferedWriter out = new BufferedWriter(fstream);
      	  //out.write();
      	  //Close the output stream
      	  out.close();
      	  }catch (Exception e)
      	  {
      		  //Catch exception if any
      		  System.err.println("Error: " + e.getMessage());
      	  }
	}
	
	

	public static void main(String[] args)
	{
		JFrame songLibrary = new SongLib();
		final Song song =  new Song();
		
		songLibrary.setTitle("Song Library");
	    songLibrary.add(new DisplayPanel());  
	    songLibrary.pack();  
	    songLibrary.setVisible(true);  
		songLibrary.setBounds(0, 0, 500, 500);
        songLibrary.setLocationRelativeTo(null);
        songLibrary.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        
        
        
        try
        {
        	  // Open the file that is the first 
        	  // command line parameter
        	  FileInputStream fstream = new FileInputStream("artist.txt");
        	  
        	  // Get the object of DataInputStream
        	  DataInputStream in = new DataInputStream(fstream);
        	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
        	  String strLine;
        	  
        	  //Read File Line By Line
        	  while ((strLine = br.readLine()) != null)   
        	  {
	        	  // Print the content on the console
	        	  System.out.println (strLine);
        	  }
        	  //Close the input stream
        	  in.close();
        	    }catch (Exception e){//Catch exception if any
        	  System.err.println("Error: " + e.getMessage());
        	  }
        }
	

}
