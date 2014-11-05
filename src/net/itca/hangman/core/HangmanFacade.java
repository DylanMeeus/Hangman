package net.itca.hangman.core;

import java.util.ArrayList;
import java.util.List;

import net.itca.core.interfaces.DataSource;
import net.itca.core.interfaces.Observer;

/**
 * 
 * @author Dylan Class the controller can talk to.
 */
public class HangmanFacade
{
	private Hangman game;
	private DataSource dataSource;

	public HangmanFacade()
	{
		game = new Hangman();
		
	}
	
	public void setWordCharacters(char[] _wordCharacters)
	{
		game.setWordCharacters(_wordCharacters);
	}
	
	public void setErrors(int errors)
	{
		game.setErrors(errors);
	}
	
	public void setGameState(GameState state)
	{
		game.setGameState(state);
	}
	
	public void setTheme(String theme)
	{
		
		dataSource.setTheme(theme);
	}

	public void startGame(Theme theme)
	{
		game.start();
	}

	public void setDataSource(DataSource data)
	{
		dataSource = data;
		
	}
	
	public void setMaxAllowedErrors(int max)
	{
		game.setMaxAllowedErrors(max);
	}
	
	public void checkInput(char inputCharacter)
	{
		game.checkInput(inputCharacter);
	}
	
	public void RemoveObserver(Observer o)
	{
		game.RemoveObserver(o);
	}
	

	public void start()
	{
		game.setDataSource(dataSource);
		
		game.start();
	}

	public void RegisterObserver(Observer observer)
	{
		game.RegisterObserver(observer);
	}

	/* GETTERS */
	public String getUncoveredWord()
	{
		return game.getUncoveredWord();
	}

	public int getErrors()
	{
		return game.getErrors();
	}

	public List<String> getThemes()
	{
		return dataSource.getThemes();
	}
	
	public GameState getGameState()
	{
		return game.getGameState();
	}

	public DataSource getDataSource()
	{
		return game.getDataSource();
	}
	
	public int getMaxAllowedErrors()
	{
		return game.getMaxAllowedErrors();
	}
	
	public ArrayList<Observer> getObservers()
	{
		return game.getObservers();
	}
	
	public char[] getWordCharacter()
	{
		return game.getWordCharacter();
	}
}
