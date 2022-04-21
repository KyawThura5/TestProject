package test;

import java.util.Scanner;
public class Test1 {
	public static void main(String args[]) {
		System.out.println("Enter Rectangle width:");
		int w=Getdata();
		System.out.println("Enter Rectangle length:");
		int l=Getdata();
		
		//Calling Class And Method
		Rectangle R=new Rectangle(w,l);
		 int area=R.GetArea();
		System.out.println("Rectangle Area is:"+area);
		
		//Using Controlstatement
		if(area<10) {
			System.out.println("Your Rectangle is so small!");
		}
	    else if(area>=10 && area<=50){
			System.out.println("Your Rectangle is suitable for use!");
		}
	    else {
	    	System.out.println("Your Rectangle is so big!");
	    }
	}
	//Using userdefined methos//
	public static int Getdata() {
		Scanner sc=new Scanner(System.in);
		return sc.nextInt();
	}
	public static String GetString() {
		Scanner sc1=new Scanner(System.in);
		return sc1.nextLine();
	}
	}

	//Create Class//
	class Rectangle
	{
		private int width;
		int length;
		
		//Constructor//
		public Rectangle(int w,int l) 
	{
			width=w;length=l;
	}
	public int GetArea() {
		return width*length;
	}
}
