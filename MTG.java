/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mtg;


import java.util.Scanner;

/* Super class */

class Cities {
    int budget;
    int days = 7;
    static String[] WeekDays = {" Sunday :", " Monday :", " Tuesday :", " Wednesday :", " Thursday :", " Friday :", " Saturday :"};

    public void setBudget(int newBud){
        budget = newBud;
    }

    public void Prnint(String[] x) {
        System.out.println("\nYour schedule for a week :");
        for (int i = 0; i < 7; i++) {
            System.out.print("\n" + WeekDays[i] + "\n");
            System.out.print(x[i] + "\n");
        }
    }
    
    /* Here we used overloading , this two methods to print the schedules according to the budget */

    public void printSchedule(String[] highSchedule, String[] lowSchedule) {
        if (budget >= 2500) {
            Prnint(highSchedule);
        } else {
            Prnint(lowSchedule);
        }
    }
    public void printSchedule(String[] highSchedule) {
        if (budget >= 2500) {
            Prnint(highSchedule);
        } else {
            System.out.print("Sorry, your budget is very low try again...."); /* Possibility of incorrect entry  */
        }
    }

    public void printSchedule() {
    }
    
    /* Self study , Rotate code */
    
    public static String[] Rotate(String[] arr, int rotations) {
        int length = arr.length;
        rotations = rotations % length;
        String[] rotatedSchedule = new String[length];
        for (int i = 0; i < length; i++) {
            int rotatedIndex = (i + rotations) % length;
            rotatedSchedule[rotatedIndex] = arr[i];
        }
        return rotatedSchedule;
    }
     public static void PrintRotatedSchedule(String[] RotatedSchedule) { 
        for (int i = 0; i < 7; i++) {
            System.out.print("\n" + WeekDays[i] + "\n");
            System.out.print(RotatedSchedule[i] + "\n");
        }
    }

    String[] getSchedule() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
}

/* Subclass named Riyadh and extends to the Super class (Cities) */

class Riyadh extends Cities {
    String[] HriyadhScheduale = {
            " 1-Breakfast(hotel)\n 2-Kingdom Suspension Bridge\n 3-Riyadh Park\n 4-Beef Bar Restaurant",
            " 1-Lovefer Branch\n 2-Cinema (Boulevard)\n 3-Meraki Restuarant",
            " Free Day", " 1-Rishshaw London Branch\n 2-Winter Wonderland\n 3-PizzaBar Restaurant",
            " 1-Breakfast(hotel)\n 2-Al-Nakheel Mall\n 3-Oia Restuarant",
            " 1-Easy Bakery Branch\n 2-Dalila Camp Event",
            " 1-Breakfast(hotel)\n 2-KingAbdullah Financial District\n 3-Al-Nakheel Mall"
    };

    String[] LriyadhScheduale = {
            " 1-F60r Branch\n 2-KingAbdullah Park\n 3- Riyadh Front",
            " 1-Breakfast(hotel)\n 2- Winter Wonderland\n 3- Sign Restuarant",
            " 1-Breakfast(hotel)\n 2- Historic Murabba Palace\n 3- Roor Restuarant",
            " 1-Arkmi Restuarant\n 2- Al-Nakheel Mall\n 3- Riyadh Zoo\n 4- Roasted Way Restuarant",
            " Free Day", " 1-Salam Park\n 2- Suspension Bridge\n 3- Urban Restuarant\n",
            " 1-Ad Branch\n 2- Diriyah Park\n 3-Othaim Mall\n 4-Kentucky"
    };
    
    @Override
    public void printSchedule() {
        printSchedule(HriyadhScheduale, LriyadhScheduale);
    }
}

/* Subclass named Jeddah and extends to the Super class (Cities) */

class Jeddah extends Cities {
    
    String [] HjeddahScheduale = {
    "1-Caffeine Lab Branch\n  2-Al-Tayebat international city\n",
    " 1-BROOTS Coffee & Cocoaln\n  2-ALshallal Theme ParkIn\n 3-Khalil's BBQ Restaurant\n",
    "1-Al-Khayyat CentreIn\n 2-Maqadeer Restuarant\n",
    "1-Fakieh Aquarium\n 2-THE YEMENI VILLAGE Restaurant\n",
    "1-Sakura Restuarant\n 2-Hemi Cafe & Roastrey " ,
    " 1-Al-Arab Mall\n 2-San Carlo Cicchetti Restuarant\n",
    " 1-IHOP RestuarantIn\n 2Jeddah Boulevard\n 3-King Fahad Fountain"
    };
    
