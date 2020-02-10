import java.util.ArrayList;
import java.util.Scanner;

public class AlphaCode {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        String s = sc.nextLine();
        while(!s.equals("0")){
            al.add(s);
            s = sc.nextLine();
        }

        for(int i = 0;i < al.size(); i++){
            String str = al.get(i);
            int a[] = new int[str.length()+1];
            a[0]=1;
            a[1]=1;

            for(int j=2; j<=str.length() ;j++){
                int x = 1000000000 + 7;
                if(str.charAt(j-1) != '0')
                    a[j]= (a[j] % x + a[j-1] % x) %x;
                int k = Integer.parseInt(str.substring(j-2,j));
                if(k<=26 && k>=10)
                    a[j] = (a[j]%x + a[j-2]%x) % x;
            }
            System.out.println(a[str.length()]);
        }

    }

}
