import java.util.Scanner;

public class Lab1Review {
	Scanner input;
	
	public void run()
	{
		input = new Scanner(System.in);
		while(input.hasNext())
		{
			String word = input.next().trim().toLowerCase().replaceAll("[^a-z]", "");
			if(word.length() > 0)
			{
				System.out.println(word);
			}
		}
		System.out.println("End of stream detected. Terminating the program.");
	}
	
	public static void main(String[] args)
	{
		Lab1Review lab1 = new Lab1Review();
		lab1.run();
	}

}
