class LinkedList
{
    Node headNode;

    public void add(int data)
    {
        if(this.headNode == null)
        {
            this.headNode = new Node(data);
        }
        else
        {
            Node nodeToAdd = new Node(data);
            nodeToAdd.next = this.headNode;
            this.headNode = nodeToAdd;
        }
    }

    public void addToEnd(int data)
    {
        Node nodeToAdd = new Node(data);

        if(this.headNode == null)
        {
            this.headNode = new Node(data);
        }
        else
        {
            Node currentNode = headNode;

            while(currentNode.next != null)
            {
                currentNode = currentNode.next;
            }

            currentNode.next = nodeToAdd;
        }
    }

    public String toString()
    {
        String toReturn = "[";
        Node currentNode = this.headNode;

        while (currentNode != null)
        {
            toReturn += currentNode.data;
            if (currentNode.next != null)
            {
                toReturn += ", ";
            }
            currentNode = currentNode.next;
        }
        toReturn += "]";

        return toReturn;
    }

    }

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();
        myList.add(10);
        myList.add(18);
        myList.addToEnd(15);

        System.out.println(myList);
        
    }
}
