package org.rechner;


public class Rechner {
  public static void main(String[] args) {
    // Step 1: Gather input from the user
    int day = promptUser("Bitte geben Sie die Tageskomponente des Startdatums ein: ");
    int month = promptUser("Bitte geben Sie die Monatskomponente des Startdatums ein: ");
    int year = promptUser("Bitte geben Sie die Jahreskomponente des Startdatums ein: ");
    int daysToAdd = promptUser("Bitte geben Sie die Anzahl an Tagen ein: ");
    String resultDate = calculateEndDate(day, month, year, daysToAdd);
    SimpleIO.output("Das Datum " + resultDate + " befindet sich " + daysToAdd + " Tage nach dem Startdatum.");
  }
  private static int promptUser(String message) {
    System.out.print(message);
    return SimpleIO.getInt(message);
  }

  public static String calculateEndDate(int day, int month, int year, int daysToAdd) {

      int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      while (daysToAdd > 0) {
        if (isLeapYear(year)) {
          daysInMonth[1] = 29;
        } else {
          daysInMonth[1] = 28;
        }
        int daysInCurrentMonth = daysInMonth[month - 1];
        if (day + daysToAdd <= daysInCurrentMonth) {
          day += daysToAdd;
          daysToAdd = 0;
        } else {
          daysToAdd -= (daysInCurrentMonth - day + 1);
          day = 1;
          month++;
          if (month > 12) {
            month = 1;
            year++;
          }
        }
      }
      return day + "." + month + "." + year;



  }


  public static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

}
