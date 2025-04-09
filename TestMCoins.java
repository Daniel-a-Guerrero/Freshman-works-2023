public class TestMCoins{
public static void main(String[] args){
   MonetaryCoin[][] mc=new MonetaryCoin[3][10];
   for(int i=0;i<3;i++){
      for(int j=0;j<10;j++){
         mc[i][j]=new MonetaryCoin((int)(Math.random()*100+1));}}
   for(int i=0;i<3;i++){int nH=0;
      for(int j=0;j<10;j++){
         mc[i][j].flip();
         if(mc[i][j].isHeads()) nH+=mc[i][j].getVIC();}
      System.out.println("All heads in row value: "+nH);
   }
}}