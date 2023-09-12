import java.text.DecimalFormat;
import java.util.*;

public class ReviewProject {
    // The scanner that will be used to solve most of the problems
    Scanner scan = new Scanner(System.in);
    // The method that starts the program and solves all the problems
    public void startProgram(){
        // Start the program at the main menu
        mainMenu(scan);
    }
    // Main menu
    public void mainMenu(Scanner scanner){
        System.out.println("Welcome to the menu, which problem would you like to see get solved? (Enter number)");
        System.out.println("1. Data Caster");
        System.out.println("2. Grade Calculator");
        System.out.println("3. Number Gap");
        System.out.println("4. Guess the number");
        System.out.println("5. Tax Calculator");
        System.out.println("6. Value Organizer");
        System.out.println("7. Create Person");
        System.out.println("8. Exit");
        int selection = scanner.nextInt();
        // Clear scanner data
        scanner.nextLine();
        // All the options for the user to select
        switch (selection){
            case 1:
                problemOne();
                break;
            case 2:
                problemTwo();
                break;
            case 3:
                problemThree();
                break;
            case 4:
                problemFour();
                break;
            case 5:
                problemFive();
                break;
            case 6:
                problemSix();
                break;
            case 7:
                problemSeven();
                break;
            case 8:
                break;
            default:
                System.out.println("You did not enter a valid selection!");
                System.out.println(" ");
                mainMenu(scanner);
        }
    }

