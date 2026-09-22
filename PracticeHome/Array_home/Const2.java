package PracticeHome.OOPS_Home.Constructor_Home;

public class Const2 {
    public static void main(String args[]){
    
    Student s1 = new Student("ram", 21, 234);

    System.out.println(s1.name);
       System.out.println(s1.age);
       System.out.println(s1.rollNumber);
       
     
    }
}

class Student{
    String name;
    int age;
    int rollNumber;

    Student(){ //default construtor

    }

    Student(String n, int a, int rn) {
        name = n;
        age = a;
        rollNumber = rn;
    }



}
