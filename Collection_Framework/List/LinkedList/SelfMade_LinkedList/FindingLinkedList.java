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

  public Link delete(int key)
{
    Link current = first;
    Link previous = first;
    while (current.iData != key)
{
      if (current.next == null)
        return null;
      else {
        previous = current;
        current = current.next;
      }
    }
    if (current == first)
      first = first.next;
    else
      previous.next = current.next;
    return current;
  }

  public Link find(int key)
  {
    Link current = first;

    while (current.iData != key) {
      if (current.next == null)
        return null;
      else
        current = current.next;
    }
    return current;
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

public class FindingLinkedList
{
  public static void main(String[] args)
  {
    LinkList theList = new LinkList();

    theList.insertFirst(22);
    theList.insertFirst(44);
    theList.insertFirst(66);
    theList.insertFirst(88);

    System.out.println(theList);
Link ln=theList.find(44);
    System.out.println(ln);

    Link aLink = theList.delete(44);

    System.out.println(theList);
  }
}
