package test;

import inter.ClickEmmiter;

public class Day4 implements ClickEmmiter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Girl g=new Girl();
		System.out.println(g.name);
		g.getParent();
			
		Boy b=new Boy();
		System.out.println(b.name);
		b.getParent();
		
		//Using interface
		System.out.println(ClickEmmiter.name);
		Action act=new Action(new Day4());
		act.show();
		
	}
	
	public void emit(String data) {
		System.out.println(data);
	}

}
class Student{
	int age;
	public void getParent() {
		System.out.println(" My parents are U Mya and Daw Hla!My brother is Mg Mg!");
		
	}
}

class Boy extends Student{
	public String name="Mg Mg";
	String toursercolor;
	//Using Override
    public void getParent() {
		System.out.println("Yes they are my family!");
	}
}

    //Using inheritance
class Girl extends Student{
	public String name="Kyi Kyi";
	String skirtcolor;
}
class Action{
	ClickEmmiter emitter;
	public Action(ClickEmmiter emitter) {
		this.emitter=emitter;
	}
	public void show() {
		emitter.emit("They are so Kind!");
	}
}

