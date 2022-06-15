import java.util.*;
import java.lang.*;
import java.io.*;

class PotatoHunter
{
	public static int countPotatoes(char[][] farm, int x, int y,int r,int c, int counter) {
		farm[x][y] = 'F';
		if(y+1 < c && farm[x][y+1] == '-'){
			counter = countPotatoes(farm, x, y + 1, r, c, counter);
		}
		else{
			if(y+1 == c){
				counter += 1;
			}
			else{
				if(farm[x][y+1] == '*'){
					counter += 1;
				}
			}
		}
		if(x+1 < r && farm[x+1][y] == '-'){
			counter = countPotatoes(farm, x+1, y, r, c, counter);
		}
		else{
			if(x+1 == r){
				counter += 1;
			}
			else{
				if(farm[x+1][y] == '*'){
					counter += 1;
				}
			}
		}
		if(x-1 >= 0 && farm[x-1][y] == '-'){
			counter = countPotatoes(farm, x-1, y, r, c, counter);
		}
		else{
			if(x-1 == -1){
				counter += 1;
			}
			else{
				if(farm[x-1][y] == '*'){
					counter += 1;
				}
			}
		}
		if(y-1 >= 0 && farm[x][y-1] == '-'){
			counter = countPotatoes(farm, x, y-1, r, c, counter);
		}
		else{
			if(y-1 == -1){
				counter += 1;
			}
			else{
				if(farm[x][y-1] == '*'){
					counter += 1;
				}
			}
		}
		return counter;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int r, c, p;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		r = Integer.parseInt(reader.readLine());
		c = Integer.parseInt(reader.readLine());
		
		char[][] farm = new char[r][c];
		for (int i = 0; i < r; i++) {
			farm[i] = reader.readLine().toCharArray();
		}
		
		p = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < p; i++) {
			String[] line = reader.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int counter = 0;//
			Integer result = countPotatoes(farm,x-1,y-1, r, c, counter);
			System.out.println(result.toString());
		}
	
	}
}
