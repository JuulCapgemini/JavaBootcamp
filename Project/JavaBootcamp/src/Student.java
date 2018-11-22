package capgemini.academy.bootcamp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private ArrayList<Float> grades;
    private String[] names = {"Sjaak", "Peter", "Bernard", "Jan", "Sanne", "Potjandorie","Johnny","Bertha","Femke","Juul","Issabell"};

    public Student() {
        grades = new ArrayList<>();
    }

    public Student(int amountOfGrades) {
        grades = new ArrayList<>();
        //Random name from list
        SetName(names[RandomFunctions.RandomRangeInt(0,names.length-1)]);
        if (name.equals("Juul"))
        {
            for (int i = 0; i < amountOfGrades; i++) {
                GiveGrade(10);
            }
            System.out.println("Wow this student is amazing");
        }
        else {
            //Random grades based on given amount
            for (int i = 0; i < amountOfGrades; i++) {
                GiveGrade(RandomFunctions.RandomRangeFloat(0, 10));
            }
        }
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return this.name;
    }

    public void GiveGrade(float grade) {
        float newGrade = round(grade, 2);
        this.grades.add(newGrade);
        System.out.println("-- " + name + " has received a new grade: " + Float.toString(newGrade) + "! --");
    }

    public List<Float> GetGrades() {
        return Collections.unmodifiableList(grades);
    }

    private static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
