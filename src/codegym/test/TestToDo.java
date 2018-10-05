package codegym.test;

import codegym.todo.Entry;
import codegym.todo.ToDoList;

import java.util.Scanner;

public class TestToDo {
    public static void main(String[] args){
        ToDoList toDoList = new ToDoList();
        System.out.println("Input");
        toDoList = inputEntry(toDoList);
        toDoList.showToDoList();

        System.out.println("After sort: ");
        toDoList.sortList();
        toDoList.showToDoList();

        System.out.println("Drop entry");
        dropEntry(toDoList);

        System.out.println("Get entry by id");
        displayEntryById(toDoList);
    }

    public static ToDoList inputEntry(ToDoList toDoList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the amount of entry: ");
        int amount = scanner.nextInt();
        for(int i = 0; i < amount; i++){
            System.out.print("Input the priority: ");
            int priority = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Input the notes: ");
            String notes = scanner.nextLine();
            System.out.println("1:yes");
            System.out.println("2:no");
            System.out.print("Do you want to add this entry(yes/no): ");
            int choice = scanner.nextInt();
            if(choice == 1) {
                toDoList.addEntry(new Entry(priority, notes));
            }else{
                inputEntry(toDoList);
            }
        }
        return toDoList;
    }

    public static void dropEntry(ToDoList toDoList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        int id = scanner.nextInt();

        if(toDoList.removeEntry(id)){
            System.out.println("Entry deleted");
        }else{
            System.out.println("False");
        }
    }

    public static void displayEntryById(ToDoList toDoList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        int id = scanner.nextInt();

        if(toDoList.getEntryById(id)!=null){
            System.out.println("Entry: "+toDoList.getEntryById(id).getPriority()+", "+toDoList.getEntryById(id));
        }else{
            System.out.println("False");
        }
    }
}
