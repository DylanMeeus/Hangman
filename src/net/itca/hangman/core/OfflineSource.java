package net.itca.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.itca.core.interfaces.DataSource;
import net.itca.data.Word;

public class OfflineSource implements DataSource
{
	private Theme theme;
	
	/**
	 * 	FRUIT,
	ANIMALS,
	SCIENCE,
	PEOPLE,
	SOFTWARE,
	GAMES;
	 */
	
	/**
	 * 
	 * @param theme
	 * This is the default, built-in datasource. Other applications can define their own datasource with the interface.
	 * 
	 */
	
	private List<Word> words;
	public OfflineSource()
	{
		words = new ArrayList<Word>();
		populateData();
	}
	
	private void populateData()
	{
		// Just some random data.
		words.add(new Word("ANIMALS","BEAR"));
		words.add(new Word("ANIMALS","CAT"));
		words.add(new Word("ANIMALS","TIGER"));
		words.add(new Word("FRUIT","APPLE"));
		words.add(new Word("FRUIT","BANANA"));
		words.add(new Word("FRUIT","GRAPE"));
		words.add(new Word("SCIENCE","QUANTUM"));
		words.add(new Word("SCIENCE","OSMOSIS"));
		words.add(new Word("SCIENCE","GENOMICS"));
		words.add(new Word("PEOPLE","NEWTON"));
		words.add(new Word("PEOPLE","EINSTEIN"));
		words.add(new Word("PEOPLE","FEYNMAN"));
		words.add(new Word("SOFTWARE","PHOTOSHOP"));
		words.add(new Word("SOFTWARE","ECLIPSE"));
		words.add(new Word("SOFTWARE","NETSCAPE"));
		words.add(new Word("GAMES","PORTAL"));
		words.add(new Word("GAMES","FALLOUT"));
		words.add(new Word("GAMES","SUPERMARIO"));
	}
	
	private String getWordFromList(String theme)
	{
		
		ArrayList<String> tempList = new ArrayList<String>();
		for(Word word : words)
		{
			if(word.getCategory().toLowerCase().equals(theme.toLowerCase()))
			{
				tempList.add(word.GetWord());
			}
		}
		
		Random rand = new Random();
		int randomIndex = rand.nextInt(tempList.size());
		return tempList.get(randomIndex);
	}
	
	@Override
	public String getWord()
	{
		String chosenWord = "";
		switch(theme)
		{
		case ANIMALS: chosenWord = getWordFromList("ANIMALS");
			break;
		case FRUIT: chosenWord = getWordFromList("FRUIT");
			break;
		case SCIENCE: chosenWord = getWordFromList("SCIENCE");
			break;
		case PEOPLE: chosenWord = getWordFromList("PEOPLE");
			break;
		case SOFTWARE: chosenWord = getWordFromList("SOFTWARE");
			break;
		case GAMES: chosenWord = getWordFromList("GAMES");
			break;
		}
		return chosenWord;
	}
	
	@Override
	public void setTheme(String newTheme)
	{
		for(Theme item : Theme.values())
		{
			if(item.toString().equals(newTheme))
			{
				theme = item; // call to the setTheme(Theme theme). No infinite loop :)
				break;
			}
		}
	}
	
	@Override
	public List<String> getThemes()
	{
		List<String> themelist = new ArrayList<String>();
		for(Theme theme : Theme.values())
		{
			themelist.add(theme.toString());
		}
		return themelist;
	}


}
