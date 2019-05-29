package Character;

import Interface.IWorker;
import Interface.IChef;

public class resto extends BaseCharacter implements IChef, IWorker{

	public resto() {
		super("Resto","Seseorang yang bisa memasak dan bekerja");
	}

	@Override
	public void work() {
		System.out.println(getName() + " bekerja");
		
	}

	@Override
	public void cook() {
		System.out.println(getName() + " memasak");
		
	}

}
