package net.itca.core.interfaces;

import java.util.List;

import net.itca.hangman.core.Theme;

/**
 * 
 * @author Dylan
 * Interface the provider for the word has to implement
 */
public interface DataSource
{
	public String getWord();
	public void setTheme(String theme);
	public List<String> getThemes();
}
