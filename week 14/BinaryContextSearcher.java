import java.util.ArrayList;

public class BinaryContextSearcher extends ContextSearcher 
{
	public BinaryContextSearcher(String filename) 
	{
		super(filename);
	}

	public String find(Word query, int window) 
	{
		/*
		 * int start = 0; int end = sortedWords.size() - 1;
		 * 
		 * for (Word sort : sortedWords) { int middle = (end - start) / 2; if
		 * (query.equals(window)) { return getSnippet(sort, window); } else if
		 * (query.getPosition(middle) > window) { end = middle - 1; } else { start =
		 * middle + 1; } } return null;
		 */
		int position = findHelper(query, window, 0, sortedWords.size());
   
		if (position == -1) 
		{
			return null;
		}
  
		int get_ = position - 1;
		boolean use_ = false;
		while (sortedWords.get(get_).getWord().equals(sortedWords.get(position).getWord())) 
		{
			get_--;
			use_ = true;
		}
   
		if (use_ == true)
		{
			return getSnippet(sortedWords.get(get_ + 1), window);
		}
		return getSnippet(sortedWords.get(position), window);
	}
	
	public int findHelper(Word query, int window, int Start, int Destination) 
	{
		if (Destination < Start)
		{
			return -1;
		}
		int MidWay = Start + (Destination - Start) / 2;
   
		if (query.equals(sortedWords.get(MidWay))) 
		{
			return MidWay;
		} 
		else if (query.compareTo(sortedWords.get(MidWay)) > 0) 
		{
			return findHelper(query, window, MidWay + 1, Destination);
		} 
		else if (query.compareTo(sortedWords.get(MidWay)) < 0) 
		{
			return findHelper(query, window, Start, MidWay - 1);
		}
		return -1;
	}
 }