import java.util.Random;
public class TestArrays
{

   public static String numberFreq()
   {
      Random r=new Random();
      int[] list=new int[11];
      String amon="";
      int q=0;
      for(int i=0;i<1000;i++)
      {
         q=r.nextInt(11);
         if(q==0)
            list[0]++;
         else if(q==1)
            list[1]++;
         else if(q==2)
            list[2]++;
         else if(q==3)
            list[3]++;
         else if(q==4)
            list[4]++;
         else if(q==5)
            list[5]++;
         else if(q==6)
            list[6]++;
         else if(q==7)
            list[7]++;
         else if(q==8)
            list[8]++;
         else if(q==9)
            list[9]++;
         else if(q==10)
            list[10]++;
      }
      amon=list[0]+"\t"+list[1]+"\t"+list[2]+"\t"+list[3]+"\t"+list[4]+"\t"+list[5]+"\t"+list[6]+"\t"+list[7]+"\t"+list[8]+"\t"+list[9]+"\t"+list[10]+"\t";
      return amon;
   }
   
   public static String fibo(int total)
   {
      int[] tt=new int[total];
      int i=0;
      String st="";
      int x=2;
      if(total>0)
      tt[0]=1;
      if(total>1)
      tt[1]=2;
      while(x<total)
      {
         tt[x]=tt[x-1]+tt[x-2];
         x++;
      }
      while (i<total)
      {
         st+=tt[i]+"\t";
         i++;
      }
      return st;
   }
   
   public static int oddDice(Die[] dice)
   {
      int ret=0;
      for (Die thisDie:dice)
      {
         thisDie.roll();
         if(thisDie.getFaceValue()%2==1)
            ret++;
      }
      return ret;
   }
   
   public static void main(String[] args)
   {
      System.out.println(numberFreq());
      System.out.println(fibo(5));
      Die iram[]=new Die[4];iram[0]=new Die();iram[1]=new Die();iram[2]=new Die();iram[3]=new Die();
      System.out.println(oddDice(iram));
   }
   
}