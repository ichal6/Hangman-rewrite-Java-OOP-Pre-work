public class FIND_LETTER 
{
    public static void main(String[] args) 
    {
    
    }

    public static boolean checkWordInText(String capital, String letterOrWord)
    {
        if (capital.equals(letterOrWord))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static char[] checkLetterInText(String capital, char[] capitalDash, String letterOrWord)
    {
        char[] capital_array = capital.toCharArray();
        int index = 0;
        if (letterOrWord.length() <= 0)
        {
            return capitalDash;
        }
        for (char charInCapital: capital_array)
        {
            if (charInCapital == letterOrWord.charAt(0))
            {
                capitalDash[index] = letterOrWord.charAt(0);
            }
            index += 1;
        }
        return capitalDash;
    }

    public static boolean checkLetterInText(String capital, String letterOrWord)
    {
        char[] capital_array = capital.toCharArray();
        if (letterOrWord.length() <= 0)
        {
            return false;
        }
        for (char charInCapital: capital_array)
        {
            if (charInCapital == letterOrWord.charAt(0))
            {
                return true;
            }
        }
        return false;
    }
}