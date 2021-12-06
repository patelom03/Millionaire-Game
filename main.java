import java.util.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
//initialization of variables and boolean structures
    int bank = 0;
    int exitSource = 0; 
    boolean lvl2=false;
    boolean lvl3=false;
    boolean lvl4=false;
    boolean lvl5=false;
    int doubleDip = 1; 
    final int SAFETYNET1 = 100000;
    final int SAFETYNET2 = 500000;

//Greeting the person and telling them the game rules 
    System.out.println("Hello and welcome to Who Wants to Be a Millionaire Game!!!");
    System.out.println("What is your name?");
    final String NAME = sc.nextLine();
    System.out.println("Welcome "+NAME+", I hope you're ready for tonight's game!");
    System.out.println("The rules are as followed:\n"
                      + "The game you are going to play consists of 5 multiple choice questions. Each question has its own payout which you will be able to bank if answered correctly.\n"
                      + "For each question answered correctly, you advance onto the next question with the payout banked.\n"
                      + "You will have two lifelines avaiblable. One will be offered from question 2 to 4, but you may only use it once; and the second one will be available on question five only.\n"
                      + "The first lifeline, known as the 'Double Dip' will grant you an extra life on the question you use it, meaning you will have two tries to answer that particular question.\n"
                      + "The second lifeline, known as the '50:50' which is only available on the fifth question will automatically remove two random incorrect answers, leaving you with a 50:50 chance of answering it right.\n"
                      + "Questions two and four are safety net questions meaning if you get question three or five wrong, you will be brought down one question and even thought it will be a game over, you will be able to leave with the amount you have banked so far.\n"
                      + "The questions will increase in difficulty with one being easy and five being challenging.\n"
                      + "When answering, pick one of the four options provided by entering 1, 2, 3, or 4.\n"
                      + "Be careful as you only have one chance at this!\n"
                      + "Let the games begin!!!\n\n\n");



//Question 1 is introduced 
    System.out.println("Well here we go starting off with the first question...");
    System.out.println("---$10,000---");
    System.out.println("Which of the following birds can take flight?");
    System.out.println("1. Ostrich \n2. Penguin \n3. Emu \n4. Hummingbird");
    int ans1 = sc.nextInt();
//This will make sure user input is 1, 2, 3, or 4; if not, it will ask the user to input a valid anaswer in  
      if (ans1>4 || ans1<1) {
        do {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans1 = sc.nextInt();
        } while (ans1>4 || ans1<1);
      }
//Different outputs based on if the player gets the answer right or wrong 
    if (ans1 == 4) {
      bank = 10000;
      System.out.printf(ans1+" is...CORRECT! Well done "+NAME+ ". Congrats, you just banked your first payout of $%,d.", bank);
      System.out.println(" The next question awaits you...\n\n\n");
//Since question one was answered correctly, question two will be true as it was set as false in the beginning  
      lvl2=true;
    } else {
      System.out.println(ans1+" is...INCORRECT! Sorry "+NAME+", looks like you journey stops here.");
      exitSource = 1; 
    }
    
    
    
//Question 2 is introduced 
    if (lvl2==true) {
      System.out.println("Question 1 was easy, but lets see how you perform on question 2! This is a safety net question, so answering this correctly guarantees a payout.");
      System.out.println("And the next question is for...");
      System.out.println("---$100,000---");
      System.out.println("Which planet is named after the Roman goddess of love?\n"
                        + "1. Venus \n2. Mercury \n3. Saturn \n4. Mars");
//Asks the user what they want to do after looking at the question; either walk away, answer the question, or use a lifeline 
      System.out.printf("\nAfter looking at the question, would you like to (Enter 1, 2, or 3):\n1) Walk away with $%,d \n2) Answer the question\n3) Use 'Double Dip' lifeline\n", bank);
      int choice2 = sc.nextInt();
//Based on what the user wants to do, different outputs will be displayed 
      if (choice2 == 1) {
        System.out.printf("The decision was yours and you're walking out with $%,d.", bank);
        System.out.println("\nThank you for playing the Who Wants to be a Millionaire Game!");
        return; 
      } else if (choice2 == 2) {
        System.out.print("What is your answer: ");
      } else if (choice2 == 3) {
        System.out.print("You have two tries to answer this correctly.\nEnter your first final answer: ");
        doubleDip--; 
      }
      int ans2 = sc.nextInt();
//This makes sure the user input is valid; if not, the user will be asked to enter a valid input
      while (ans2>4 || ans2<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans2 = sc.nextInt();
      }
//This part will grant the user the second chance if one, they decided to use the Double Dip lifeline and two, if they got thier first try wrong
      if (doubleDip == 0 && ans2 != 1) {
        System.out.print("Sorry that was incorrect.\nEnter your second final answer: "); 
        ans2 = sc.nextInt();
      }
//This makes sure the user input is valid; if not, the user will be asked to enter a valid input
      while (ans2>4 || ans2<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans2 = sc.nextInt();
      }
//Switch cases outputting different things based on what the user inputed for thier answer
      switch (ans2) {
        case 1:
          bank = 100000;
          System.out.printf("\nVenus is...CORRECT! Congrats, you just banked $%,d. You're on a roll, only three more questions to go!\n\n\n", bank);
//Since question two was answered correctly, question three will be true as it was set as false in the beginning  
          lvl3=true;
          break;
        case 2:
        case 3:
        case 4: 
          System.out.printf("\n"+ans2+ " was...INCORRECT! You are walking away with $0.");
          exitSource = 2;
          break;
      }
    }
    
