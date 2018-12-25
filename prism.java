Bing
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class prism {

 public static class Myclass implements Comparator{
  int v;
  int s;
  int w;
  public Myclass(int v,int s, int w) {
    this.v = v;
    this.s = s;
    this.w = w;
  }

  @Override
  public int compare(Object e1, Object e2) {
    return ((Myclass)e1).w - ((Myclass)e2).w;
  }

}
public static void main(String[] args)
{

/*i am creating 2 different arraylist, one to keep values of vertices included in MST , one to keep values of ones not included*/
  ArrayList<Integer> a1=new ArrayList<Integer>();
  ArrayList<Integer> a2=new ArrayList<Integer>();

  System.out.println("Enter the number of vertices:");
  Scanner sc=new Scanner(System.in);
  int a=sc.nextInt();
  System.out.println("Enter the integer value of all vertices:");
  int arr[]=new int[a];
  for(int i=0;i<a;i++)
  {
    a1.add(i);
  }
  System.out.println("Select a particular vertex");
  int ver=sc.nextInt();
  a2.add(ver);
  int dist[][]=new int[a][a];
  int[][] result = new int[a][a];
  System.out.println("Enter the distance of vertex 0 to 0, 0 to 1, 0 to 2 and so on, for distance from 0 to 0 ,1 to 1 enter 9999 ");
  for(int i=0;i<a;i++)
  {
   for(int j=0;j<a;j++)
   {
     dist[i][j]=sc.nextInt();
     result[i][j] = 99999999;
   }
 }
/*The distance between 2 different vertices is stored*/

 for(int i=0;i<a;i++)
 {
  System.out.println(Arrays.toString(dist[i]));

}

PriorityQueue <Myclass> a3=new PriorityQueue<>(a,new Comparator<Myclass>() {
  @Override
  public int compare(Myclass o1, Myclass o2) {
    Myclass first =o1;
    Myclass second = o2;

    if(first.w<second.w)return -1;
    else if(first.w>second.w)return 1;
    else return 0;
  }
});

a1.remove(a1.indexOf(ver));
int x = ver;

int count = 0;
while( !a1.isEmpty())
{
  for(int j =0;j<a;j++)
    if(!a2.contains(j) && dist[x][j] < 9999){
      a3.add(new Myclass(j,x,dist[x][j]));


  }


  Myclass c = a3.poll();

 // while(!a2.contains(c.v)){
  //  c = a3.poll();
  //}
  x = c.v;
  int ver1 =c.s;
  System.out.println(ver1+"  "+x+"  :  "+c.w);
  count++;
  a2.add(x);
  a1.remove(a1.indexOf(x));


}

}



}
