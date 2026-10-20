import java.io.*;
//=======nodes
class Node
{
    Integer data;
    Node next;
}
//-----------Iterator
interface MyIterator
{
    boolean hasNext();
    Integer next();
}
//----------Mylinkedlist
class MyLinkedList implements MyIterator
{
    Node start=null;
    Node hsnxt,nxt;
    public MyIterator myiterator()
    {
        nxt=hsnxt=this.start;
        return this;
    }
    public boolean hasNext()
    {
        boolean flag=false;
        if(this.hsnxt!=null)
        {
            flag=true;
            this.hsnxt=this.hsnxt.next;
        }
        return flag;
    }
    public Integer next()
    {
        Integer o=nxt.data;
        nxt=nxt.next;
        return o;
    }
    public boolean isEmpty()
    {
        boolean flag=false;
        if(start==null)
            flag=true;
        return flag;
    }
// adding at first index-----------------
    public void addFirst(Integer o)
    {
        Node d=new Node();
        d.data=o;
        if(start==null)
        {
            start=d;
            d.next=null;
        }
        else
        {
            d.next=start;
            start=d;
        }
    }
//-------adding elemnt at last index=---------
    public void addLast(Integer o)
    {
        Node d=new Node();
        d.data=o;
        d.next=null;
        if(start==null)
        {
            start=d;
        }
        else
        {
            Node var=start;
            while(var.next!=null)
            {
                var=var.next;
            }
            var.next=d;
        }
    }
// going to last element-----------

    public Integer getFirst()
    {
        return start.data;
    }
//going to to firt position-------------------
    public Integer getLast()
    {
        Node var=start;
        while(var.next!=null)
        {
            var=var.next;
        }
        return var.data;
    }
//------------deleting first element--------
    public Integer removeFirst()
    {
        Integer o=null;
        if(start!=null)
        {
            o=start.data;
            start=start.next;
        }

        return o;
    }
//-----------------deleting last element=======
    public Integer removeLast()
    {
        Integer o=null;
        Node var=start;
        if(var.next==null)
        {
            start=null;
        }
        else if(var!=null)
        {
            while((var.next).next!=null)
            {
                var=var.next;
            }
            o=var.next.data;
            if(var.next==start)
            {
                start=null;
            }
          
            o=var.next.data;
            if(var.next==start)
            {
                start=null;
            }
            var.next=null;
        }
        return o;
    }
//------------Sorting---------------------------------------------------
    public void shot()
    {
        Node p = start;
        Node k;
        Integer temp;
        while (p != null)
        {
            k = p.next;
            while (k != null)
            {
                if(p.data>k.data)
                {
                // Swap data values
                    temp = p.data;
                    p.data = k.data;
                    k.data = temp;
                }
                k = k.next;
            }
            p = p.next;
        }
    }
//--------------------decending-----------------
public void dec()
    {
        Node p = start;
        Node k;
        Integer temp;
        while (p != null)
        {
            k = p.next;
            while (k != null)
            {
                if(p.data<k.data)
                {
                // Swap data values
                    temp = p.data;
                    p.data = k.data;
                    k.data = temp;
                }
                k = k.next;
            }
            p = p.next;
        }
    }
//----------reverse-----------------------
    public void rev()
    {
        Node p = start;
        Node pre=null;
        Node temp;
        while (p != null)
        {
            temp=p.next;
            p.next=pre;
            pre=p;
            p=temp;
        }
        start=pre;
    }
// ------------search---------------------------
public boolean serch( int x)
    {
        Node p = start;
        boolean flag=false;
        while(p!=null)
        {
            if(p.data==x)
            {
                flag=true;
                break;
            }
        p=p.next;
        }
        return flag;
    }
//------------search and replace---------------------------
public boolean serchreplace( int x, int y)
    {
        boolean flag=false;
        Node p = start;
        while(p!=null)
        {
            if(p.data==x)
            {
                p.data=y;
                flag=true;
                break;
            }
        p=p.next;
        }
        return flag;
    }
}
//=----------------------------------
class MyListAsignShubham
{
    MyLinkedList elmnt=new MyLinkedList();
    public static void main(String... s)throws IOException
    {
        MyListAsign obj=new MyListAsign();
        int ch,ch1=0;
        String str;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        for(;;)
        {
            System.out.println("Menu of the operartion  for DQ");
            System.out.println("1. ADD\n2. Delete\n3. Display\n4. Sort\n5. reverse\n6. Search\n7. search&replace \n8. Exit ");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(sc.readLine());
            switch(ch)
            {
                case 1:
                for(;;)
                {
                    obj.clrscr();
                    System.out.println("Select the position for adding the next element");
                    System.out.println("1. Front-end\n2. Rear-end\n3. Back to main menu");
                    System.out.println("Enter your choice");
                    ch1=Integer.parseInt(sc.readLine());
                    switch(ch1)
                    {
                        case 1:
                        System.out.println("Enter your int Data to insert");
                        str=sc.readLine();
                        obj.elmnt.addFirst(Integer.parseInt(str));
                        break;
//-----------------end of first case sub menu----------------------
                        case 2:
                        System.out.println("Enter your int Data to insert");
                        str=sc.readLine();
                        obj.elmnt.addLast(Integer.parseInt(str));
                        break;
//-----------------end of second case sub menu----------------------
                        case 3:
                        break;
//-----------------end of third case sub menu----------------------
                        default:
                        System.out.println("You have enter wrong choice");
                    }
                    if(ch1==3)
                    {
                        break;
                    }
                    try
                    {
                        System.out.println("Adding the element wait........");
                        Thread.sleep(4000);
                    }
                    catch(Exception e)
                    {
                    }
                    obj.clrscr();
                }
                break;
//------------------------end of first case main menu----------------------------------------
                case 2:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Delete");
                }
                else
                {
                    for(;;)
                    {
                        obj.clrscr();
                        if(obj.elmnt.isEmpty()==false)
                        {
                            System.out.println("select the position to delete the element");
                            System.out.println("1. front-end\n2. Rear-end\n3. Back");
                            System.out.println("Enter your choice");
                            ch1=Integer.parseInt(sc.readLine());
                            switch(ch1)
                            {
                                case 1:
                                obj.elmnt.removeFirst();
                                break;
//---------------end of first case sub menu----------------------
                                case 2:
                                obj.elmnt.removeLast();
                                break;
//---------------end of second case sub menu----------------------
                                case 3:
                                break;
//---------------end of third case sub menu----------------------
                                default:
                                System.out.println("you enter the wrong choice");
                            }
                        }
                        else
                        {
                            System.out.println("there is no element present first create ");
                            obj.clrscr();
                            break;
                        }
                        if(ch1==3)
                        break;
                        try
                        {
                            System.out.println("Deleting the element wait........");
                            Thread.sleep(4000);
                        }
                        catch(Exception e)
                        {
                        }
                        obj.clrscr();
                    }
                }
//------------------------end of second case main menu----------------------------------
                case 3:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Display");
                }
                else
                {
                    System.out.println("Content of the list");
                    MyIterator it=obj.elmnt.myiterator();
                    while(it.hasNext())
                    {
                        System.out.print(it.next());
                        System.out.print(", ");
                    }
                }
                break;
//------------------------end of third case main menu----------------------------------
                case 4:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Shorting");
                }
                else
                {
                    for(;;)
                    {
                        obj.clrscr();
                        System.out.println("HOw to Short");
                        System.out.println("1. accending\n2. Decending\n3. Back to main menu"
                        );
                        System.out.println("Enter your choice");
                        ch1=Integer.parseInt(sc.readLine());
                        switch(ch1)
                        {
                            case 1:
                            obj.elmnt.shot();
                            break;
//--------------end of first case sub menu----------------------
                            case 2:
                            obj.elmnt.dec();
                            break;
//--------------end of second case sub menu----------------------
                            case 3:
                            break;
////--------------end of third case sub menu----------------------
                            default: System.out.println("you have entered wrong choice");
                        }
                        if(ch1==3)
                        break;
                        try
                        {
                            System.out.println("Shorting the elements wait........");
                            Thread.sleep(4000);
                        }
                        catch(Exception e)
                        {
                        }
                            obj.clrscr();
                    }
                }
                break;
//-----------------------end of fourth case main menu----------------------------------------
                case 5:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Reverse");
                }
                else
                obj.elmnt.rev();
                break;
