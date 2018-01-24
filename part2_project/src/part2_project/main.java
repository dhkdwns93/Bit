package part2_project;

public class main {
	public static void main(String[] args) {
		int val=5;
		for(int i= 1; i<=val ; i++){
			for(int j=i ; j>=1 ; j--){
				System.out.print(" ");
			}
			for(int k=1 ;k<=i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}
}
