package com.example.caloriecalculator;

public class Person {

    private int age;
    private int activityLevel;
    private boolean isMale;
    private double weight;
    private double height;



    public Person(int age, int activityLevel, boolean isMale, double weight, double height) {
        this.age = age;
        this.activityLevel = activityLevel;
        this.isMale = isMale;
        this.weight = weight;
        this.height = height;
    }

    //Returns the amount of calories required for maintaining current weight.
    public int calculateCalories() {
        double bmr;
        double maintenanceCalories = 0;
        int maintenanceCaloriesResult;

        //Calculation for men using Mifflin-St Jeor Equation.
        if(isMale = true) {
            bmr = 10*this.weight + 6.25*this.height - 5*this.age + 5;
        } else {
            //Calculation for women using Mifflin-St Jeor Equation.
            bmr = 10*this.weight + 6.25*this.height - 5*this.age - 161;
        }

        //Finalise calorie calculation based on activity level
        switch (activityLevel) {
            //BMR
            case 0:
                maintenanceCalories = bmr;
                break;
            //Sedentary
            case 1:
                maintenanceCalories = bmr * 1.2;
                break;
            //Light
            case 2:
                maintenanceCalories = bmr * 1.35;
                break;
            //Moderate
            case 3:
                maintenanceCalories = bmr * 1.5;
                break;
            //Active
            case 4:
                maintenanceCalories = bmr * 1.7;
                break;
            //Very Active
            case 5:
                maintenanceCalories = bmr * 1.9;
                break;
        }
        maintenanceCaloriesResult = (int) Math.round(maintenanceCalories);
        return maintenanceCaloriesResult;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return age + "" + activityLevel + "" + isMale + "" + weight + "" + height;
    }
}
