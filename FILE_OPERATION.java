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

    public static Scanner open_file(String filename)
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

    public static ArrayList<ArrayList<String>> ScannertoArray(Scanner data_from_file, boolean listWin)
    {
        ArrayList<ArrayList<String>> Array_countries_and_capitals = new ArrayList<ArrayList<String>>();
        String new_row = "";
        String country, capitals;
        while(data_from_file.hasNextLine()) 
        {
            ArrayList<String> Array_row = new ArrayList<String>();
            new_row = data_from_file.nextLine();
            new_row = new_row.toUpperCase();
            String[] parts = new_row.split("\\|");
            if(listWin)
            {
                Array_row.add(parts[0].substring(0, parts[0].length() - 1)); //remove last char
                Array_row.add(parts[1].substring(1, parts[1].length() - 1)); //remove first and last char
                Array_row.add(parts[2].substring(1, parts[2].length() - 1)); //remove first and last char
                Array_row.add(parts[3].substring(1, parts[3].length() - 1)); //remove first and last char
                Array_row.add(parts[4].substring(1, parts[4].length())); //remove first char
            }
            else
            {
                country = parts[0].substring(0, parts[0].length() - 1); //remove last char
                capitals = parts[1].substring(1, parts[1].length()); //remove first char
                Array_row.add(country);
                Array_row.add(capitals);
            }
            Array_countries_and_capitals.add(Array_row);
           
        }
        return Array_countries_and_capitals;
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