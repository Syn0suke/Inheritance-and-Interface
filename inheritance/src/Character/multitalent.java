package Character;

import Interface.IWorker;
import Interface.IDriver;
import Interface.IChef;
import Interface.IArtist;

public class multitalent extends BaseCharacter implements IWorker, IDriver, IChef, IArtist{

	public multitalent() {
		super("Multitalent","Seseorang yang bisa menyetir, memasak, melukis dan bekerja");
	}

	@Override
	public void paint() {
		System.out.println(getName() + " melukis");
		
	}

	@Override
	public void cook() {
		System.out.println(getName() + " memasak");
		
	}

	@Override
	public void drive() {
		System.out.println(getName() + " menyetir");
		
	}

	@Override
	public void work() {
		System.out.println(getName() + " bekerja");
		
	}

}
