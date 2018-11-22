import capgemini.academy.bootcamp.*;
import capgemini.academy.bootcamp.Student;
import capgemini.academy.bootcamp.time.MonthBlock;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Float.NEGATIVE_INFINITY;
import static java.lang.Float.POSITIVE_INFINITY;

public class Main {
    public static final String file1 =
            "C:/Users/jlenders/IdeaProjects/Car/src/capgemini/academy/bootcamp/resources/test.txt";
    public static final String file2 =
            "C:/Users/jlenders/IdeaProjects/Car/src/capgemini/academy/bootcamp/resources/test.txt WRONG";

    public static void main(String[] args) {
        boolean stop = false;

        while (!stop) {
            System.out.println("---------------------------------");
            System.out.println("-------------Welcome-------------");
            System.out.println("---------------------------------");
            System.out.println(" ");
            System.out.println("Type 'beer' to start beer simulation");
            System.out.println("Type 'vehicle' to start vehicle simulation");
            System.out.println("Type 'animal' to start animal simulation");
            System.out.println("Type 'try' to start Try Catch simulation");
            System.out.println("Type 'college' to start the College simulation");
            System.out.println("Type 'time' to start the time simulation");
            System.out.println("Type 'calender' to start the calender simulation");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("beer")) {
                BeerSimulation();
            } else if (input.equalsIgnoreCase("vehicle")) {
                VehicleSimulation();
            } else if (input.equalsIgnoreCase("animal")) {
                AnimalSimulation(sc);
            } else if (input.equalsIgnoreCase("shape")) {
                ShapeSimulation();
            } else if (input.equalsIgnoreCase("try")) {
                TryCatchSimulation();
            } else if (input.equalsIgnoreCase("college")) {
                CollegeSimulation(sc);
            } else if (input.equalsIgnoreCase("time")) {
                TimeSimulator();
            } else if (input.equalsIgnoreCase("calender")) {
                CalenderSimulator();
            } else {
                System.out.println("I don't run that program");
            }
            System.out.println(" ");
            System.out.println("---------------------------------");
            System.out.println("Do you want to restart? (Y/N)");
            System.out.println("---------------------------------");
            //Receive new input
            input = sc.nextLine();

            if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                System.out.println(" ");
                System.out.println("---------------------------------");
                System.out.println("--------------End----------------");
                System.out.println("---------------------------------");
                System.out.println(" ");
                stop = true;
            }
        }
        //Stop thread
        System.exit(1);
    }

    private static void BeerSimulation() {
        Beer beer = new capgemini.academy.bootcamp.Beer();
    }

    private static void VehicleSimulation() {
        //int amountOfVehicles = input.
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Vehicle();
        System.out.println("We now create a vehicle with unique variables");
        vehicles[1] = new Vehicle("Sjaak z'n bak", "Capgemini", "Sjaak Jansen");
        vehicles[2] = new capgemini.academy.bootcamp.vehicles.MotorCycle();
        System.out.println("There are " + Integer.toString(vehicles.length) + " vehicles created!");
    }

    private static void AnimalSimulation(Scanner sc) {
        //For exercise we don't import Animal
        capgemini.academy.bootcamp.inheritance.Animal[] Animals = new capgemini.academy.bootcamp.inheritance.Animal[2];
        Animals[0] = new capgemini.academy.bootcamp.inheritance.Human();
        Animals[1] = new capgemini.academy.bootcamp.inheritance.Crocodile();
        for (capgemini.academy.bootcamp.inheritance.Animal animal : Animals) {
            PrintAnimal(animal, sc);
        }
        //Using static variables
        System.out.println("In total there are " + Animals[0].animalCount + " animal (parents).");
    }

    private static void PrintAnimal(capgemini.academy.bootcamp.inheritance.Animal animal, Scanner sc) {
        System.out.println("A " + animal.GetName() + " is a " + animal.GetAnimalKind());
        System.out.println("Do you want the " + animal.GetName() + " to breed? (Y/N)");
        //Input!
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("y")) {
            animal.Breed();
        }
        System.out.println(" ");
    }

    private static void ShapeSimulation() {
        new capgemini.academy.bootcamp.shape.Rectangle();
        new capgemini.academy.bootcamp.shape.Circle();
    }

    private static void TryCatchSimulation() {
        System.out.println("\nFirst a working file.");
        try {
            Exception(file1);
        } catch (LibraryException e) {
            e.printStackTrace();
        }
        System.out.println("\nNow a non existing file.");
        try {
            Exception(file2);
        } catch (LibraryException e) {
            e.printStackTrace();
        }
        System.out.println("\nFinally a non permissioned file");
        try {
            Exception("C:/swapfile.sys");
        } catch (LibraryException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nNow a simple null pointer exception");
        String x = null;
        String y = "";
        try {
            System.out.println(x.equals(y));
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }
    }

    private static void Exception(String file) throws LibraryException {

        try {
            Stream<String> lines = Files.lines(Paths.get(file));
            System.out.println(lines.collect(Collectors.joining("\n")));
            System.out.println("No exception");
        } catch (NoSuchFileException e) {//FileNotFoundException
            //e.printStackTrace();
            //System.out.println("File not found!");
            throw new LibraryException("This file does not exist.", e);
        } catch (FileSystemException e) {//e.printStackTrace();
            throw new LibraryException("File found but can't access it.", e);
        }
        //System.out.println("Found file but can't access it");}
        catch (IOException e) {
            throw new LibraryException("Other exception.", e);
                /*
                e.printStackTrace();
                System.out.println("An exception\nreturn code here;");
                return;*/
        } finally {
            System.out.println("Always executed");
        }
        System.out.println("Post try catch");
    }

    private static void CollegeSimulation(Scanner sc) {
        System.out.println("---------------------------------");
        System.out.println("\nWelcome to the College simulation\n");
        System.out.println("---------------------------------");
        ArrayList<Student> students = new ArrayList<>();
        //System.out.println("Created a list of students");
        boolean stop = false;
        while (!stop) {
            System.out.println("type 'add' to add a new student.\ntype 'random' to add a random student with random grades.\ntype 'print' to show the results!\ntype 'clear' to purge your college.\ntype 'stop' to return to simulation select.");

            //INPUT
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("add")) {

                //New student
                System.out.println("-- New student added to your college! --");
                Student newStudent = new Student();
                students.add(newStudent);

                //Name
                NameStudent(sc, newStudent);

                //Give grade
                GiveGrade(sc, newStudent);

            } else if (input.equalsIgnoreCase("random")) {
                //New random student
                System.out.println("-- New random student added to your college! --");
                Student newStudent = new Student(RandomFunctions.RandomRangeInt(1, 10));
                students.add(newStudent);
                PrintStudent(newStudent);
                System.out.println(" ");
            } else if (input.equalsIgnoreCase("print")) {
                //Print students
                PrintStudents(students);
            } else if (input.equalsIgnoreCase("clear")) {
                //Clear list
                System.out.println("-- Your college is now empty! --\n");
                students.clear();
            } else if (input.equalsIgnoreCase("stop")) {
                //Return to Simulation select
                stop = true;
            } else {
                System.out.println("\nI don't recognize that input\n");
            }

        }
    }

    private static void NameStudent(Scanner sc, Student newStudent) {
        System.out.println("\nGive the student a name! Type in anyting and press enter.\n");
        String input = sc.nextLine();
        newStudent.SetName(input);
        System.out.println("-- The student's name is: " + newStudent.GetName() + " --");
    }

    private static void GiveGrade(Scanner sc, Student newStudent) {
        //Give grade
        float newGrade = -1;
        boolean givingGrades = true;
        boolean correctInput = false;
        String input;

        while (givingGrades) {
            while (!correctInput) {

                System.out.println("\n Give the student a grade. Type in any number");

                try {
                    newGrade = sc.nextFloat();
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("That is not a valid number.\nTry again? (Y/N)");
                    sc.nextLine();
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("y"))
                        continue;
                    else
                        break;
                }/* finally {DEBUG input
                        System.out.println(Float.toString(newGrade));
                    }*/
                if (newGrade < 0) {
                    System.out.println("You can't give a grade below 0");
                } else if (newGrade > 10) {
                    System.out.println("You can't give a grade above 10");
                } else {
                    correctInput = true;
                }
            }
            if (correctInput) {
                newStudent.GiveGrade(newGrade);
                System.out.println("\n" + newStudent.GetName() + " has these grades: ");
                for (float grade : newStudent.GetGrades()) {
                    System.out.println("  * " + Float.toString(grade));
                }
                sc.nextLine();
                //sc.nextFloat();
                boolean restarting = true;
                while (restarting) {
                    System.out.println("\nDo you want to add another grade? (Y/N)");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("y")) {
                        correctInput = false;
                        restarting = false;
                    }//Reset the grade input while loop
                    else if (input.equalsIgnoreCase("n")) {
                        givingGrades = false;
                        restarting = false;
                    } else {
                        System.out.println("Thats not Y or N.\n");
                    }
                }
            }
        }
    }

    private static void PrintStudent(Student student) {
        float max = MaximumFloat(student.GetGrades());
        float min = MinimumFloat(student.GetGrades());
        PrintStudent(student, min, max);
    }

    private static void PrintStudent(Student student, float max, float min) {
        //Print name
        System.out.println(student.GetName());

        //Print student grades
        System.out.println("  Grades: ");
        for (float grade : student.GetGrades()) {
            System.out.println("   * " + Float.toString(grade));
        }

        System.out.println("  Highest grade: " + Float.toString(max));
        System.out.println("  Lowest grade: " + Float.toString(min));
        System.out.println("  Average grade: " + Float.toString(AverageFloat(student.GetGrades())));
    }

    private static float AverageFloat(List<Float> numbers) {
        float total = 0;
        for (float number : numbers) {
            total += number;
        }
        return total / (float) numbers.size();
    }

    private static float MinimumFloat(List<Float> numbers) {
        float min = POSITIVE_INFINITY;
        for (float number : numbers) {
            if (number < min)
                min = number;
        }
        return min;
    }

    private static float MaximumFloat(List<Float> numbers) {
        float max = NEGATIVE_INFINITY;
        for (float number : numbers) {
            if (number > max)
                max = number;
        }
        return max;
    }

    private static void PrintStudents(ArrayList<Student> students) {
        System.out.println("---------------------------------");

        if (students.size() == 1)
            System.out.println("There is " + students.size() + " student in your college!");
        else
            System.out.println("There are " + students.size() + " students in your college!\n");

        if (students.size() > 0) {
            System.out.println("The name of each student and their grades: ");

            ArrayList<Float> totalGrades = new ArrayList<>();

            //Data for highest and lowest scoring students
            ArrayList<String> lowestScoringStudents = new ArrayList<>();
            float lowestGrade = POSITIVE_INFINITY;
            ArrayList<String> highestScoringStudents = new ArrayList<>();
            float highestGrade = NEGATIVE_INFINITY;

            for (Student student : students) {
                System.out.println(" ");
                //Add student grades to total grades
                totalGrades.addAll(student.GetGrades());

                float max = MaximumFloat(student.GetGrades());
                float min = MinimumFloat(student.GetGrades());

                //Print student grades
                PrintStudent(student, min, max);

                //Update lowest scoring student
                if (min < lowestGrade) {
                    lowestGrade = min;
                    lowestScoringStudents.clear();
                    lowestScoringStudents.add(student.GetName());
                } else if (min == lowestGrade) {
                    lowestScoringStudents.add(student.GetName());
                }

                //Update highest scoring student
                if (max > highestGrade) {
                    highestGrade = max;
                    highestScoringStudents.clear();
                    highestScoringStudents.add(student.GetName());
                } else if (min == lowestGrade) {
                    highestScoringStudents.add(student.GetName());
                }
            }
            //Print totals
            System.out.println("\n-- Totals --");
            //Highest grade
            float max = MaximumFloat(totalGrades);
            System.out.println("\nTotal highest grade: " + Float.toString(max));
            //The highest score belongs to!...
            PrintHighestScoringStudent(highestScoringStudents);

            //Lowest grade
            float min = MinimumFloat(totalGrades);
            System.out.println("\nTotal lowest grade: " + Float.toString(min));
            //The lowest score belongs to!...
            PrintLowestScoringStudent(lowestScoringStudents);
            //Average
            System.out.println("\nTotal average grade: " + Float.toString(AverageFloat(totalGrades)));//TODO: round average?


        } else {
            System.out.println("Start adding some students to your college!\n");
        }
        System.out.println("---------------------------------\n");
    }

    private static void PrintLowestScoringStudent(List<String> lowestScoringStudents) {
        if (lowestScoringStudents.size() > 1) {
            System.out.println("The lowest scoring students are: ");
            for (String student : lowestScoringStudents) {
                System.out.println("   * " + student);
            }
        } else {
            System.out.println("The lowest scoring student is:");
            System.out.println("   * " + lowestScoringStudents.get(0));
        }
    }

    private static void PrintHighestScoringStudent(List<String> highestScoringStudents) {
        if (highestScoringStudents.size() > 1) {
            System.out.println("The highest scoring students are: ");
            for (String student : highestScoringStudents) {
                System.out.println("   * " + student);
            }
        } else {
            System.out.println("The highest scoring student is:");
            System.out.println("   * " + highestScoringStudents.get(0));
        }
    }


    private static void TimeSimulator() {
        capgemini.academy.bootcamp.time.TimeTest time = new capgemini.academy.bootcamp.time.TimeTest();
    }

    private static void CalenderSimulator() {
        //TODO: input year, Ma Di Wo... next to block, weeknumber
        //Create months
        MonthBlock[] months = new MonthBlock[12];
        for (int i = 0; i < 12; i++) {
            months[i] = new MonthBlock(i + 1);
        }
        //String title;
        StringBuilder[] sbTitles = new StringBuilder[3];
        for (int i = 0; i < sbTitles.length; i++) {
            sbTitles[i] = new StringBuilder();
        }
        //String days
        StringBuilder[] sbDays = new StringBuilder[5 * 3];
        for (int i = 0; i < sbDays.length; i++) {
            sbDays[i] = new StringBuilder();
        }

        int i = 0;
        int j = 0;
        int dayRow = 0;
        int dayRowIncrementer = 0;

        for (MonthBlock month : months) {
            //Loop title
            sbTitles[j].append(month.GetTitle());//add titles next to each other
            i++;
            if (i > 3) {
                i = 0;
                j++;//new row
            }

            //Loop days content for this month
            for (int l = 0; l < month.GetMonthDays().length; l++) {
                sbDays[dayRow + l].append(month.GetMonthDays()[l]);
            }

            //Number of month blocks in a row
            if (dayRowIncrementer >= 3) {
                /*Three blocks have been added to the proper list.
                Now we add these to our 'row origin' which each month then offsets again
                 */
                dayRow += 5;//There are 5 rows of days per month block. We just finished a row of blocks increment by 5
                dayRowIncrementer = 0;//Reset the month block counter
            } else
                dayRowIncrementer++;

        }

        //Print
        int dayRowPrint = 0;
        for (StringBuilder sbTitle : sbTitles) {
            System.out.println(sbTitle.toString());
            //Per title 5 rows of days
            for (int m = 0; m < 5; m++) {
                System.out.println(sbDays[dayRowPrint].toString());
                dayRowPrint++;
            }
        }
    }


    //LIBRARY EXCEPTION CLASS
    private static class LibraryException extends Exception {
        private LibraryException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


