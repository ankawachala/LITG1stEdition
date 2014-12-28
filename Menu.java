import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		int i;
		List<String> TabWhat = new ArrayList<String>();
		List<String> TabWhen = new ArrayList<String>();
		List<String> TabWhere = new ArrayList<String>();
		List<String> TabHowMuch = new ArrayList<String>();
		do{
			System.out.println(" ");
			System.out.println("Hello :-)");
			System.out.println("To write what you bought - press 1");
			System.out.println("To see what you bought - press 2");
			System.out.println("To exit this application - press 3");
			Scanner s=new Scanner(System.in);
			i=s.nextInt();
				if(i==1){
					System.out.println("Please type in what did you buy and then press Enter");
					String k=s.next();
					TabWhat.add(k);
					System.out.println("Please type in when did you buy it and then press Enter");
					String l=s.next();
					TabWhen.add(l);
					System.out.println("Please type in where did you buy it and then press Enter");
					String m=s.next();
					TabWhere.add(m);
					System.out.println("Please type in how much PLN money did it cost and then press Enter");
					String n=s.next();
					TabHowMuch.add(n);
					}
				else if(i==2){
					System.out.println("You bought:");
					for(int a=0; a<TabWhat.size(); a++){
					System.out.println(TabWhat.get(a)+" "+TabWhen.get(a)+" "+TabWhere.get(a)+" "+TabHowMuch.get(a));	
					}
				}
		}
		while(i!=3);
	}
}
