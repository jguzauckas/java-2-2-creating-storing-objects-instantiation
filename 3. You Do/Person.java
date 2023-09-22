public class Person {
    private int age;
    private boolean isStudent;
    private double heightInches;
    private int birthYear;

    public Person(){
        age = 0;
        isStudent = false;
        heightInches = 10.0;
        birthYear = 1900;
    }

    public Person(int a){
        age = a;
        isStudent = false;
        heightInches = 10.0;
        birthYear = 1900;
    }

    public Person(double h){
        age = 0;
        isStudent = false;
        heightInches = h;
        birthYear = 1900;
    }

    public Person(int a, int b){
        age = a;
        isStudent = false;
        heightInches = 10.0;
        birthYear = b;
    }

    public Person(boolean s, double h){
        age = 0;
        isStudent = s;
        heightInches = h;
        birthYear = 1900;
    }
    
    public Person(int a, double h, int b){
        age = a;
        isStudent = false;
        heightInches = h;
        birthYear = b;
    }

    public Person(int a, boolean s, double h, int b){
        age = a;
        isStudent = s;
        heightInches = h;
        birthYear = b;
    }
}