    // All the methods that solve a problem for the project
    public void problemOne(){
        System.out.println("Data Caster (Problem One)");
        castData(scan);
        mainMenu(scan);
    }
    public void problemTwo(){
        System.out.println("Grade Calculator (Problem Two)");
        gradeCalculator(scan);
        mainMenu(scan);
    }
    public void problemThree(){
        System.out.println("Number Gap (Problem Three)");
        numberGap(scan);
        mainMenu(scan);
    }
    public void problemFour(){
        System.out.println("Guess the number (Problem Four)");
        guessingGame(scan);
        mainMenu(scan);
    }
    public void problemFive(){
        System.out.println("Tax Calculator (Problem Five)");
        taxCalculator(scan);
        mainMenu(scan);
    }
    public void problemSix(){
        System.out.println("Value Organizer (Problem Six)");
        valueOrganizer(scan);
        mainMenu(scan);
    }
    public void problemSeven(){
        System.out.println("Create Person (Problem Seven)");
        createPerson(scan);
        mainMenu(scan);
    }
    // Cast data method to solve problem one
    public void castData(Scanner scanner){
        System.out.println("Input integer value to cast");
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Current value is set to int");
        System.out.println("What would you like to cast to? (case sensitive)");
        System.out.println("Float");
        System.out.println("Double");
        System.out.println("String");
        // See what type user decides to cast their int to
        String typeInput = scanner.nextLine();
        // Float
        if(Objects.equals(typeInput, "Float")) {
            float castedFloatInput = (float)input;
            System.out.println("Inputted data is now " + castedFloatInput);
        }
        // Double
        if(Objects.equals(typeInput, "Double")){
            double castedDoubleInput = (double)input;
            System.out.println("Inputted data is now " + castedDoubleInput);
        }
        // String
        if(Objects.equals(typeInput, "String")){
            String castedStringInput = String.valueOf(input);
            System.out.println("Inputted data is now " + castedStringInput);
        }
    }
    // Grade calculator to solve problem 2
    public void gradeCalculator(Scanner scanner){
        System.out.println("Enter your numerical score (double)");
        double score = scanner.nextDouble();
        // Assign the user their grade
        if(score <= 0) {
            System.out.println("Incomplete or missing (I)");
        }
        if(score > 88 && score <= 100){
            System.out.println("A");
        }
        if (score < 88 && score >= 73){
            System.out.println("B");
        }
        if (score < 73 && score >= 50){
            System.out.println("C");
        }
        if (score <= 50 && score > 0){
            System.out.println("F");
        }
        if(score > 100){
            System.out.println("S, greater than 100!");
        }
        // Clear data in the scanner
        scanner.nextLine();
    }
    // Number gap method to solve problem 3
    public void numberGap(Scanner scanner){
        System.out.println("Enter low number");
        int low = scanner.nextInt();
        System.out.println("Enter high number");
        int high = scanner.nextInt();
        System.out.println("Enter a gap number");
        int gap = scanner.nextInt();
        for(int i = low; i <= high; i+=gap){
            System.out.println(i);
        }
        // Clear data in the scanner
        scanner.nextLine();
    }
    // Guessing game to solve problem 4
    public void guessingGame(Scanner scanner){
        Random rand = new Random();
        // Random number
        int randomnum = rand.nextInt(20) + 1;
        // Booleans to prevent hints being printed multiple times
        boolean hint1 = false;
        boolean hint2 = false;
        // Attempts the user has done, starting from 0
        int attempts = 0;
        attempts += 1;
        // Prompt the user to guess
        System.out.println("Enter your guess, the number is in between 1 and 20 (int)");
        int guess = scanner.nextInt();
        // While their guess is wrong
        while(guess != randomnum){
            // Tell them it's wrong
            System.out.println("Nope!");
            // Increase attempts by one
            attempts += 1;
            // Let them guess again
            guess = scanner.nextInt();

            // Give the user their first hint
            if (attempts == 3 && !hint1){
                if(randomnum >= 10){
                    System.out.println("Hint: The number is greater than or equal to ten");
                }
                else{
                    System.out.println("Hint: The number is less than ten");
                }
                hint1 = true;
            }
            // Give the user their second hint (even or odd)
            if (attempts == 5 && !hint2){
                if (randomnum % 2 == 0){
                    System.out.println("Hint: The number is even");
                }
                else {
                    System.out.println("Hint: The number is odd");
                }
                hint2 = true;
            }
        }
        // Congratulate the user if they guess correctly
        if(guess == randomnum){
            System.out.println("You guessed correct! The number was " + randomnum);
            // Get rid of any data in the scanner
            scanner.nextLine();
        }

    }
    // Tax calculator to solve problem 5
    public void taxCalculator(Scanner scanner){
        System.out.println("Enter the cost of your item ($)");
        double cost = scanner.nextDouble();
        System.out.println("Enter the tax percentage you will be paying on the item (do not include percent sign)");
        double tax = scanner.nextDouble();
        double taxMultiplier = 1 + tax * 0.01;
        double costAfterTax = cost * taxMultiplier;
        // Create a decimal format to keep the cost after tax to two decimal places and prevent printing issues
        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("The cost after tax for your item will be $" + df.format(costAfterTax));
        System.out.println("Would you like to see how much of this item you can afford? (case sensitive)");
        System.out.println("Yes");
        System.out.println("No");
        String selection = scanner.next();
        // if the user says yes, give them the option to check, no ends the program
        if (Objects.equals(selection, "Yes")){
            System.out.println("Enter your bank balance ($)");
            double bankBalance = scanner.nextDouble();
            int quantity = (int) (bankBalance / costAfterTax);
            System.out.println("You can afford " + quantity);
        }
        // Clear data in the scanner
        scanner.nextLine();
    }
    // Value organizer for problem 6
    public void valueOrganizer(Scanner scanner){
        // Create the list for the users values
        List<Integer> values = new ArrayList<>();
        // Keep the program running as long as the user likes
        boolean running = true;
        // Prompt them to enter values
        System.out.println("Enter as many ints as you like, type 'stop' to stop, minimum of at least three!");
        // While running
        while(running){
            String input = scanner.next();
            // If the user decides to input stop
            if (input.equals("stop")){
                // stop running the input loop
                running = false;
                processResults(values);
                // Clear data in scanner
                scanner.nextLine();
            }
            else{
                try {
                    values.add(Integer.parseInt(input));
                }
                catch (Exception exception){
                    System.out.println("Your value caused an exception");
                }
            }
        }
    }

    List<Integer> convertValues(List<String> stringVals)
    {
        List<Integer> newVals = new ArrayList<>();
        // For every object in the list
        for (String s : stringVals){
            newVals.add(Integer.parseInt(s));
        }
        return newVals;
    }

    void processResults(List<Integer> values)
    {
        // initialize the minimum, maximum, and average values
        double min;
        double max;
        double average = 0;
        // sort in natural order
        values.sort(Comparator.naturalOrder());
        // set min to position 0
        min = values.get(0);
        // set max to what ever the last element in the list is
        max = values.get(values.size() - 1);
        // add every value to average
        for (double i : values){
            average += i;
        }
        // divide average by the list element size
        average /= values.size();
        System.out.println("The lowest value you entered was " + min);
        System.out.println("The highest value you entered was " + max);
        System.out.println("The average of your values is " + average);
    }


