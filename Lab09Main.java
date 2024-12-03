/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author kamer
 */
// Lab09Main.java
// Kameron Ibraheem
// Lab 09: Lab09Main
//
//

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab09Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String s;
      int k = -1;

      // Prompt the user for a string
      System.out.print("Enter a string: ");
      s = scnr.nextLine();

      // Handle exceptions for input of integer k
      boolean validK = false;
      while (validK == false) {
         try {
            System.out.print("Enter an index: ");
            k = scnr.nextInt();

            if (k < 0) {
               throw new InvalidNegativeIndexException();
            }

            validK = true; // Exit loop if valid
         } 
         catch (InputMismatchException e) {
            System.out.println("Error: The index must be an integer.");
            scnr.next(); // Clear invalid input
         } 
         catch (InvalidNegativeIndexException e) {
            System.out.println(e.getMessage());
         }
      }

      // Display the character at index k or handle out-of-bounds exception
      try {
         System.out.println("Character at index " + k + ": " + s.charAt(k));
      } 
      catch (StringIndexOutOfBoundsException e) {
         System.out.println("Error: The given index is not within the valid index range.");
      }

      // Handle exceptions from stringFirstHalf
      try {
         System.out.println("First half of the string: " + stringFirstHalf(s));
      } 
      catch (OddLengthStringException e) {
         System.out.println(e.getMessage());
      }
   }

   // Static method to get the first half of a string
   public static String stringFirstHalf(String input) throws OddLengthStringException {
      if (input.length() % 2 != 0) {
         throw new OddLengthStringException();
      }
      return input.substring(0, input.length() / 2);
   }
}

