package Character;

import Interface.IChef;

public class koki extends BaseCharacter implements IChef{

	public koki() {
		super("Koki","Seseorang yang bisa memasak");
	}

	@Override
	public void cook() {
		System.out.println(getName() + " memasak");
		
	}

}
