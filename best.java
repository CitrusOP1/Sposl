import java.util.*;
public class best {
    public static void main(String[] args) {
        System.out.println("enter proc size ");
        int p;
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        System.out.println("enter bloc size ");
        int b = sc.nextInt();
        int pr[] = new int[p];
        int bl[] = new int[b];
        for(int i=0;i<p;++i){
            pr[i]=sc.nextInt();
        }
        for(int i=0;i<b;++i){
            bl[i]=sc.nextInt();
        }
        int flag;
        for(int i=0;i<p;++i){
            flag = 0;
            int min=-1;
            int first = 0;
            for(int j=0;j<b;++j){
                if(pr[i]<=bl[j]&& first ==0){
                    min = j;
                    flag = 1;
                    first = 1;
                }
                if(pr[i]<=bl[j] && bl[j]<bl[min]){
                    min = j;
                    flag = 1;
                }
            }
            if(flag ==1){
                System.out.println(pr[i]+"allocated at "+bl[min]);
                bl[min]=0;
            }else if(flag==-1){
                System.out.println("memory not allocated for "+pr[i]);
            }
        }
    }
}
