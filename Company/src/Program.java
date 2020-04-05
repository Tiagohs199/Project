import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.print("Enter department's name: ");
		String nameDepar =sc.next();
		
		System.out.println("Enter worker data: ");
		System.out.print("name: ");
		String name = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		
		System.out.print("Base salary: ");
		Double BaseSalary =sc.nextDouble();
		
		Worker worker = new Worker(name,BaseSalary,WorkerLevel.valueOf(level), new Department(nameDepar));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=0;n>i;i++) {
			System.out.println("enter contract #"+i+1+"data:");
			System.out.print("Date (dd/MM/yyyy): ");
			Date contractDate =sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double PerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int Hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate,PerHour,Hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and Year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();	
		int month =Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.printf("Name: %s%n",worker.getName());
		System.out.printf("Department: %s%n", worker.getDepartment().getName());
		System.out.printf("Income for %s: %.2f",monthAndYear,worker.income(month, year));
		
		
		sc.close();
	}
}
