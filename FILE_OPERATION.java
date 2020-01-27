import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FILE_OPERATION 
{
    public static void main(String[] args) 
    {
        
    }

    public static Scanner openFile(String filename)
    {
        Scanner data = null;

        try 
        {
            data = new Scanner(new File(filename));
        }
        catch ( IOException e) 
        {
            System.out.println("Sorry but I was unable to open your data file");
            e.printStackTrace();
            System.exit(0);
        }
        return data;
    }

    public static void saveToFile(String dataToSave, String filename)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(dataToSave);
            fileWriter.close();
        }
        catch ( IOException e) 
        {
            System.out.println("Sorry but I was unable to save your data file");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static ArrayList<ArrayList<String>> ScannertoArray(Scanner dataFromFile, boolean listWin)
    {
        ArrayList<ArrayList<String>> arrayCountriesAndCapitals = new ArrayList<ArrayList<String>>();
        String newRow = "";
        String country, capitals;
        while(dataFromFile.hasNextLine()) 
        {
            ArrayList<String> ArrayRow = new ArrayList<String>();
            newRow = dataFromFile.nextLine();
            newRow = newRow.toUpperCase();
            String[] parts = newRow.split("\\|");
            if(listWin)
            {
                ArrayRow.add(parts[0].substring(0, parts[0].length() - 1)); //remove last char
                ArrayRow.add(parts[1].substring(1, parts[1].length() - 1)); //remove first and last char
                ArrayRow.add(parts[2].substring(1, parts[2].length() - 1)); //remove first and last char
                ArrayRow.add(parts[3].substring(1, parts[3].length() - 1)); //remove first and last char
                ArrayRow.add(parts[4].substring(1, parts[4].length())); //remove first char
            }
            else
            {
                country = parts[0].substring(0, parts[0].length() - 1); //remove last char
                capitals = parts[1].substring(1, parts[1].length()); //remove first char
                ArrayRow.add(country);
                ArrayRow.add(capitals);
            }
            arrayCountriesAndCapitals.add(ArrayRow);
           
        }
        return arrayCountriesAndCapitals;
    }

    public static String arrayToString(ArrayList<ArrayList<String>> listWin)
    {
        String formatData = "";
        for(ArrayList<String> user: listWin)
        {
            formatData += String.format("%s | %s | %s | %s | %s\n", user.get(0), user.get(1), user.get(2), user.get(3), user.get(4));
        }
        return formatData;
    }

    public static ArrayList <String> draw(Scanner dataFromFile)
    {
        ArrayList<String> arrayDraw = new ArrayList<String>();
        String newRow = "";
        String newDraw = "";
        while(dataFromFile.hasNextLine()) 
        {
            newRow = dataFromFile.nextLine();
            if(newRow.equals("?"))
            {
                arrayDraw.add(newDraw);
                newRow = "";
                newDraw = "";
            }
            newDraw += newRow + "\n";
           
        }
        return arrayDraw;
    }
}