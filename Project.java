package Project;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Project {
	
	public static void main(String[] args) {
		
        System.out.println("\tWelcome to File Handling \n");
        operationsSelection();
    }
    private static void operationsSelection() {
        String[] arr = {"1. Retrieving the file names in an ascending order",
                "2. Option to add a user specified file to the application",
                "   (i). Option to delete a user specified file from the application",
                "   (ii). Option to search a user specified file from the application",
                "   (iii). Navigation option to close the current execution context and return to the main context",
                "3. Option to close the application"               
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int k=0; k<slen;k++){
            System.out.println(arr[k]);
            // display the all the Strings mentioned in the String array
        }
        
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  operations =  sc.nextInt();
        for(int l=1;l<=slen;l++){
            if(operations==l){
                switch (operations){
                case 1:
                	
                	File file = new File("D:/files");
            		String[] files = file.list();
            		for(String string : files) {
            			//System.out.println(string);
            		}
            		System.out.println();
            		String str[] = files; 
            		String temp;
            		System.out.println("File names in sorted order:");
            		for (int j = 0; j < str.length; j++) {
            	   	   for (int i = j + 1; i < str.length; i++) {
            			// comparing adjacent strings
            			if (str[i].compareTo(str[j]) < 0) {
            				temp = str[j];
            				str[j] = str[i];
            				str[i] = temp;
            			}
            		   }
            		   System.out.println(str[j]);
            		  
            		}
            		break;
            		
                case 2:
                	System.out.println("This for Business level operations");
                	System.out.println("The operations are : (1)append,  (2)delete,  (3)search & (4)Exit");
                	
                	Scanner sc1=new Scanner(System.in);
                	System.out.println("Enter the operation you need to perform : ");
                	String str1 = sc1.nextLine();
                	switch (str1) {
                	case "append":
                		try {
							createFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                		break;
                		
                	case "delete":
                		deleteFile();
                		break;
                		
                	case "search":
                		searchFile();
                		break;
                		
                	case "Exit":
                		System.out.println("You were exit from the BLO.");
                		System.out.println("Navigate back to the main context.");
                		
                	default:
                		System.out.println("Please written the operation correctly...");
                	}  
                    System.out.println();
                	operationsSelection();		
                	break;
                    
                case 3:
                	closeApp();
                	break;
                default:
                	System.out.println("Invalid operation");
                    
               }
            }
        }
                	
		
        
}
	private static void closeApp() {
		
		System.out.println("Closing your application... \nThank you!!!");
		
	}
	private static void searchFile() {
			File files = new File("D:/files/Practice.txt");
			String[] flist = files.list();
	        int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty folder.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equalsIgnoreCase("file.txt")) {
	                    System.out.println(filename + " found");
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }		
	}
	private static void deleteFile() {
		try {
			Path path= Paths.get("D:/files/Practice.txt");
			if(Files.deleteIfExists(path))
				System.out.println("File  deleted");
			else
				System.out.println("File not Deleted");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("File is not empty");
		}
		catch (IOException e) {
			System.out.println("Invalid Permission");
		}
				
	}	
	private static void createFile()throws IOException {
		Path path=Paths.get("D:/files/Practice.txt");

		String input="Hi !..."+ "\nWelcome"+ "\nGood Morning";
		byte array[]=input.getBytes();
		
		Files.write(path, array, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		System.out.println("Data Written Successfully");
			
	}
}
