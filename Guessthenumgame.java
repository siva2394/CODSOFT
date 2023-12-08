package package1;
import java.util.Scanner;
import java.util.Random;
public class Guessthenumgame {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		System.out.println("The System guessed the number between 1 and 100 \n Find it in 10 tries");
		System.out.println("Guess the Number chose by the system:");
		int compnum=rand.nextInt(100);
		//System.out.println(compnum);
		int start=1;
		do
		{
			
		for(int i=1;i<=10;i+=1)
		{
			System.out.println("Enter your Number:");
			int a=sc.nextInt();
			if(a<compnum) 
			{
				System.out.println("Too Low");
			}
			else if(a>compnum)
			{
				System.out.println("Too High");
			}
			else if(a==compnum)
			{
				System.out.println("Guessed the Correct Number");
				System.out.println("Your score is "+(10-i+1)+" out of 10");
				break;
			}			
		}
		System.out.println("Do you want to try again? 1/0");
		start=sc.nextInt();
		}while(start==1);
		System.out.println("Thank you for playing this Game");
	}
}
