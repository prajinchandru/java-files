import java.util.*;
abstract class Shape{
double a,b;
double area;
abstract void printArea();
}
class Rectangle extends Shape{
   Rectangle(double length,double breath){
this.a=length;
this.b=breath;
}
void printArea(){
area=a*b;
System.out.print("Area of rectangle:"+area);
}
}
class Triangle extends Shape{
Triangle(double base,double heigth){
this.a=base;
this.b=heigth;
}
void printArea(){
area=0.5*a*b;
System.out.println("Area of triangle:"+area);
}
}
class Circle extends Shape{
Circle(double radius){
this.a=radius;
}
void printArea(){
area=3.14*a*a;
System.out.println("Area of circle:"+area);
}
}
public class Area{
public static void main(String[]args){
Scanner Sc=new Scanner(System.in);
while(true){
System.out.println("Enter shape:\n 1.Rectangle\n 2.Trianle\n 3.Circle\n 4.Exit");
int choice=Sc.nextInt();
switch(choice){
case 1:
   System.out.println("*********Rectangle*********");
   System.out.println("Enter the length:");
   double length=Sc.nextDouble();
   System.out.println("Enter the breath:");
   double breath=Sc.nextDouble();
   Shape rect=new Rectangle(length,breath);
   rect.printArea();
   break;
 case 2:
    System.out.println("**********Triangle**********");
    System.out.println("Enter the base:");
    double base =Sc.nextDouble();
    System.out.println("Enter the heigth:");
    double heigth=Sc.nextDouble();
    Shape tri=new Triangle(base,heigth);
    tri.printArea();
    break;
case 3:
    System.out.println("*********Circle*******");
    System.out.println("Enter the radius:");
    double radius=Sc.nextDouble();
    Shape cir=new Circle(radius);
    cir.printArea();
    break;
case 4:
    System.out.println("Exit program");
    Sc.close();
    return;
   default:
     System.out.println("invalid choice");
    }
   }
  }
 }
     
