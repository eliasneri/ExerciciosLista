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
				
				// verificar se o ID já foi digitado
				// Faça enquanto hasId (id que está na lista) for diferente do Id digitado)
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
		
		
		// aqui pode-se usar 2 opções... a primeira cria-se uma função chamada positio
		
		//Integer pos = position(list, idsalary);
		
		// essa opção criar uma expressão lambda.
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

	// ESSA FUNÇÃO IRÁ PROCURAR O ID DO FUNCIONÁRIO E COMPARAR COM O ID DIGITADO
	// SE ENCONTRAR IRÁ RETORNAR A POSIÇÃO I, QUE É A POSIÇÃO ONDE ESTÁ SALVO
	// tem que usar static pois o Main é static
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// Criando uma função para retornar se o ID já existe, se já foi digitado
	
	public static boolean hasId(List<Employee>list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
