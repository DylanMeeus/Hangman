package net.itca.hangman.core;

import java.util.ArrayList;
import java.util.HashMap;
import net.itca.core.interfaces.Observer;
import net.itca.core.interfaces.DataSource;
import net.itca.core.interfaces.Observable;

/**
 * 
 * @author Dylan
 *
 */
public class Hangman implements net.itca.core.interfaces.Observable
{

	private DataSource dataSource; // eender welke data
	private HashMap<Character, Boolean> charmap;
	private char[] wordCharacters;
	private int errors;
	private ArrayList<Observer> observers;
	private GameState gameState;
	private int MAX_ALLOWED_ERRORS;

	public Hangman()
	{
		observers = new ArrayList<Observer>();
		charmap = new HashMap<Character, Boolean>();
		MAX_ALLOWED_ERRORS = 10; // to have a default
	}

	public void setGameState(GameState state)
	{
		gameState = state;
	}

	public void setWordCharacters(char[] _wordCharacters)
	{
		wordCharacters = _wordCharacters;
	}

	public char[] getWordCharacter()
	{
		return wordCharacters;
	}

	public void setErrors(int _errors)
	{
		errors = _errors;
	}

	public void start()
	{
		errors = 0;
		wordCharacters = dataSource.getWord().toLowerCase().toCharArray();
		for (char character : wordCharacters)
		{
			charmap.put(character, false);
		}
		gameState = GameState.ONGOING;
		notifyObservers();
	}

	public void stop()
	{
		gameState = GameState.GAMELOSS;
	}

	public void checkInput(char input)
	{

		if (charmap.containsKey(input))
		{
			charmap.remove(input);
			charmap.put(input, true);
		} else
		{
			errors++;
		}
		checkGameState();
		notifyObservers();
	}

	private void checkGameState()
	{
		if (errors == MAX_ALLOWED_ERRORS)
		{
			gameState = GameState.GAMELOSS;
		}

		if (!charmap.values().contains(false))
		{
			gameState = GameState.GAMEWIN;
		}
	}

	public String getUncoveredWord()
	{
		String x = "";
		for (char c : wordCharacters)
		{
			if (charmap.get(c))
			{
				x += c;
			} else
			{
				x += "_";
			}
		}
		return x;
	}

	@Override
	public void notifyObservers()
	{
		for (Observer o : observers)
		{
			o.update();
		}
	}

	public void RegisterObserver(Observer o)
	{
		observers.add(o);
	}

	public void RemoveObserver(Observer o)
	{
		observers.remove(o);
	}

	public ArrayList<Observer> getObservers()
	{
		return observers;
	}

	/* getters */
	public int getErrors()
	{
		return errors;
	}

	public int getMaxAllowedErrors()
	{
		return MAX_ALLOWED_ERRORS;
	}

	public GameState getGameState()
	{
		return gameState;
	}

	public DataSource getDataSource()
	{
		return dataSource;
	}

	/* setters */

	public void setMaxAllowedErrors(int max)
	{
		MAX_ALLOWED_ERRORS = max;
	}

	public void setDataSource(DataSource newDataSource)
	{
		dataSource = newDataSource;
	}

}