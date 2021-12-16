package assignment6CS176;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class worldPop {
public static void main(String[] args)throws FileNotFoundException {
		
	ArrayList <Long> population= new ArrayList<>();
	ArrayList <Float> area= new ArrayList<>();
	ArrayList <String> countries= new ArrayList<>();
	
	File inputFile = new File("WorldPopulation");
Scanner in = new Scanner(inputFile);
	File inputArea = new File("WorldArea");
Scanner inArea = new Scanner(inputArea);

PrintWriter output = new PrintWriter("WorldDensity");
		
while (in.hasNextLine()) {
	String s=in.nextLine();
	String num="";
for(int i=0;i<s.length();i++) {
	char c =s.charAt(i);
	if(Character.isDigit(c)) {
					num+=c;
}
}
	String name="";
	for(int i=0;i<s.length();i++) {
	char c =s.charAt(i);
		if(!Character.isDigit(c)) {
			name+=c;
}
}
countries.add(name);
long pop= Long.parseLong(num);
population.add(pop);

}	
while (inArea.hasNextLine()) {
	String s=inArea.nextLine();
	String num="";
	for(int i=0;i<s.length();i++) {
	char c =s.charAt(i);
		if(Character.isDigit(c)) {
			num+=c;
}
}
float ar=Float.parseFloat(num);
	area.add(ar);
}

for(int i=0;i<population.size();i++) {
float atLast = population.get(i)/area.get(i);
output.println(countries.get(i) + atLast );
}
		inArea.close();
		in.close();
		output.close();
}
}

