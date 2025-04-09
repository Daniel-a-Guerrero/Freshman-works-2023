public class finalPlayground{
   public static void main (String[] args){
      String sfx="krork";
      System.out.println(add(5));
      int[] x = new int[5];
      int i;
      for (i = 0; i < x.length-1; i++)
         x[i] = i;
      System.out.println(x[i]);
      String[] t={"Gary","Barry","Larry","Mary","Jerry"};
      System.out.println(eStatistics(t)[4]);
   }
   public static int add(int num)
   {
      int result;
      if (num == 1)
         result = 1;
      else
         result = num + add(num-1);
      return result;
   }
public static int[] eStatistics(String[] names){
	int[] returner=new int[names.length];
   for(int i=0;i<names.length;i++){
	   int count=0;
	   for(int j=0;j<names[i].length();j++){
		   if(names[i].charAt(j)=='e')
			   count++;
         	}
      returner[i]=count;
      }
return returner;
}

}