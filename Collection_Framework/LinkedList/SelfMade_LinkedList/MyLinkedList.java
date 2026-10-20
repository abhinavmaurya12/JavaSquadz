class Link {
  public int iData;

  public Link next;

  public Link(int id) {
    iData = id;
  }

  public String toString() {
    return "{" + iData + "} ";
  }
}

class LinkList {
  private Link first;

  public LinkList() {
    first = null;
  }

  public boolean isEmpty() {
    return (first == null);
  }

  public void insertFirst(int id) {
    Link newLink = new Link(id);
    newLink.next = first;
    first = newLink;
  }

 public Link deleteFirst()
{
    Link temp = first;
    first = first.next;
    return temp;
  }

 public String toString() {
    String str = "";
    Link current = first;
    while (current != null) {
      str += current.toString();
      current = current.next;
    }
    return str;
  }
}

public class MyLinkedList
{
  public static void main(String[] args)
  {
    LinkList theList = new LinkList();

    theList.insertFirst(22);
    theList.insertFirst(44);
    theList.insertFirst(66);
    theList.insertFirst(88);

    System.out.println(theList);
System.out.println(theList.deleteFirst());
 System.out.println(theList);
    while (!theList.isEmpty()) {
      Link aLink = theList.deleteFirst();
      System.out.print("Deleted " + aLink);
      System.out.println("");
    }
    System.out.println(theList);
  }
}
