public class PrintNumbers {
	public static void print(int n){
		if(n == 1){
			System.out.print(n + " ");
		}
		else if (n > 1){
			print(n - 1);
			System.out.print(n + " ");
			
		}
		else {
			return;
		}
	}
	
	public static void main(String[] args) {
		print(6);
	}
}
