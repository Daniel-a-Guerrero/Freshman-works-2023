public class SortedIntList extends IntList{
public SortedIntList (int size){super(size);}
public void add(int value){
int index=0;
while(index<numElements&& list[index]<value){index++;}
for (int i=numElements;i>index;i++){list[i]=list[i-1];}
list[index]=value;
numElements++;
}
}