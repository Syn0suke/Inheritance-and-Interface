package Character;

import Interface.IDriver;
import Interface.IWorker;

public class supir extends BaseCharacter implements IDriver, IWorker{

	public supir() {
		super("Supir","Seseorang yang bisa menyetir dan bekerja");
	}

	@Override
	public void work() {
		System.out.println(getName() + " bekerja");
		
	}

	@Override
	public void drive() {
		System.out.println(getName() + " menyetir");
		
	}

}
