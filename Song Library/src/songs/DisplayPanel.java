package songs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import javax.swing.*;
import javax.swing.event.*;

public class DisplayPanel extends JPanel
{
	private JButton addSong, deleteSong, editSong;
	private JTextField Artist, Song, Year, Album;
	private JLabel artist, song, album, year;
	private JList<String> list;
	private GridBagConstraints gbc = new GridBagConstraints();
	private final DefaultListModel<String> model = new DefaultListModel<String>();
	private int click = 0;
	JLabel error = new JLabel("You must enter an artist and song name");
	Song songTable = new Song();
	
	public DisplayPanel()
	{
		setLayout(new GridBagLayout());
		
		JPanel buttonPane = new JPanel(new GridBagLayout());
		Artist = new JTextField(5);
		Song = new JTextField(5);
		Album = new JTextField(5);
		Year = new JTextField(5);
		
		artist = new JLabel("Artist");
		song = new JLabel("Song");
		album = new JLabel("Album");
		year = new JLabel("Year");
		
		 
		 
		 gbc.gridx = 0;
 		 gbc.gridy = 2;
    	 add(error, gbc);
    	 error.setVisible(false);   
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		//gbc.fill = GridBagConstraints.BOTH;
		add(artist, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		//gbc.fill = GridBagConstraints.BOTH;
		add(song, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		//gbc.fill = GridBagConstraints.BOTH;
		add(album, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		//gbc.fill = GridBagConstraints.BOTH;
		add(year, gbc);
		
		
		list = new JList<String>(model);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JScrollPane(list), gbc);
		
		
		gbc.insets = new Insets(10, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 4;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		add(Artist, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		add(Song, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		add(Album, gbc);

		gbc.gridx = 0;
		gbc.gridy = 10;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		add(Year, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		addSong = new JButton("Add");
		
		addSong.addActionListener(
				new ActionListener() 
		{
		   public void actionPerformed(ActionEvent event)
		   {
		                String artistName = Artist.getText();
		                String songTitle = Song.getText();
		                String album = Album.getText();
		                String year = Year.getText();
		                
		               
		                
		             if(artistName.equals("") || artistName == null && songTitle.equals("") || songTitle == null 
		            		 || !artistName.equals("") && songTitle.equals("") || songTitle == null || !songTitle.equals("") && artistName.equals("")
		            		 || artistName == null)
		             {
		            	 //System.out.println("HERE");
		            	 
		            	 error.setVisible(true);
				     }
		             else if(!Artist.equals("") && !Song.equals(""))
		             {
		                    model.addElement(artistName);
		                    Artist.setText(null);
		                    songTable.add(artistName, songTitle, album, year);
				            Song.setText(null);
				            Album.setText(null);
				            Year.setText(null);
				           
				            error.setVisible(false);      
				     }

		            
		                
		               System.out.println("THESE ARE THE ADDED SONGS!!!");
		                songTable.printSongs();
		            }
		        }
		        );

		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		//gbc.fill = GridBagConstraints.BOTH;
		buttonPane.add(addSong, gbc);
		
		
		editSong = new JButton("Edit");
		
		editSong.addActionListener(
				new ActionListener() 
		{
		   public void actionPerformed(ActionEvent event)
		   {
			   ArrayList<String> tempList = new ArrayList<String>();
			   
			 
			 if(click == 0)
			 {
				   if(list.isSelectionEmpty() == false)
				   {
			            String selected = list.getSelectedValue().toString();
			            
			            tempList = songTable.getInfo(selected);
			            
			            
			            Artist.setText(selected);
			            Song.setText(tempList.get(0));
			            Album.setText(tempList.get(1));
			            Year.setText(tempList.get(2));
			            
			            click++;
				   }
		     }
			 else
			 {
				    String artistName = Artist.getText();
	                String songTitle = Song.getText();
	                String album = Album.getText();
	                String year = Year.getText();
	                
	                songTable.updateInfo(list.getSelectedValue(), artistName, songTitle, album, year);
	                
	                click = 0;
	                
	                Artist.setText(null);
	                Song.setText(null);
		            Album.setText(null);
		            Year.setText(null);
		           
	                
	                System.out.println("THESE ARE THE EDITED SONGS!!!");
	                songTable.printSongs();
			 }
			   
		                
		            }
		        }
		        );

		gbc.gridx = 1;
		gbc.gridy = 3;
		//gbc.fill = GridBagConstraints.BOTH;
		buttonPane.add(editSong, gbc);
		
		deleteSong = new JButton("Delete");
		
		deleteSong.addActionListener(
				new ActionListener() 
		{
		   public void actionPerformed(ActionEvent event)
		   {
			   if(list.isSelectionEmpty() == false)
			   {
		            String selected = list.getSelectedValue().toString();
		            
		           // System.out.println("WWWW" + selected);
		            
		            songTable.removeSong(selected);
		            model.remove(list.getSelectedIndex());
		            
		            if(!Artist.equals("") || !Song.equals("") || !Album.equals("") || !Year.equals(""))
		            {
		            	Artist.setText(null);
		            	Song.setText(null);
		            	Album.setText(null);
		            	Year.setText(null);
		            	
		            	click = 0;
		            }
		            
			   }
			   
			   System.out.println("THESE ARE THE SONGS LEFT AFTER DELETION!!!");
               songTable.printSongs();
			   
		                
		            }
		        }
		        );
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonPane.add(deleteSong, gbc);
		
		gbc.gridx = 1;
        gbc.gridy = 0;
		add(buttonPane, gbc);

	}
}



	
    
	

