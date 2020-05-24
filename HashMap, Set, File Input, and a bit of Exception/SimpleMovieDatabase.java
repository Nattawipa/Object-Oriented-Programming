import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	public File file;
	
	public void importMovies(String movieFilename) throws IOException
	{	//YOUR CODE GOES HERE
	 file = new File(movieFilename);
		List<String> lines = FileUtils.readLines(file);
		String pattern = "([0-9]+),(.{2,}),(.+(\\|.+)*)?";
		Pattern pat = Pattern.compile(pattern);
		for(String line : lines) {
			Matcher match = pat.matcher(line);
			if(match.find()) {
				Movie movie = new Movie(Integer.parseInt(match.group(1)), match.group(2));
				for(String tag : match.group(3).split("\\|")) {
					movie.tags.add(tag);
				}
				this.movies.put(Integer.parseInt(match.group(1)), movie);
			}
		}
		     
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> movie = new ArrayList<Movie>();
		for(Movie m : movies.values()) {
			if(m.title.contains(query)) {
				movie.add(m);
			}
		}
		return movie;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> movie = new ArrayList<Movie>();
		for(Movie m : movies.values()) {
			if(m.tags.contains(tag)) {
				movie.add(m);
			}
		}
		return movie;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}