package net.itca.data;

public class Word
{
	private String category;
	private String word;
	
	public Word(String _category, String _word)
	{
		category = _category; 
		word = _word;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String GetWord()
	{
		return word;
	}
}
