import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class HexDexBiConverter {
   public static void main(String [] args) {
      ArrayList<String> numbers = new ArrayList<String>();
      ArrayList<String> answerNumber = new ArrayList<String>();
      Scanner scnr = new Scanner(System.in);
      String answer = "";
      String response = "";
      String number = "";
      String numberAnswer = "";
      int endKind = 0;
      int startKind = 0;
      int kind = 0;
      double decimalNumber = 0.0;
      boolean cOrD = true;
      kind = JOptionPane.showConfirmDialog(null, "Would you like to continue with Dialog boxes?\n(If you choose no," + 
      "this window will convert to the console)");
      if (kind == 0) {
         answer = JOptionPane.showInputDialog("What would you like to convert to?(hexidecimal, decimal or binary)"); 
         endKind = determineKind(answer, kind);  
         response = JOptionPane.showInputDialog("What type is your number?(hexidecimal, decimal or binary)");
         startKind = determineKind(response, kind);
         number = JOptionPane.showInputDialog("What is your number?");
         number = numberNullChecker(number, kind);
         if (startKind == 2) {
            decimalNumber = Double.parseDouble(number);
            if (endKind == 3) {
               decToBinary(decimalNumber, answerNumber);
                  numberAnswer = binaryPrinter(answerNumber);
                  JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
                  System.exit(0);
               } else { 
                  numberAnswer = decToHex(decimalNumber);
                  JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               }           
      } else if (startKind == 1) {
               numbers = numberInputter(number);
               if (endKind == 2) {
                  numberAnswer = hexDecConverter(numbers);
                  JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               } else {
               numberAnswer = hexDecConverter(numbers);
               decimalNumber = Double.parseDouble(numberAnswer);
               System.out.println("Number is in dec and is " + numberAnswer);
               decToBinary(decimalNumber, answerNumber);
               numberAnswer = binaryPrinter(answerNumber);
               JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);              
               }
            } else {
               numbers = numberInputter(number);
               if (endKind == 2) {
                  numberAnswer = binToDec(numbers);
                  JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               } else {
                  numberAnswer = binToDec(numbers);
                  decimalNumber = Double.parseDouble(numberAnswer);
                  numberAnswer = decToHex(decimalNumber);
                  JOptionPane.showMessageDialog(null, "Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               }         
            }
         } else if (kind == 1) {
            System.out.println("What would you like to convert to?(hexidecimal, decimal or binary)\n(Enter nothing if you wish to stop)");
            answer = scnr.nextLine();
            endKind = determineKind(answer, kind);
            System.out.println("What type is your number?(hexidecimal, decimal or binary)\n(Enter nothing if you wish to stop)");
            response = scnr.nextLine();
            startKind = determineKind(response, kind);
            System.out.println("What is your number?");
            number = scnr.nextLine();
            number = numberNullChecker(number, kind);
            if (startKind == 2) {
               decimalNumber = Double.parseDouble(number);
               if (endKind == 3) {
                  decToBinary(decimalNumber, answerNumber);
                  numberAnswer = binaryPrinter(answerNumber);
                  System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               } else { 
                  numberAnswer = decToHex(decimalNumber);
                  System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               }           
            } else if (startKind == 1) {
               numbers = numberInputter(number);
               if (endKind == 2) {
                  numberAnswer = hexDecConverter(numbers);
                  System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               } else {
               numberAnswer = hexDecConverter(numbers);
               decimalNumber = Double.parseDouble(numberAnswer);
               decToBinary(decimalNumber, answerNumber);
               numberAnswer = binaryPrinter(answerNumber);
               System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);              
               }
            } else {
               numbers = numberInputter(number);
               if (endKind == 2) {
                  numberAnswer = binToDec(numbers);
                  System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               } else {
                  numberAnswer = binToDec(numbers);
                  decimalNumber = Double.parseDouble(numberAnswer);
                  numberAnswer = decToHex(decimalNumber);
                  System.out.println("Your number, " + number + ", in " + response + " is " + numberAnswer + " in " + answer);
               }
            }
         } else {
            System.exit(0);
         }         
      }        
   
   public static ArrayList numberInputter(String number) {
      ArrayList<String> newNumber = new ArrayList<String>();
      int x = 0;
      while (x < number.length()) {
         newNumber.add(number.charAt(x) + "");
         x++;
      }
      return newNumber;   
   }
   
   public static int determineKind(String name, int kind) {
      int number = 0;
      if ((name == null) && (kind == 0)) {
         System.exit(0);
      } else if ((name.equals("")) && (kind == 1)) {
         System.exit(0);
      } else {      
         if (name.substring(0,1).toLowerCase().equals("h")) { 
               number = 1;
         } else if (name.substring(0,1).toLowerCase().equals("d")) {
               number = 2;
         } else if (name.substring(0,1).toLowerCase().equals("b")) {
               number = 3;
         }
      }   
      return number;            
   }
   
   public static void decToBinary(double number, ArrayList newNumber) {
      int remainder = 0;
      if (number % 2 == 0) {
         System.out.println("Adding first 0!");
         newNumber.add(0, "0");
      } else {
         System.out.println("Adding first 1!");
         newNumber.add(0, "1"); 
      }        
      while (number > 1) {
         System.out.println("Number is " + number);
         remainder = (int) number/2;
         System.out.println("Remainder is " + remainder);
         if (remainder % 2 == 0) {
            System.out.println("Adding a 0!");
            newNumber.add(0, "0");
         } else {
            System.out.println("Adding a 1!");
            newNumber.add(0,"1");
         }
         number = remainder;
      }                            
   }
   
   public static String binaryPrinter(ArrayList number) {
      String binary = "";
      if (number.size() % 4 != 0) {
         while (number.size() % 4 != 0) {
            number.add(0, "0");
         }
      }      
      for(int x = 0; x < number.size(); x++) {
         binary += number.get(x);   
      }
      return binary;   
   }
   
   public static String decToHex(double number) {
      String complete = "";
      double remainder = 0.0;
      long wholeNumber = 0L;
      double hex = 0.0;
      String tmp = "";
      ArrayList<String> answerHex = new ArrayList<String>();
      while (number > -1) {
         remainder = number/16.0;
         wholeNumber = (long) remainder;
         remainder = remainder - wholeNumber;
         hex = remainder * 16.0;
         tmp = hexChecker(hex);
         answerHex.add(tmp); 
         if (wholeNumber == 0) {
            number = -1;    
         } else {
            number = wholeNumber;
         }                  
      }
      for(int x = answerHex.size() - 1; x > -1; x--) {
         complete += answerHex.get(x);
      }   
      return complete;
   }
   
   public static String hexChecker(double number) {
      int newNumber = 0;
      String returnValue = "";
      if (number < 10) {
         newNumber = (int) number / 1;
         return newNumber + "";
      } else if (number == 10) {
         return "A";
      } else if (number == 11) {
         return "B";
      } else if (number == 12) {
         return "C";
      } else if (number == 13) {
         return "D";
      } else if (number == 14) {
         return "E";
      } else if (number == 15) {
         return "F";
      }
      return "";                      
   }
   
   public static String letterToNumber(String start) {
      String returnValue = "";
      if (start.equals("A")) {
         return 10 + "";
      } else if (start.equals("B")) {
         return 11 + "";
      } else if (start.equals("C")) {
         return 12 + "";
      } else if (start.equals("D")) {
         return 13 + "";
      } else if (start.equals("E")) {
         return 14 + "";
      } else if (start.equals("F")) {
         return 15 + "";
      }
      return "";                      
   }
   
   public static String hexDecConverter(ArrayList start) {
      double endingNumber = 0.0;
      double tmp = 0.0;
      int counter = 0;
      String holder = "";
      for(double x = start.size() - 1; x > -1; x--) {
         holder += start.get(counter);
         if (holder.equals("A") || holder.equals("B") || holder.equals("C") || holder.equals("D") || holder.equals("E") || holder.equals("F")) {
            holder = letterToNumber(holder); 
            tmp = Double.parseDouble(holder);
            endingNumber += tmp * Math.pow(16, x);
            holder = "";
            counter++;
        } else {
            tmp = Double.parseDouble(holder);
            endingNumber += tmp * Math.pow(16, x);
            holder = "";
            counter++;
        }       
      }
      return (int) endingNumber + "";
   }
   
   public static String binToDec(ArrayList start) {
      double endingNumber = 0.0;
      double tmp = 0.0;
      int counter = 0;
      String holder = "";
      for(double x = start.size() - 1; x > -1; x--) {
         holder += start.get(counter);
         tmp = Double.parseDouble(holder);
         endingNumber += tmp * Math.pow(2, x);
         holder = "";
         counter++;
      }
      return (int) endingNumber + "";   
   }
   
   public static String numberNullChecker(String number, int kind) {
      if ((number == null) && (kind == 0)) {
         System.exit(0);
      } else if ((number.equals("")) && (kind == 0)) {
         System.exit(0);
      } else {
         return number;      
      }
      return number;
   }
}   