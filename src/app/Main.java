package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
				
				// verificar se o ID j� foi digitado
				// Fa�a enquanto hasId (id que est� na lista) for diferente do Id digitado)
				while (hasId(list, id)){
					System.out.print("Id alread taken!! try again: ");
					id = sc.nextInt();
				}
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int idsalary = sc.nextInt();
		
		
		// aqui pode-se usar 2 op��es... a primeira cria-se uma fun��o chamada positio
		
		//Integer pos = position(list, idsalary);
		
		// essa op��o criar uma express�o lambda.
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This Id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.IncreaseSalary(percent);
		}
			
		System.out.println();
		System.out.println("List of Employee");
		
		for (Employee e : list) {
		System.out.println(e);				
		}
		
		sc.close();
	}

	// ESSA FUN��O IR� PROCURAR O ID DO FUNCION�RIO E COMPARAR COM O ID DIGITADO
	// SE ENCONTRAR IR� RETORNAR A POSI��O I, QUE � A POSI��O ONDE EST� SALVO
	// tem que usar static pois o Main � static
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// Criando uma fun��o para retornar se o ID j� existe, se j� foi digitado
	
	public static boolean hasId(List<Employee>list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
