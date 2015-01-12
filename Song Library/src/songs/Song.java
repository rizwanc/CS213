package songs;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
@author
 Rizwan Chaudry
*/

public class Song 
{
	public HashMap<String, ArrayList<String>> songList = new HashMap<String, ArrayList<String>>(101);
	
	SongLib song;
	
	public void removeSong(String key)
	{
		songList.remove(key);
	}
	
	public void add(String artist, String song, String album, String year)
	{
		ArrayList<String> list = new ArrayList<String>();  
		
		if(album == null && year == null)
		{
			list.add(song);
			songList.put(artist, list);
			
			return;
			
		}
		else if(album == null)
		{
			list.add(song);
			list.add(year);
			songList.put(artist, list);
			
			return;
		}
		else if(year == null)
		{
			list.add(album);
			songList.put(artist, list);
			
			return;
		}
		
		list.add(song);
		list.add(album);
		list.add(year);
		
		songList.put(artist, list);
		
		
		
	}
	
	public void updateInfo(String key, String artist, String song, String album, String year)
	{
		ArrayList<String> list = new ArrayList<String>();  
		
		if(artist != null)
		{
			removeSong(key);
			
			add(artist, song, album, year);
			
			return;
		}
		
		for(String info : songList.keySet())
		{
			if(key.equals(info))
			{
				list.add(song);
				list.add(album);
				list.add(year);
				
				songList.put(key, list);
			}
		}
	}
	
	public ArrayList<String> getInfo(String key)
	{
		return songList.get(key);
	}
	
	public void printSongs()
	{
		for(String info : songList.keySet())
		{
			System.out.println("These are the artists " + info + " " + (ArrayList<String>)songList.get(info));
		}
	}

}