//Question 3
    if (lvl3==true) {
      System.out.println("Now the questions will start to get more challenging, but don't worry if you get this question wrong, you will still walk away with a payout.");
      System.out.println("Let's see what surprise question three holds for us and the payout will be...\n\n"
                        + "---$250,000---");
      System.out.println("From the following numbers, which is the biggest in accordance with the short scale? "); 
      System.out.println("1. Sextillion \n2. Octillion \n3. Vigintillion \n4. Quindecillion");
//Two different outputs based on if the Double Dip lifeline is still available and then asks the user what they want to do after looking at the question
      if (doubleDip==1) {
        System.out.printf("\nAfter looking at the question, would you like to (Enter 1, 2, or 3):\n1) Walk away with $%,d \n2) Answer the question\n3) Use 'Double Dip' lifeline\n", bank);
      } else {
        System.out.printf("\nAfter looking at the question, would you like to (Enter 1, or 2):\n1) Walk away with $%,d \n2) Answer the question\n", bank);
      }
      int choice3 = sc.nextInt();
      if (choice3 == 1) {
        System.out.printf("The decision was yours and you're walking out with $%,d.", bank);
        System.out.println("\nThank you for playing the Who Wants to be a Millionaire Game!");
        return; 
      } else if (choice3 == 2) {
        System.out.print("What is your answer: ");
      } else if (choice3 == 3) {
        System.out.print("You have two tries to answer this correctly.\nEnter your first final answer: ");
        doubleDip--; 
      }
      int ans3 = sc.nextInt();
//Prompt for a valid input if the user inputed a invalid asnwer 
      while (ans3>4 || ans3<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans3 = sc.nextInt();
      }
//This part will grant the user the second chance if one, they decided to use the Double Dip lifeline and two, if they got thier first try wrong
      if (choice3 == 3 && doubleDip == 0 && ans3 != 3) {
        System.out.print("Sorry that was incorrect.\nEnter your second final answer: "); 
        ans3 = sc.nextInt();
      } 
//Prompt for a valid input if the user inputed a invalid asnwer 
      while (ans3>4 || ans3<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans3 = sc.nextInt();
      }
//Different outputs based on if the user got the question right or wrong 
      if (ans3==3) {
        bank = 250000;
        System.out.printf("\nVigintillion is...CORRECT! Congrats, you're on fire! You payout has been banked, making it a whopping $%,d. Lets advance onto the next question shall we.\n\n\n" , bank);
//Since question three was answered correctly, question four will be true as it was set as false in the beginning  
        lvl4=true;
      } else {
        System.out.printf("\nSorry, "+ans3+" was...INCORRECT! Looks like your jouney ends here...but don't worry as you wont be going home empty handed as you are dropped to the safety net question and will be returing home with some cash!");
        exitSource = 3;
      }  
    } 
    
//Question 4 
    if (lvl4==true) {
      System.out.print("Give youself a pat on the back for making it this far! \nThis is a safety net question as well, getting this right guarantees a higher payout even if you don't get the last question right.");
      System.out.println(" And the next question is for...");
      System.out.println("---$500,000---");
      System.out.println("When was the SARS (Severe Acute Respiratory Syndrome) virus identified? ");
      System.out.println("1. 2000\n2. 2000\n3. 1998\n4. 2003");
//Two different outputs based on if the Double Dip lifeline is still available and then asks the user what they want to do after looking at the question
      if (doubleDip==1) {
        System.out.printf("\nAfter looking at the question, would you like to (Enter 1, 2, or 3):\n1) Walk away with $%,d \n2) Answer the question\n3) Use 'Double Dip' lifeline\n", bank);
      } else {
        System.out.printf("\nAfter looking at the question, would you like to (Enter 1, or 2):\n1) Walk away with $%,d \n2) Answer the question\n", bank);
      }
      int choice4 = sc.nextInt();
      if (choice4 == 1) {
        System.out.printf("The decision was yours and you're walking out with $%,d.", bank);
        System.out.println("\nThank you for playing the Who Wants to be a Millionaire Game!");
        return; 
      } else if (choice4 == 2) {
        System.out.print("What is your answer: ");
      } else if (choice4 == 3) {
        System.out.print("You have two tries to answer this correctly.\nEnter your first final answer: ");
        doubleDip--; 
      }
      int ans4 = sc.nextInt();
//Prompt for a valid input if the user inputed a invalid asnwer 
      while (ans4>4 || ans4<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans4 = sc.nextInt();
      }
//This part will grant the user the second chance if one, they decided to use the Double Dip lifeline and two, if they got thier first try wrong
      if (choice4 == 3 && doubleDip == 0 && ans4 != 4) {
        System.out.print("Sorry that was incorrect.\nEnter your second final answer: "); 
        ans4 = sc.nextInt();
      } 
//Prompt for a valid input if the user inputed a invalid asnwer 
      while (ans4>4 || ans4<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans4 = sc.nextInt();
      }
//Different outputs based on if the user got the question right or wrong 
      if (ans4==4) {
        bank = 500000;
        System.out.printf("\n2003 is...CORRECT! You have now banked $%,d.\n\n\n", bank);
//Since question four was answered correctly, question five will be true as it was set as false in the beginning  
        lvl5=true;
      } else {
        System.out.print("\nYou are...INCORRECT! The correct answer was 2003.");
        exitSource = 4;
      }
    }
    
    
