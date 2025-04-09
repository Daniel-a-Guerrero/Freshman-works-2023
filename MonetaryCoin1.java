public class MonetaryCoin1 extends Coin{
private int vic;
public MonetaryCoin(int vic){this.vic=vic;flip();}
public int getVIC(){return vic;}
public void getVIC(int vic){this.vic=vic;}
public String toString(){String faceName = super.toString();return "Value in cents: "+vic+"\nFace: "+faceName;}
}