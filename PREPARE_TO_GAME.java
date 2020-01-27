import java.util.ArrayList;
import java.util.Random;

public class PREPARE_TO_GAME 
{
    public static void main(String[] args) 
    {
        
    }

    public static ArrayList<String> randomCapitalsAndCountry(ArrayList<ArrayList<String>> arrayCountriesAndCapitals)
    {
        ArrayList<String> arrayRow = new ArrayList<String>();

        Random rand = new Random();

        int lengthList = arrayCountriesAndCapitals.size();
        int index = rand.nextInt(lengthList);

        arrayRow = arrayCountriesAndCapitals.get(index);
        return arrayRow;
    }

    public static char[] makeDashWord(String capital)
    {
        String capitalDash = "";
        for(char sign : capital.toCharArray())
        {
            if(sign == ' ')
            {
                capitalDash = capitalDash.concat(" ");
            }
            else
            {
                capitalDash = capitalDash.concat("_");
            }
            
        }
        
        char[] capitalDashArray = capitalDash.toCharArray();

        return capitalDashArray;
    }
}