public class Person {
    private int age;
    private boolean isStudent;

    public Person(){
        age = 0;
        isStudent = false;
    }

    public Person(int a){
        age = a;
        isStudent = false;
    }

    public Person(boolean s){
        age = 0;
        isStudent = s;
    }

    public Person(int a, boolean s){
        age = a;
        isStudent = s;
    }
}
