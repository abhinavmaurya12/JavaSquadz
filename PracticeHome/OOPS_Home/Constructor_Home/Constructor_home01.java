class Student
{
String Name;
int Age;
String College;
int Attendence;

Student(){ } //default 

Student(String n, int a, String c, int at){ //parameterized
Name=n;
Age=a;
College=c;
Attendence=at;
}

}

class Constructor_home01{
public static void main(String args[]){
	//student 1 details
Student s1= new Student("abhi",25,"iit",57);
System.out.println(s1.Name);
System.out.println(s1.Age);
System.out.println(s1.College);
System.out.println(s1.Attendence);

//student 2 details
Student s2=new Student("dk",25,"nit",67);
System.out.println(s2.Name);
System.out.println(s2.Age);
System.out.println(s2.College);
System.out.println(s2.Attendence);
}

}