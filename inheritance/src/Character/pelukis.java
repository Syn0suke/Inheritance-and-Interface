package Character;

import Interface.IArtist;
import Interface.IWorker;

public class pelukis extends BaseCharacter implements IArtist, IWorker{

	public pelukis() {
		super("Pelukis","Seseorang yang bisa melukis dan bekerja");
	}

	@Override
	public void work() {
		System.out.println(getName() + " bekerja");
		
	}

	@Override
	public void paint() {
		System.out.println(getName() + " melukis");
		
	}

}
