import java.io.*;
class Aquarium
{
    public static void main ( String[] args )
    {
        int numberOfFish=50, randomAge, randomType,randomAlive,randomColor;
        String fishType;
        String fileName = "output.txt" ;
        char fishColor;
        boolean fishAlive=false;
        PrintWriter print = null;

        Fish [] tank= new Fish [numberOfFish];  //array of fish


        //fish tank gets filled up
        for(int i = 0; i < numberOfFish; i++)
        {
            randomType = (int)(Math.random()*2) + 1;
            if (randomType == 1)  fishType="minnow";
            else fishType="pike";

            randomAge = (int)(Math.random()*10) + 0;
            randomAlive = (int)(Math.random()*2) + 1;
            if (randomAlive==1)  fishAlive=true;

            randomColor = (int)(Math.random()*3) + 1;
            if (randomColor==1)  fishColor='r';
            else if (randomColor==2)  fishColor='b';
            else  fishColor= 'g';

            tank[i]=new Fish (fishType,randomAge, fishAlive, fishColor);   //each loop adds a new fish
        }

        try
        {
            print = new PrintWriter( new BufferedWriter( new FileWriter( fileName,true  ) ) );
        }
        catch ( IOException iox )
        {
            System.out.println("Problem writing " + fileName );
        }



        //this for loop just prints out the fish to the text file named output.txt
        for(int i = 0; i < numberOfFish; i++)
        { print.println( tank[i].getType() + "\t"  + tank[i].getAge()+ "\t"+ tank[i].isAlive() +"\t"+ tank[i].getColor() );
        }
        print.close();
    }
}


class Fish
{
    // data members
    private String type;
    private int age;
    private boolean alive;
    private char color;



    public Fish( String type, int age, boolean alive, char color )
    {
        setType( type );
        setAge( age );
        setAlive( alive );
        setColor( color );
    }
    // _________methods
    public void setType( String type )
    {
        this.type = type;
    }
    public void setAge( int age )
    {
        this.age = age;
    }
    public void setAlive( boolean alive )
    {
        this.alive = alive;
    }
    public void setColor( char color )
    {
        this.color = color;
    }
    // ________ methods
    public String getType() { return this.type; }
    public int getAge() { return this.age; }
    public boolean isAlive()  { return this.alive; }
    public char getColor() { return this.color; }
}