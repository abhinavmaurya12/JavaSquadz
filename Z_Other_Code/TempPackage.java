// package
import java.awt.*;
import java.util.*;

class TempPackage
{
public static void main(String args[])
{
Frame f1=new Frame();
Date d1=new Date();

//without import before class
java.util.Date d=new java.util.Date();
java.sql.Date d2=new java.sql.Date();
}
}