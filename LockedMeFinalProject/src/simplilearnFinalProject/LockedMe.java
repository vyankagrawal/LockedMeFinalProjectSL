package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectFilesPath="C:\\Classes\\SL\\JavaFS\\FinalProject\\LockedMeFiles";
	
	public static void displayMenu()
	{
	 System.out.println("******************************************************");
	 System.out.println("\tWelcome to LockedMe.com secure app");
	 System.out.println("Developed by : Vyank Agrawal");
	 System.out.println("******************************************************");
	 System.out.println("\t\t1. Display all files");
	 System.out.println("\t\t2. Add a new file");
	 System.out.println("\t\t3. Delete a file");
	 System.out.println("\t\t4. Search file");
	 System.out.println("\t\t5. Exit");
	 System.out.println("******************************************************");
	}
	
	/**
	 * This method will retrieve all the files of folder
	 */
	public static void getAllFiles()
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length>0)
		{
			System.out.println("FILES LIST IS BELOW: \n");
			for(var l:listOfFiles)
			{
				System.out.println(l.getName());
			}
		}
		else
		{
			System.out.println("The folder is empty");
		}
	}
	
	/**
	 * This method will create a new file
	 */
	public static void createFiles()
	{
		try
		{
		//Variable declaration	
		Scanner obj = new Scanner(System.in);
		String fileName;
		
		//Read file name from user
		System.out.println("Enter file name with extension .txt:");
		fileName=obj.nextLine();
		
		int linesCount;
		System.out.println("Enter how many lines in the file:");
		linesCount=Integer.parseInt(obj.nextLine());
		
		FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
			
			//Read line by line from user
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter file line:");
				fw.write(obj.nextLine()+"\n");
			}
			
		System.out.println("File Created Successfully");
		fw.close();
		}
		
		catch(Exception Ex)
		{
			
		}
	}
	
	/**
	 * This method will take file name as parameters and checks if 
	 * its is present in the project folder or not
	 * @param fileName String
	 * @return boolean
	 */
	public static boolean checkFileExists(String fileName)
	{
		
		//Get all files names into a list
		ArrayList<String> allFilesNames =new ArrayList<String>();
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
			if(listOfFiles.length>0)
			{
				for(var l:listOfFiles)
				{
					allFilesNames.add(l.getName());
				}
			}
			
		return allFilesNames.contains(fileName);	
	}
	
	//To delete existing file
	public static void deleteFiles()
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter file name to be deleted:");
		fileName=obj.nextLine();
		
		File f = new File(projectFilesPath+"\\"+fileName);
			if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File deleted Successfully");
			}
			else
			{
				System.out.println("File doesnot exist");
			}
		}
		catch(Exception Ex)
		{
			System.out.println("Unable to delete file. Please contact : admin@test.com");
		}
	}
	
	/**
	 * This method is to search a file
	 */
	public static void searchFiles()
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name to be searched:");
		fileName=obj.nextLine();
			
			if(checkFileExists(fileName))
			{
				System.out.println("File is available");
			}
			else
			{
				System.out.println("File is not available");
			}
		}
		catch(Exception Ex)
		{
			
		}
	}
}

