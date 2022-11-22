import java.util.*;
public class TestJNI{
	static{
		System.loadLibrary("cal");	
	}
	private native int add(int n1,int n2);
	private native int sub(int n3,int n4);
	private native int mul(int n5,int n6);
	private native int div(int n7,int n8);
	public static void main(String[] args){
		int ch;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("********************");
			System.out.println("*    1.Addition    *");
			System.out.println("*   2.subtraction  *");
			System.out.println("* 3.Multiplication *");
			System.out.println("*   4.Division     *");
			System.out.println("*     5.Exit       *");
			System.out.println("********************");
			System.out.print("\nEnter Your Choice :");
			ch = input.nextInt();
			System.out.println("\n");
			TestJNI obj = new TestJNI();
			switch(ch){
				case 1:
					System.out.print("Enter 1st Number :");
					int n1 = input.nextInt();
					System.out.print("Enter 2nd Number :");
					int n2 = input.nextInt();
					System.out.println("--------------------" );
					System.out.println("|Addition is = " + obj.add(n1,n2)+"|");
					System.out.println("--------------------" );
					break;		
				case 2:
					System.out.print("Enter 1st Number :");
					int n3 = input.nextInt();
					System.out.print("Enter 2nd Number :");
					int n4 = input.nextInt();
					System.out.println("--------------------" );
					System.out.println("|Subtractoin is = " + obj.sub(n3,n4)+"|");
					System.out.println("--------------------" );
					break;
				case 3:
					System.out.print("Enter 1st Number :");
					int n5 = input.nextInt();
					System.out.print("Enter 2nd Number :");
					int n6 = input.nextInt();
					System.out.println("--------------------" );
					System.out.println("|Multiplication is = " + obj.mul(n5,n6)+"|");
					System.out.println("--------------------" );
					break;
				case 4:	
					System.out.print("Enter 1st Number :");
					int n7 = input.nextInt();
					System.out.print("Enter 2nd Number :");
					int n8 = input.nextInt();			
					System.out.println("--------------------" );
					System.out.println("|Division is = " + obj.div(n7,n8)+"|");
					System.out.println("--------------------" );
					break;
					
				case 5:
					break;	
				
				default:
					System.out.println("--------------------" );
					System.out.println(" Oops!Wrong Choice" );
					System.out.println("--------------------" );
			}
		}while(ch!=5);
	}
}
