public class compareDie{
public static void main (String[] args){
   Die a,b,c,d;
   a=new Die();
   b=new Die();
   c=new Die();
   a.roll();
   System.out.println("Die a: "+a);
   b.roll();
   System.out.println("Die b: "+b);
   c.roll();
   System.out.println("Die c: "+c);
   d=Compare3.largest(a,b,c);
   System.out.println(d);
}
}