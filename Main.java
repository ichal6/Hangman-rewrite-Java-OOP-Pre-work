import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to Hangman! Save the world from SKYNET!");
        mainMenu();
    }

    public static void mainMenu()
    {
        Scanner inputUser = new Scanner(System.in);  // Create a Scanner object
        boolean isRun = true;
        while (isRun)
        {
            System.out.println("(S)tart\n(H)igh scores\n(E)xit");
            char chooseUser = inputUser.next().charAt(0);  // Read user input
            chooseUser = Character.toUpperCase(chooseUser);
            switch(chooseUser)
            {
                case 'S':
                    PlayGame.initGame();
                    break;
                case 'H':
                    Scanner dataFromListWin = FileOperation.openFile("win_list.txt");  
                    System.out.print(FileOperation.arrayToString(FileOperation.ScannertoArray(dataFromListWin, true)));
                    break;
                case 'E':
                    isRun = false;
                    break;
                default:
                    System.out.println("You press wrong input. Please try again");
            }
        }

    }


}