    String [] LjeddahScheduale = {
    "1-American Corner Restuarant\n 2-King Abdullah Economic city",
    "1-Atallah Happy Land ParkIn\n 2-FireGrill Restuarant\n",
    "1-Fakieh Aquarium\n 2-Zillion Restuarant\n",
    "1-IHOP Restuarant\n 2-AL-Tayebat international City",
    "1-Thoul BeachIn\n 2-Al Sayed SeaFood Restaurant\n",
    "1-Red Sea MallIn\n 2-Nando's\n 3- Roshn WaterFront\n",
    "1-Al-Arab MallIn\n 2-King Fahad FountainIn\n 3-Cup & Couch Cafe and Roastrey"
    };
    
    @Override
    public void printSchedule() {
        printSchedule(HjeddahScheduale, LjeddahScheduale);
    }
}

/* Subclass named Abha and extends to the Super class (Cities) */

class Abha extends Cities {
    String[] HabhaScheduale = {
              " 1-Al-Rashid Mall\n 2-Verde Restuarant"
             ," 1-Park Abha Mall\n 2-Red Basil Restuarant"
             ," 1-Le Voyage Restuarant\n 2-Abu Kheyal"
             ," 1-Paros Restuarant\n 2-Outstanding Station Wagons"
             ," 1-Giorno Coffe\n 2-Mystrey Restuarant"
             ," 1-Aya Sofya Restuarant\n 2-Dera Night"
             ," 1-Wooden Coffe\n 2-High City\n 3-Votel Coffe"
    };
    
    String[] LabhaScheduale = {
            "1-Al Tall Restuarant\n 2-Abha View"
             ," 1-Joy Venue\n 2-Al Rashid Mall\n 3-Peony Cafe"
             ," 1-Almaha Mall\n 2-View Cafe"
             ," 1-Al-Sahab Park\n 2-Black Box Cafe\n 3-Ala Bali Restuarant"
             ," 1-Damside Park\n 2-Will Cafe"
             ," 1-Arhab Restuarant\n 2-Jabal Sawda"
             ," 1-The Dabbab Walkway\n 2-Tonir Restuarant"
    };
    
    @Override
    public void printSchedule() {
        printSchedule(HabhaScheduale, LabhaScheduale);
    }
    
}

/* Subclass named Alula and extends to the Super class (Cities) */

class Alula extends Cities {
    String [] AlulaScheduale = {
        "1-The old city of AlUla\n 2-AlUla Museum\n 3- Go to the hotel (AlUla Mirrors)\n 4-Have dinner at Al Diwan Restaurant",
        "1-Madain Saleh\n 2-Dadan: It is an ancient Lihyanite city\n 3-Lunch: Al Manara Restaurant",
        "1-Elephant Rock: Take a tour to see the unique rock formation that resembles an elephant\n 2-Adventure activities: Enjoy activities like horse riding, dune bashing, and sandboarding in the desert\n 3-Dinner: Al-Fayrouz Restaurant",
        "1-AlUla Oasis\n 2- Madras Park\n 3-Go to AlUla Desert Resort\n 4-Have dinner at Al Khaira Restaurant",
        "1-Al-Hijr (Mada'in Saleh)\n 2-Wadi Al-Qura\n 3-Lunch: Mirror Hall",
        "Free Day \n",
        "1-Old railway station\n 2- Book a caravan in Al-Wadai and spend the rest of the day there"
    };
    
    @Override
    public void printSchedule() {
       Prnint(AlulaScheduale);
    }
}

/* Subclass named EasternProvince and extends to the Super class (Cities) */