    // Person class for problem seven
    class Person {
        String name;
        String favoriteQuote;
        int age;
        // Constructor
        public Person(String name, String favoriteQuote, int age)
        {
            this.name = name;
            this.favoriteQuote = favoriteQuote;
            this.age = age;
        }
        // Getters and setters for instance variables
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFavoriteQuote() {
            return favoriteQuote;
        }

        public void setFavoriteQuote(String favoriteQuote) {
            this.favoriteQuote = favoriteQuote;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    // Create a person method for problem 7
    public void createPerson(Scanner scanner){
        // Create their person
        System.out.println("Create your own person!");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter favourite quote");
        String favoriteQuote = scanner.nextLine();
        System.out.println("Enter age");
        int age = scanner.nextInt();
        scanner.nextLine();
        Person person = new Person(name,favoriteQuote,age);
        System.out.println("Successfully created " + person.getName());
        // Take them to the person menu after creating their person
        personMenu(person, scanner);
    }
    // Person menu for problem 7
    public void personMenu(Person person, Scanner scanner){
        System.out.println("Would you like to: (Enter Number)");
        System.out.println("1. Edit " + person.getName());
        System.out.println("2. See attributes of " + person.getName());
        System.out.println("3. Exit program");
        int selection = scanner.nextInt();
        // Clear data in the scanner
        scanner.nextLine();
        switch (selection) {
            case 1 -> editPerson(person, scanner);
            case 2 -> seeAttributes(person, scanner);
            // Take them back to the main menu in case they decide to exit
            case 3 -> mainMenu(scanner);
            default -> {
                System.out.println("You did not enter a valid selection!");
                System.out.println(" ");
                personMenu(person, scanner);
            }
        }
    }
    // Edit person for problem 7
    public void editPerson(Person person, Scanner scanner){
        System.out.println("What would you like to edit about " + person.getName() + " (select with number)");
        System.out.println("1. Name");
        System.out.println("2. Favorite Quote");
        System.out.println("3. Age");
        System.out.println("4. Exit editing menu");
        int selection = scanner.nextInt();
        // Clear data in the scanner
        scanner.nextLine();
        // Give the user the option to edit any of the attributes of their person
        switch (selection){
            case 1:
                System.out.println("Input the new name you'd like for " + person.getName());
                String newName = scanner.nextLine();
                person.setName(newName);
                System.out.println("Name was successfully changed to " + person.getName());
                editPerson(person, scanner);
                break;
            case 2:
                System.out.println("Input the new favorite quote you'd like for " + person.getName());
                String newQuote = scanner.nextLine();
                person.setFavoriteQuote(newQuote);
                System.out.println("Quote was successfully changed to " + person.getFavoriteQuote());
                editPerson(person, scanner);
                break;
            case 3:
                System.out.println("Input the new age you'd like for " + person.getName());
                int newAge = scanner.nextInt();
                scanner.nextLine();
                person.setAge(newAge);
                System.out.println("Age was successfully changed to " + person.getAge());
                editPerson(person, scanner);
                break;
            case 4:
                // Take them back to the person menu in case they decide to exit
                personMenu(person, scan);
            default:
                System.out.println("You did not enter a valid selection!");
                System.out.println(" ");
                editPerson(person, scanner);
                break;
        }
    }
    // See attributes of a person, also for problem 7
    public void seeAttributes(Person person, Scanner scanner){
        // Shwo the user the attribute of their person depending on what they input
        System.out.println("What attribute would you like to see?");
        System.out.println("1. Name");
        System.out.println("2. Favorite Quote");
        System.out.println("3. Age");
        System.out.println("4. Exit attributes menu");
        int selection = scanner.nextInt();
        scanner.nextLine();
        switch (selection) {
            case 1 -> {
                System.out.println("The name of this person is " + person.getName());
                seeAttributes(person, scanner);
            }
            case 2 -> {
                System.out.println("The favorite quote of this person is " + person.getFavoriteQuote());
                seeAttributes(person, scanner);
            }
            case 3 -> {
                System.out.println("The age of this person is " + person.getAge());
                seeAttributes(person, scanner);
            }
            // Take them back to the person menu in case they decide to exit
            case 4 -> personMenu(person, scanner);
            default -> {
                System.out.println("You did not enter a valid selection!");
                System.out.println(" ");
                seeAttributes(person, scanner);
            }
        }
    }
}