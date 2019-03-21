
public class circle {
	int radius;
	String name;
	
	public circle(){
		radius = 1;
		name = " ";
	}
	public circle(int r, String n) {
		radius = r;
		name = n;
	}
	public double getArea() {
		return 3.14* radius * radius;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circle pizza = new circle(10, "책을피자");
		double area = pizza 

	}

}
