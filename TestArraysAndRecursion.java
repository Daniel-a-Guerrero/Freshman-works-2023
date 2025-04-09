public class TestArraysAndRecursion {
	public static int salesRange(int sales[][]) {
		int range=0, high=sales[0][0], low=sales[0][0];
		for (int i=0;i<sales.length;i++) {
			for(int j=0;j<sales[i].length;j++) {
				if(sales[i][j]>high)
					high=sales[i][j];
				else if(sales[i][j]<low)
					low=sales[i][j];
			}
		}
		range=high-low;
		return range;
	}
	public static String dieStats(Die[][] dice)
	{
		int[] ra=new int[dice.length];
		for (int i=0;i<dice.length;i++) {
			for(int j=0;j<dice[i].length;j++) {
				dice[i][j].roll();
				if(dice[i][j].getFaceValue()%2==1)
               ra[i]++;
			}}
      String p="[";
      for (int i=0;i<dice.length-1;i++)
      {
         p+=(ra[i]+",");
      }
      p+=(ra[dice.length-1]+"]");
		return p;
	}
 public static String printDigits(int nom)
   {
      double num=nom*1.0;
      String o="";
      double up=1.0;
      if(num>=10){
      do
         {up*=10;}
      while((num/up)>=10);
      o+=((int)(num/up)+"\n"+printDigits((nom-((int)num/(int)up)*(int)up)));
      }
      else
      o+=(nom);
      return o;
   }
	public static int prodArray(int[] numArray, int count) {
      int product=1;
      if(count>=1){
         product=numArray[count-1]*prodArray(numArray, count-1);
      }
      else if(count==0)
         product*=numArray[0];
      return product;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(printDigits(8855));
      int[][] de={{0,1,2,3},{0,1,2,3},{0,1,2,3}};
      System.out.println(salesRange(de));
      Die[][] dd={{new Die(), new Die(), new Die()},{new Die(), new Die(), new Die()}};
      System.out.println(dieStats(dd));
      System.out.println(printDigits(3125));
      int[] t={1,1,2,4};
      int ct=4;
      System.out.println(prodArray(t,ct));
	}

}

