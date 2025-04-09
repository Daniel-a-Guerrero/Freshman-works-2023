import java.util.*;
public class Func
{
public static void main(String[] args)
{
ArrayList<String> w1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
ArrayList<String> w2 = w1;
ArrayList<String> w3 = new ArrayList<>(w1);
f(w1);
System.out.println(w1);
System.out.println(w2);
System.out.println(w3);
}
static void f(ArrayList<String> w)
{
w.set(0, "C++");
}
}
