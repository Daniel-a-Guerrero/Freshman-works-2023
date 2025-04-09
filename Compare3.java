import java.lang.*;
import java.util.*;
public class Compare3
{
   public static <T extends Comparable <T>> T largest(T a, T b, T c)
   {
      T max=a;
      if(b.compareTo(max)>0)
         max=b;
      if(c.compareTo(max)>0)
         max=c;
      return max;
   }
}