//Question 5 
    if (lvl5==true) {
      System.out.print("Congrats on making it this far! Only one more right answer and you're a MILLIONAIRE!");
      System.out.println(" And the next question is for...");
      System.out.println("---$1,000,000---");
      System.out.println("Roughly, how much is one astronomical unit (AU) in miles? ");
      System.out.println("1. 93 million miles\n2. 17 million miles\n3. 39 million miles\n4. 107 million miles");
//Asks the user what they want to do after looking at the question with the option to use thier new lifeline, 50:50
      System.out.printf("\nAfter looking at the question, would you like to (Enter 1, 2, or 3):\n1) Walk away with $%,d \n2) Answer the question\n3) Use '50:50' lifeline\n", bank);
      int choice5 = sc.nextInt();
      if (choice5 == 1) {
        System.out.printf("The decision was yours and you're walking out with $%,d.", bank);
        System.out.println("\nThank you for playing the Who Wants to be a Millionaire Game!");
        return; 
      } else if (choice5 == 2) {
        System.out.print("What is your answer: ");
      } 
//If the user decided to use thier 50:50 life line, the following code will randomly display 2 out of the 4 options available for the question randomly, one being the correct answer
      else if (choice5 == 3) {
        System.out.println("---$1,000,000---");
        System.out.println("Roughly, how much is one astronomical unit (AU) in miles? ");
        Random random = new Random(); //For random in future code
        int min = 2; //In this context, 2 represents the second answer
        int max = 4; //and 4 represents the fourth answer
        int select = random.nextInt((max - min) + 1) + min; //Generates a random number which meets is requirements in its parameters with min and max both inclusive; the random number is stored in variable 'select' 
        System.out.println("1. 93 million miles"); //The correct answer is always printed 
        if (select == 2) { //If 2 is the random number generated, the second option will be displayed 
          System.out.println("2. 17 million miles"); 
        } else { //Else6, it will be left blank 
          System.out.println("2.  "); 
        } if (select == 3) { //If 3 is the random number generated, the third option will be displayed 
          System.out.println("3. 39 million miles");
        } else { //Else, it will be left blank
          System.out.println("3.  ");
        } if (select == 4) { //If 4 is the random number generated, the fourth option will be displayed 
          System.out.println("4. 107 million miles");
        } else { //Else, it will be left blank
          System.out.println("4.  "); 
        } 
        System.out.print("Your answer is: "); //Asks for user entry 
      }
      int ans5 = sc.nextInt(); //Stores ans in variable 'ans5'
//Makes sure 'ans5' is 1, 2, 3, or 4; if not, the user will be asked to enter a valid  answer again 
      while (ans5>4 || ans5<1) {
        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");
        ans5 = sc.nextInt();
      }
//Different outputs based on if the player got the answer right 
      if (ans5==1) {
        bank = 1000000;
        System.out.printf("\n93 million miles is...CORRECT!\nYOU ARE NOW A MILLIONAIRE!!!\nYou have now banked $%,d.", bank);
      } else {
        System.out.print("\nYou are...INCORRECT! The correct answer was 93 million miles.");
        exitSource = 5;
      }
    }
    
//If the player got any question wrong, varaible 'exitSource' was declared either 1, 2, 3, 4, or 5 depending on the question answered incorrectly
//The different cases display different outputs based on what the 'exitSource' is 
    switch (exitSource) {
      case 1: 
      case 2: 
        System.out.print("Better luck next time "+NAME+"."); //This will print when 'exitSource' is 1 or 2
        break;
      case 3:
      case 4:
        System.out.printf(" You are walking away with $%,d "+NAME+".", SAFETYNET1); //This will print when 'exitSource' is 3 or 4
        break;
      case 5:
        System.out.printf(" You are walking away with $%,d "+NAME+".", SAFETYNET2); //This will print when 'exitSource' is 5
        break;
    }
    
    System.out.println("\nThank you for playing the Who Wants to be a Millionaire Game!");
    
  }
}
