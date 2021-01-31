import java.util.Scanner;

/**
 *
 * @author PraveenKumarThipparam
 * Section 1
 */
public class RockPaperScissors{
    
    //these are class constants (all methods in the class can see them)
    static final int ROCK = 1, PAPER = 2, SCISSORS = 3, YOU_WIN = 4, COMP_WIN = 5, DRAW = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        int yourScore=0, compScore=0;
        int gameResult;

        System.out.println("========================");
        System.out.println("ROCK PAPER SCISSORS GAME");
        System.out.println("========================");
        System.out.println("\nHello! Let's get started!");

        do {
            //calling the playGame method
            gameResult = playGame(scan);
            
            if (gameResult == YOU_WIN)
                yourScore++;
            else if(gameResult == COMP_WIN)
                compScore++;
                
            printScore(yourScore,compScore);//printing the score
            
            System.out.print("Do you want to play some more? (y or n): ");
            userInput = scan.next();

        } while (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"));
        
        System.out.println("========GAME OVER=======");
        System.out.println("       FINAL SCORE:");
        printScore(yourScore,compScore);
    }


    /**
    This method "plays" the game.
    The input parameter is the Scanner object created in main()
    The method return the int result of the game.
    */
    private static int playGame(Scanner scan) {
        int yourChoice, compChoice;
        //1. Prompt the user and use scan to read her input (R, P, or S)
        //...
        Scanner sc = new Scanner(System.in);
        System.out.print("Rock, Paper, or Scissors? (R,P,S): ");
        String input=sc.nextLine();
        
        
        //2. Use a while loop to continue asking for user input if it is not 
        // one of the three above ("r", "p", or "s", ignoring case) 
        //...
        while(!(input.equals("r") || input.equals("p") || input.equals("s")))
        {
            System.out.println("BRRRZZZT! Sorry,that entry is invalid");
            System.out.println("Try again");
            input=sc.nextLine();

        }
        //scan.close();
        
        
        
        
        //3. Once the user input is satisfactory 
        //print out the choice (e.g. "You chose Rock!"),
        //translate it to one of the int constants (ROCK, PAPER, or SCISSORS),
        //and assign to yourChoice variable (e.g. yourChoice = ROCK)
        //...
        if(input.equals("r"))
        {
            System.out.println("You chose Rock!");
            yourChoice = ROCK;
        }
        else if(input.equals("p"))
        {
            System.out.println("You chose Paper!");
            yourChoice = PAPER;
        }
        else
        {
            System.out.println("You chose Scissors!");
            yourChoice = SCISSORS;
        }    
        
        //4. Use Math.random() to randomly generate computer's choice
        //Remember, you need to split the range between 0 and 1 into
        // three equal intervals and if the random number is in one of them
        // assign a corresponding constant to compChoice.
        //Print out computer's choice as well.
        //...
        double rand = Math.random();
        if (rand<(1/3.0))
        {
            compChoice = ROCK;
            System.out.println("Computer chose Rock!");
        }
        else if (rand<(2/3.0))
        {
            compChoice = PAPER;
            System.out.println("Computer chose Paper!");
        }    
        else
        {
            compChoice = SCISSORS;
            System.out.println("Computer chose Scissors!");
        }
        //Call the method whoWins using yourChoice and compChoice as parameters
        int gameResult = whoWins(yourChoice, compChoice);      
        //return the game result to main()
        return gameResult;
    }


    /**
    This method takes two int parameters yourChoice and compChoice,
    and returns the result of the game.
    
    It will return YOU_WIN if you win, COMP_WIN if computer wins 
    and DRAW if it is a draw. (Remember, these are constants defined in this class)
    
    In addition, the method prints out the corresponding description of
    the result of the game e.g. "It's a draw!!", 
    or "Scissors cut Paper! You WIN!".
    or "Rock is covered by Paper! You lose :(", and so on.
    */
    private static int whoWins(int yourChoice, int compChoice) {
         if(yourChoice == compChoice)
         {     
               System.out.println("It's a draw!!");
               return DRAW;
         }
         else if(yourChoice == ROCK && compChoice == PAPER)
         {     
               System.out.println("Paper covers Rock! Computer WIN!");
               return COMP_WIN;
         }
         else if(yourChoice == ROCK && compChoice == SCISSORS)
         {
               System.out.println("Rock blunts Scissors! You WIN!");
               return YOU_WIN;
         }      
         else if(yourChoice == PAPER && compChoice == ROCK)
         {
               System.out.println("Paper covers Rock! You WIN!");
               return YOU_WIN;
         }
         else if(yourChoice == PAPER && compChoice == SCISSORS)
         {
               System.out.println("Scissors cut Paper! Computer WIN!");
               return COMP_WIN;
         }
         else if(yourChoice == SCISSORS && compChoice == ROCK)
         {
               System.out.println("Rock blunts Scissors! Computer WIN!");
               return COMP_WIN;
         }
         else if(yourChoice == SCISSORS && compChoice == PAPER)
         {
               System.out.println("Scissors cut Paper! You WIN!");
               return YOU_WIN;
         }
         else
         {
            return DRAW;

         }
        //...
    }


    /**
    This method takes in yourScore and compScore as parameters and prints
    them out in a formatted way, as shown in the project description.
    */
    private static void printScore(int yourScore, int compScore) {
    System.out.println("                  You : Comp");
    System.out.println("           SCORE: ----------");
    System.out.println("                  | "+yourScore +" :  "+ compScore+ " |");
    System.out.println("                  ----------");
    
    
      
        //...
    }

}