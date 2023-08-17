import java.util.Scanner;
public class MainClass {
public static void main(String args[]){ 
Scanner _key = new Scanner (System.in);
Double  a;
Double  n1;
Double  n2;
String  t1;
String  t2;
System.out.println("Digite T1");
t1= _key.nextLine();
System.out.println(t1);
t1 = "Hello World";
n1 = 1.0;
n2 = (double)10;
System.out.println("Digite n1");
n1= _key.nextDouble();
if (n2>(n1+100)) {
System.out.println("n2 maior que n1");
}
else {
System.out.println("n1 maior que n2");
}
System.out.println("----While----");
while ((n2-1)>0) { 
System.out.print(n2);
System.out.print(" ");
n2 = n2-1;
};
System.out.println("\n----Do While----");
n2 = (double)20;
do {
System.out.print(n2);
System.out.print(" ");
n2 = n2-2;
} while (n2>0);
System.out.println("\n----For----");
for(n2 = (double)0; n2<5; n2 = n2+1) {
System.out.print("A-");
};

}
}
