import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Arrays;

class Aquarium {
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd(HH-mm)";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args) {
        int numberOfFish = 50, randomAge, randomType, randomAlive, randomColor;
        String fishType;
        String fileName;
        char fishColor;
        boolean fishAlive = false;
        PrintWriter print = null;
        fileName = now() + "output.txt";
        Fish[] tank = new Fish[numberOfFish];

        for (int i = 0; i < numberOfFish; i++) {
            randomType = (int) (Math.random() * 5) + 1;
            if (randomType == 1) fishType = "minnow";
            if (randomType == 2) fishType = "bass";
            if (randomType == 3) fishType = "gold";
            if (randomType == 4) fishType = "beta";
            else fishType = "pike";

            randomAge = (int) (Math.random() * 10) + 0;
            randomAlive = (int) (Math.random() * 2) + 1;
            if (randomAlive == 1) fishAlive = true;

            randomColor = (int) (Math.random() * 6) + 1;
            if (randomColor == 1) fishColor = 'r';
            else if (randomColor == 2) fishColor = 'b';
            else if (randomColor == 3) fishColor = 'p';
            else if (randomColor == 4) fishColor = 'y';
            else if (randomColor == 5) fishColor = 'o';
            else fishColor = 'g';

            tank[i] = new Fish(fishType, randomAge, fishAlive, fishColor);
        }

        //Arrays.sort(tank);

        try {
            print = new PrintWriter(new BufferedWriter(new FileWriter("output/" + fileName, true)));
        } catch (IOException iox) {
            System.out.println("Problem writing " + fileName);
        }
        print.println("#Fish Population in Order of Generation#");
        print.println("Fish Type" + "\t\t" + "Fish Age" + "\t\t" + "Fish Alive?" + "\t\t" + "Fish Color");
        print.println("=========" + "\t\t" + "========" + "\t\t" + "===========" + "\t\t" + "==========");
        for (int i = 0; i < numberOfFish; i++) {
            print.println(tank[i].getType() + "\t\t\t" + tank[i].getAge() + "\t\t\t\t" + tank[i].isAlive() + "\t\t\t" + tank[i].getColor());
        }
        print.println("==========================================================");
        Arrays.sort(tank);
        print.println("#Fish Population in Order of Age#");
        print.println("Fish Type" + "\t\t" + "Fish Age" + "\t\t" + "Fish Alive?" + "\t\t" + "Fish Color");
        print.println("=========" + "\t\t" + "========" + "\t\t" + "===========" + "\t\t" + "==========");
        for (int i = 0; i < numberOfFish; i++) {
            print.println(tank[i].getType() + "\t\t\t" + tank[i].getAge() + "\t\t\t\t" + tank[i].isAlive() + "\t\t\t" + tank[i].getColor());
        }
        print.println("==========================================================");
        print.println();
        print.close();

    }
}

class Fish implements Comparable<Fish> {
    private String type;
    private int age;
    private boolean alive;
    private char color;

    public Fish(String type, int age, boolean alive, char color) {
        setType(type);
        setAge(age);
        setAlive(alive);
        setColor(color);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public String getType() {
        return this.type;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public char getColor() {
        return this.color;
    }

    public int compareTo(Fish compareFish) {

        int compareAge = ((Fish) compareFish).getAge();

        //ascending order
        return this.age - compareAge;

        //descending order
        //return compareQuantity - this.quantity;

    }

//    public void bubbleSort(int[] arr) {
//        boolean swapped = true;
//        int j = 0;
//        int tmp;
//        while (swapped) {
//            swapped = false;
//            j++;
//            for (int i = 0; i < arr.length - j; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    tmp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = tmp;
//                    swapped = true;
//                }
//            }
//        }
//    }
//
//    public static double calcAverage(int[] people) {
//        double sum = 0;
//        for (int i = 0; i < people.length; i++) {
//            sum = sum + people[i];
//        }
//        double result = sum / people.length;
//        System.out.println(result);
//        return result;
//    }

//    int[] myPeople = {1,2,3,4,5,6,7,8};
//    double myPeopleAverage = calcAverage(myPeople);
}