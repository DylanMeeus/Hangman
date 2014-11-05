package net.itca.core.interfaces;

import net.itca.core.interfaces.Observer;

public interface Observable
{
	public void RegisterObserver(Observer o);
	public void RemoveObserver(Observer o);
	public void notifyObservers();
}
