class Human
{
private int age;
private String name;

//get
public String getName(){
return name;
}
//set
public void setName(String n){
	name=n;
}

//get
public int getAge(){
	return age;
}
//set
public void setAge(int a){
	age=a;
}
}



class Encapsulation_home01
{
public static void main(String args[]){

Human obj =new Human();
obj.setName("abhinav");
obj.setAge(23);

Human gt=new Human();
gt.setAge(24);
gt.setName("abhi");

System.out.println(obj.getName()+" :: "+obj.getAge());
System.out.println(gt.getName()+" :: "+gt.getAge());

}
}



// class Human
// {
// int age;
// String name;
// }

// class Encapsulation_home01
// {
// public static void main(String args[]){

// Human obj =new Human();
// obj.age=10;
// obj.name="abhi";

// System.out.print(obj.name);
// }
// }
