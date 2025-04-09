// ****************************************************************
// IntList.java
//
// An (unsorted) integer list class with a method to add an
// integer to the list and a toString method that returns the contents
// of the list with indices.
//
// ****************************************************************
public class IntList
{
protected int[] list;
protected int numElements = 0;
//-------------------------------------------------------------
// Constructor -- creates an integer list of a given size.
//-------------------------------------------------------------
public IntList(int size)
{
list = new int[size];
}
//------------------------------------------------------------
// Adds an integer to the list. If the list is full,
// prints a message and does nothing.
//------------------------------------------------------------
public void add(int value)
{
if (numElements == list.length)
 System.out.println("Can't add, list is full");
else
 {
list[numElements] = value;
numElements++;
}
}
//-------------------------------------------------------------
// Returns a string containing the elements of the list with their
// indices.
//-------------------------------------------------------------
public String toString()
{
String returnString = "";
for (int i=0; i<numElements; i++)
returnString += i + ": " + list[i] + "\n";
return returnString;
}
}
// ***************************************************************
// ListTest.java
//
// A simple test program that creates an IntList, puts some
// ints in it, and prints the list.
//
// ***************************************************************
public class ListTest
{
public static void main(String[] args)
{
IntList myList = new IntList(10);
myList.add(100);
myList.add(50);
myList.add(200);
myList.add(25);
System.out.println(myList);
}
}