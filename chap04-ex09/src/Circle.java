
public class Circle {
int radius;
String name;
private Object dount;

public Circle(){
	
	
}

public double getArea(){
	return 3.14 * radius * radius;
	
}

public static void main(String[]args){
	Circle pizza;
	pizza = new Circle();
	pizza.radius = 5;
	pizza.name = "å������";
	double area = pizza.getArea();
	System.out.println(pizza.name + "�� ����"+ area);
	
	Circle donut = new Circle();
	donut.radius = 3;
	donut.name = "�Ӹ�";
	area = donut.getArea();
	System.out.println(donut.name+ "�� ����");
	
}
}