class EasternProvince extends Cities {
    String[] HEasternScheduale = {
            "1-Arrival to Dammam Airport and entry to the (Sheraton Hotel)\n2-Have breakfast at the hotel\n3-Have lunch at( Lumiere) Restaurant\n4-Go shopping at( Nakheel Mall)\n",
            "1-Have breakfast at the hotel\n2-Go to( Paul Gardenia) Resort in Al Khobar and spend the day there\n",
            "1-Have breakfast at (Solas )Restaurant 2-Ithra visit\n3-Watch a movie at (Ajdan Walk Cinema)\n4-Have dinner at the hotel\n",
            "Free Day\n",
            "1-Have breakfast at the hotel\n2-Go shopping at (Dhahran Mall)\n3-Have dinner at (City Walk)\n",
            "1-Have lunch at (Parkers) Restaurant\n2-Visit the Scitech Museum\n3-Go to Deghaithir Island and enjoy the food and scenery\n",
            "1-Visit (Loupage) Water Games\n2-Go shopping at (Al Khobar Plaza)\n3-Have dinner at (Miso) Restaurant\n"
    };
    String[] LEasternScheduale = {
            "1-Arrival to Dammam Airport and entry to (Braira Hotel)\n2-Go to the beach\n3- Have dinner at(Onion Restaurant)\n",
            "1-Have breakfast at (Daily Rose) Restaurant\n2- Watch a movie at (Nakheel Mall Cinema)\n3- (Ithra visit)\n",
            "1-Have breakfast at the hotel\n 2- Visit (Half Moon) Bay and spend the day there\n3-Eat dinner at (McDonald's)\n",
            "Free day\n",
            "1- Visit (Al-Ahsa region)\n2- Visit the(date factory)\n3- Have lunch at (Erbil Restaurant)\n4-Visiting the (village markets in Al-Ahsa)\n",
            "1-Have breakfast (at City Walk)\n2- Go shopping at (Al Khobar Mall)\n3- Have dinner at (KFC)\n",
            "1-Visit (Lobo Jan Water Games)\n2- Have lunch at (Nando's)\n"
    };
    
    @Override
    public void printSchedule() {
        printSchedule(HEasternScheduale, LEasternScheduale);
    }
}

/* The class used for convert the currency */

class CurrencyC {
    static class Cconvert {
        String from;
        String to;
        double formela;
        
        public Cconvert(String from, String to, double formela) {
            this.from = from;
            this.to = to;
            this.formela = formela;
        }
        public double convert(double amount) {
            return amount * formela;
        }
    }
    
    /* Array of objects */
    
    private final Cconvert[] a;
    public CurrencyC() {
        this.a =new Cconvert[]{
                new Cconvert("USD", "SAR", 3.75), 
                new Cconvert("EUR", "SAR", 4.40)  
        };
    }
    
    /* convert the currency */
    
    public double convertC(double amount, String fromC, String toC) {
        for (Cconvert e : a) {
            if (e.from.equalsIgnoreCase(fromC) && e.to.equalsIgnoreCase(toC)) {
                return e.convert(amount);
            }
        }
        System.out.println("Invalid currency conversion."); /* Possibility of incorrect entry  */
        return 0; 
    }
}

/* Person class */

class Person {
     String name;
     int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


public class MTG{
    
    /* Self study , Recursion code */
    private static int sum(int age) {
        
            if (age > 0) {
                return age + sum(age - 1);
            } else {
                return 0;
            }
        }
    