//------------------end of fifth case main menu-------------------------------------
                case 6:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Search");
                }
                else
                {
                    System.out.println("Enter data to search");
                    ch1=Integer.parseInt(sc.readLine());
                    if(obj.elmnt.serch(ch1))
                    {
                        System.out.println("data Is Available");
                        System.out.println("Content of the list");
                        MyIterator it=obj.elmnt.myiterator();
                        while(it.hasNext())
                        {
                            System.out.print(it.next());
                            System.out.print(", ");
                        }
                    }
                    else
                        System.out.println("data Is NOt Available");
                }
                break;
//--------------------end of sixth case main menu----------------------
                case 7:
                if(obj.elmnt.isEmpty())
                {
                    System.out.println("Nothing to Search");
                }
                else
                {
                    System.out.println("Enter data to search");
                    ch=Integer.parseInt(sc.readLine());
                    System.out.println("Enter new data");
                    ch1=Integer.parseInt(sc.readLine());
                    if(obj.elmnt.serchreplace(ch,ch1))
                    {
                        System.out.println("New  linklist data Is:");
                        System.out.println("Content of the list");
                        MyIterator it=obj.elmnt.myiterator();
                        while(it.hasNext())
                        {
                            System.out.print(it.next());
                            System.out.print(", ");
                        }
                    }
                    else
                        System.out.println("data Is NOt Available");
                }
                break;
//-----------------------end of seventh case main menu-------------------------


case 8:
				System.exit(0);
//-----------------------end of eight case main menu--------------------------------
				default: System.out.println("you have entered wrong choice");
			}
			System.out.println("wait getting back......");
			try
			{
				Thread.sleep(4000);
			}
			catch(Exception e)
			{
			}
			obj.clrscr();
		}
	}
	void clrscr()
	{
		for(int i=0;i<50;i++)
		{
			System.out.println("\n");
		}
	}
}

          