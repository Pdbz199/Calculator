import java.util.Scanner;
import java.util.ArrayList;

public class Calc {
	double num1;
	double num2;
	double num3;
	
	public Calc(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
		num3 = Double.NaN;
	}
	
	public Calc(double num1, double num2, double num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	
	public double maxInt() {
		double max = 0;
		if (Double.isNaN(num3)) {
			if (num2 > num1) {
				return num2;
			}
			return num1;
		}
		else {
			if (num1 > max) {
				max = num1;
			}
			if (num2 > max) {
				max = num2;
			}
			if (num3 > max) {
				max = num3;
			}
		}
		return max;
	}
	
	public double minInt() {
		double min = num2;
		if (Double.isNaN(num3)) {
			if (num2 > num1) {
				return num2;
			}
			return num1;
		}
		if (num1 < min) {
			min = num1;
		}
		if (num3 < min) {
			min = num3;
		}
		return min;
	}
	
	public double add() {
		if (Double.isNaN(num3)) {
			return num1 + num2;
		}
		return num1 + num2 + num3;
	}
	
	public double multiply() {
		if (Double.isNaN(num3)) {
			return num1 * num2;
		}
		return num1 * num2 * num3;
	}
	
	public double subtract() {
		if (Double.isNaN(num3)) {
			return num1 - num2;
		}
		return num1 - num2 - num3;
	}
	
	public double divide() {
		if (Double.isNaN(num3)) {
			return num1 / num2;
		}
		return num1 / num2 / num3;
	}
	
	public double gcf() {
		double gcf = 1;
		if (Double.isNaN(num3)) {
			for (double i = this.minInt(); i > 1; i-=0.01) {
				if (num1 % i == 0.0 && num2 % i == 0.0) {
					gcf = i;
				}
			}
		}
		else {
			for (double i = this.minInt(); i > 1; i-=0.01) {
				if (num1 % i == 0.0 && num2 % i == 0.0 && num3 % i == 0) {
					gcf = i;
				}
			}
		}
		return gcf;
	}
	
	public double lcm() {
		double lcm;
		if (Double.isNaN(num3)) {
			lcm = num1 * num2;
			for (double i = 100; i > 1; i-=0.01) {
				if (i % num1 == 0 && i % num2 == 0) {
					lcm = i;
				}
			}
		}
		else {
			lcm = num1 * num2 * num3;
			for (double i = 100; i > 1; i-=0.01) {
				if (i % num1 == 0 && i % num2 == 0 && i % num3 == 0) {
					lcm = i;
				}
			}
		}
		return lcm;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		Calc calc = new Calc(num1, num2, num3);
		System.out.println("Largest number: " + calc.maxInt());
		System.out.println("Smallest number: " + calc.minInt());
		System.out.println("Added: " + calc.add());
		System.out.println("Subtracted: " + calc.subtract());
		System.out.println("Multiplied: " + calc.multiply());
		System.out.println("Divided: " + calc.divide());
		System.out.println("GCF: " + calc.gcf());
		System.out.println("LCM: " + calc.lcm());
	}
}
