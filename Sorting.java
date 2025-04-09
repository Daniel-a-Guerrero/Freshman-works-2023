public class Sorting {
   public static void main (String[] args) {
      int[] sorted={100,12,53, 2};
      int n=sorted.length-1;
      for(int i=0;i<=n;i++) {
         int num=sorted[i];
         for(int j=i-1;j>=0;j--) {
            int ph=sorted[j];
            if(num<ph) {
               sorted[j+1]=ph;
               sorted[j]=num;
            }
         }
      }
      for(int i=0;i<=n;i++) {
         System.out.print(", "+sorted[i]);
      }
   }
}
