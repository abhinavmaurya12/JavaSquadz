package MyAnnoLab;

public class LabRun {
    public static void main(String[] args) {
        LabData ld=new LabData();
        Class c=ld.getClass();
        System.out.println("Class Name: "+ c.getName());

        AnnoLab al=(AnnoLab) c.getAnnotation(AnnoLab.class);

        System.out.println("Lab: "+al.name1()+" Lab Time: "+al.TimePM1()+" PM");
        System.out.println("Lab: "+al.name2()+" Lab Time: "+al.TimePM2()+" PM");
        System.out.println("Lab: "+al.name3()+" Lab Time: "+al.TimePM3()+" PM");
    }
}
