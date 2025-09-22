import java.util.*;
class eb{
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter consumer name: ");
    String name=sc.nextLine();
    System.out.println("Enter consumer no: ");
    int no=sc.nextInt();
    System.out.println("Enter previous month reading: ");
    int p=sc.nextInt();
    System.out.println("Enter current month reading: ");
    int c=sc.nextInt();
    System.out.println("Enter (Domestic/consumer)-(1/2): ");
    int cd=sc.nextInt();
    int u=c-p;
    if(cd==1)
    {
        if(u<=100)
        {
        System.out.println(u*1);
        }
        
        else if(u>100 && u<=200)
        {
        double d=u*2.50;
        System.out.println(d);
        }
        else if(u>200 && u<=500)
        {
        
        System.out.println(u*4);
        }
        else
        {
        System.out.println(u*6);
        }
    }        

if(cd==2)
    {
        if(u<=100)
        {
        System.out.println(u*2);
        }
        
        else if(u>100 && u<=200)
        {
        double d=u*4.50;
        System.out.println(d);
        }
        else if(u>200 && u<=500)
        {
        
        System.out.println(u*6);
        }
        else
        {
        System.out.println(u*7);
        }
    } }     }    
