package net.itca.hangman.launcher;

import java.util.List;

import net.itca.hangman.core.HangmanFacade;
import net.itca.hangman.core.OfflineSource;
import net.itca.hangman.core.Theme;

public class Launcher
{
	public static void main(String[] args)
	{
		HangmanFacade game = new HangmanFacade();
		OfflineSource o = new OfflineSource();
		o.setTheme("ANIMALS");
		game.setDataSource(o);
		game.start();
		System.out.println(game.getUncoveredWord());
		game.checkInput('o');
		game.checkInput('e');
		game.checkInput('a');
		System.out.println(game.getUncoveredWord());
		
	}
}