    /* the main class */
    public static void main(String[] args) {
       Scanner rate = new Scanner(System.in); 
      /* Title of program */    
        System.out.println("                 MY TOUR GUIDE                  ");
        System.out.println("------------------------------------------------");
        

        /* Welcome massage */
        System.out.print("Please enter your name:   ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.print(" Gender?  (male / female) : ");
        String gen = input.next();
        if (gen.equals("female"))
            System.out.println(" Hi Ms " + name + " I'm Robot-20 and I will help you with your tour <3 ");
        if (gen.equals("male"))
            System.out.println(" Hi Mr " + name + " I'm Robot-20 and I will help you with your tour <3 ");

        
        System.out.println(" \n ");
        
        /* Currency Converter */
       Scanner scanner = new Scanner(System.in);
        CurrencyC C = new CurrencyC();
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Choose the currency to convert from (USD or EUR): ");
        String S = scanner.next().toUpperCase();
        double amountInSAR = C.convertC(amount, S, "SAR");
        if (amountInSAR != 0) {
            System.out.printf("%.3f %s is equal to %.3f SAR\n", amount, S, amountInSAR);
            System.out.println(" \n ");
            System.out.println("Enter your age: ");
            int age = input.nextInt();
            int result = sum(age);
        System.out.println("Congratulations, you have won a coupon equivalent \nthe sum of the numbers in your age : " + result );
        
        System.out.println(" \n ");

        if(age > 21){
            
        System.out.println("Please choose the city number you want : \n1- Abha \n2- Riyadh \n3- Jeddah \n4- AlUla \n5-Eastern Province ");
                int choice = input.nextInt();
                int budget = 0;
                Cities city;
                if (choice >= 1 && choice <= 5) {
                    
                    System.out.print("Enter your budget: ");
                    budget = input.nextInt();
                }
        
        switch (choice) {
            case 1 -> city = new Abha();
            case 2 -> city = new Riyadh();
            case 3 -> city = new Jeddah();
            case 4 -> city = new Alula();
            case 5 -> city = new EasternProvince();
            default -> {
                city = new Cities();
                System.out.println("Sorry, you did'n enter one of the five numbers try again....");
                }
        }
        city.setBudget(budget);
        city.printSchedule();
        
        System.out.println(" \n ");
      
       System.out.println("Would you like to exchange your schedule? (Yes/No)");
                input.nextLine();
                String Schoice = input.nextLine();

                if ("Yes".equalsIgnoreCase(Schoice)) {
    System.out.println("Please enter the number of cells to rotate:");
    int num = input.nextInt();
    String[] scheduleToRotate = city instanceof Riyadh ? ((Riyadh) city).HriyadhScheduale :
                                city instanceof Jeddah ? ((Jeddah) city).HjeddahScheduale :
                                city instanceof Abha ? ((Abha) city).HabhaScheduale :
                                city instanceof Alula ? ((Alula) city).AlulaScheduale :
                                city instanceof EasternProvince ? ((EasternProvince) city).HEasternScheduale : null;

    if (scheduleToRotate != null) {
        String[] rotatedSchedule = Cities.Rotate(scheduleToRotate, num);
        System.out.println("Your rotated schedule:");
        Cities.PrintRotatedSchedule(rotatedSchedule);
    } else {
        System.out.println("Invalid city type.");
       }
    }
    System.out.println(" \n ");
      
    /* Adding code */
        
    Person[] people = new Person[2];
    System.out.println("Do you want to add 2 persons to travel with you? (Yes/No)");
    String choiceToAdd = input.next(); 
    if ("Yes".equalsIgnoreCase(choiceToAdd)) {
        input.nextLine();
        for (int i = 0; i < 2; i++) {
        System.out.println("Enter the name for person " + (i + 1) + ":");
        String name1 = input.nextLine();

        System.out.println("Enter the age for person " + (i + 1) + ":");
        int age1 = input.nextInt();
        input.nextLine();
        Person person = new Person(name1, age1);
        people[i] = person;
        }
    }
    
    System.out.println(" \n ");
    
    /* Searching code */ 
     
        System.out.println("Please Enter the name to search for:");
        String searchName = input.nextLine();

        boolean found = false;
        for (Person person : people) {
        if (person != null && person.getName().equalsIgnoreCase(searchName)) {
          System.out.println("Found the person:");
          System.out.println("Name: " + person.getName());
          System.out.println("Age: " + person.getAge());
          found = true;
              break;
        }
    }
        if (!found) {
            System.out.println("Person not found.");
        }


 
    }
    else
    System.out.println("Sorry, user must be over 21 years old \n Try again next time....");   /* Possibility of incorrect entry  */
    } 
        
        
       /* Evaluation of the program from the user's point of view */
     System.out.println("Please rate your satisfaction with the flight schedule on a scale of 1 to 5, with 1 being very dissatisfied and 5 being very satisfied:");
        int flightScheduleSatisfaction = rate.nextInt();
        System.out.println("Please rate your satisfaction with the customer service on a scale of 1 to 5, with 1 being very dissatisfied and 5 being very satisfied:");
        int customerServiceSatisfaction = rate.nextInt();
        if (flightScheduleSatisfaction >= 4) {
            System.out.println("You were very satisfied with the flight schedule.");
        } else if (flightScheduleSatisfaction >= 3) {
            System.out.println("You were somewhat satisfied with the flight schedule.");
        } else {
            System.out.println("You were dissatisfied with the flight schedule.");
        }
        if (customerServiceSatisfaction >= 4) {
            System.out.println("You were very satisfied with the customer service.");
        } else if (customerServiceSatisfaction >= 3) {
            System.out.println("You were somewhat satisfied with the customer service.");
        } else {
            System.out.println("You were dissatisfied with the customer service.");
        }
        if (flightScheduleSatisfaction >= 3 && customerServiceSatisfaction >= 3) {
            System.out.println("Overall, you had a positive experience with the airline.");
        } else {
            System.out.println("Overall, you had a negative experience with the airline.");   
         
        
    }/* end of the main */
    
}}