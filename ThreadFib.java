package cop2805;

import java.util.Scanner;

public class ThreadFib{
	
	
	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  
		  System.out.println("How many numbers would you like to calculate to?");
		  int n = scanner.nextInt();
		DynamicFib fn = new DynamicFib();
		RecursiveFib rn = new RecursiveFib();
		fn.run(n);
		rn.run(n);
		
	}
	
	static class DynamicFib extends Thread {
		 public int calculate(int n) {
			  
			  int x = 0;
			  int y = 1;
			  int z = 0;
			  for(int i = 2; i <=n; i++)
			  {
				 z = x + y;
				 x = y;
				 y = z;
			  }
			  return z;
			  
			  
		  }
		  public void run(int n)
		  {
			  
			  long startTime = System.currentTimeMillis();
			  int result = calculate(n);
			  long endTime = System.currentTimeMillis();
			  System.out.println("Dynamic Thread found the answer: " + result + " in " + (endTime - startTime));
			  
		  }
		
	}
	static class RecursiveFib extends Thread {
		public int calculate(int n) {
			  if(n == 0)
			  {
				  return 0;
			  }
			  if(n == 1)
			  {
				  return 1;
			  }
			  return calculate(n-1) + calculate(n-2);
			  
		  }
		  public void run(int n)
		  {
			  
			  long startTime = System.currentTimeMillis();
			  int result = calculate(n);
			  long endTime = System.currentTimeMillis();
			  System.out.println("Recursive Thread found the answer: " + result + " in " + (endTime - startTime));
			  
		  }
		  
	}
}
	




	
	
