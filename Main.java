abstract class List {
    abstract void add(int data);
    abstract public void addToEnd(int data);
    abstract public Node deleteAtStart();
    abstract public Node deleteAtEnd();
    abstract public Node deletaAtIndex(int indexToDelete);
    abstract public void print();
    abstract public Node search(int dataRequired);
    abstract public Node searchAtIndex(int indexToSearch);
    abstract public String toString();
}


class LinkedList extends List
{
    Node headNode;
    Node tailNode;

    int totalNodes = 0;

    public void add(int data)
    {
        Node nodeToAdd = new Node(data);
        
        if(this.headNode == null)
        {
            this.headNode = nodeToAdd;
            this.tailNode = nodeToAdd;
        }
        else
        {
            nodeToAdd.next = this.headNode;
            this.headNode = nodeToAdd;
        }
        totalNodes++;

    }

    public void addToEnd(int data)
    {
        Node nodeToAdd = new Node(data);

        if(this.headNode == null)
        {
            this.headNode = new Node(data);
            this.tailNode = new Node(data);
        }
        else
        {
            tailNode.next = nodeToAdd;
            tailNode = nodeToAdd;
        }
       totalNodes++;
    }

    public Node deleteAtStart()
    {
        Node nodeToDelete = headNode;

        if(headNode!=null)
        {
            if(headNode.next != null)
            {
                headNode = headNode.next;
                totalNodes--;
            }
            else
            {
                headNode = null;
                tailNode = null;
                totalNodes--;
            }
        }
        else
        {
            System.out.println("List is empty");
        }
        return nodeToDelete;
    }

    public Node deleteAtEnd()
    {
        Node nodeToDelete = headNode;

        if(headNode!=null)
        {
            if(headNode.next != null)
            {   Node previousNode = null;
                while(nodeToDelete != tailNode)
                {
                    previousNode = nodeToDelete;
                    nodeToDelete = nodeToDelete.next;
                }
                previousNode.next = null;
                tailNode = previousNode;
                totalNodes--;
            }
            else
            {
                headNode = null;
                tailNode = null;
                totalNodes--;
            }
        }
        else
        {
            System.out.println("List is empty");
        }
        return nodeToDelete;
    }


    public Node deletaAtIndex(int indexToDelete)
    {
        int indexCounter = 1;
        Node nodeToDelete = headNode;
        Node previousNode = null;

        if(indexToDelete == 1)
        {
            nodeToDelete = this.deleteAtStart();
        }
        else if(indexToDelete == totalNodes)
        {
            nodeToDelete = deleteAtEnd();
        }
        else if(headNode != null)
        {
            while(indexCounter != indexToDelete)
            {
                previousNode = nodeToDelete;
                nodeToDelete = nodeToDelete.next;
                indexCounter++;
            }
            Node nextNode = nodeToDelete.next;
            previousNode.next = nextNode;
            totalNodes--;
        }
        else
        {
            System.out.println("List is empty");
        }
        return nodeToDelete;
    }

    // public Node deleteNodeWithValue(int valueToDelete)
    // {
    //     Node nodeToDelete = null;
    //
    //
    //     return nodeToDelete;
    // }


    public Node search(int dataRequired)
    {
        Node returnNode = null;
        Node currentNode = headNode;

        while (currentNode != null)
        {
            if (currentNode.data == dataRequired)
            {
                return currentNode; // exits the function
            }
            currentNode = currentNode.next;
        }

        return returnNode;
    }

    public Node searchAtIndex(int indexToSearch)
    {
        Node returnNode = null;
        Node currentNode = headNode;

        int indexCounter = 1;

        while (currentNode != null)
        {
            if (indexCounter == indexToSearch)
            {
                return currentNode; // exits the function
            }
            currentNode = currentNode.next;
            indexCounter++;
        }

        return returnNode;
    }

    public void print()
    {   
        String toPrint = "";
        Node currentNode = this.headNode;

        if(headNode != null)
        {
            while (currentNode != null)
            {
                toPrint += currentNode.data;
                if (currentNode.next != null)
                {
                    toPrint += "->";
                }
                currentNode = currentNode.next;
            }
        }
        else
        {
            toPrint = "The List is empty";
        }

        System.out.println(toPrint);
    }

    public String toString()
    {
        String toReturn = "[";
        Node currentNode = this.headNode;

        if(headNode != null)
        {
            while (currentNode != null)
            {
                toReturn += currentNode.data;
                if (currentNode.next != null)
                {
                    toReturn += ", ";
                }
                currentNode = currentNode.next;
            }
        }

        toReturn += "]";

        return toReturn;
    }
}

class Node
{
    int data;
    Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    // Node(int data , Node next)
    // {
    //     this.data = data;
    //     this.next = next;
    // }
}

public class Main
{
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();
        myList.add(10);
        myList.add(18);
        myList.addToEnd(15);

        myList.print();

        System.out.println(myList);

        Node myNode = myList.search(10);
        System.out.println(myNode.data);

        myNode = myList.searchAtIndex(3);
        System.out.println(myNode.data);

        myList.addToEnd(20);
        myList.addToEnd(25);
        myList.addToEnd(30);

        myList.print();

        myNode = myList.deleteAtStart();

        myList.print();

        myNode = myList.deleteAtEnd();

        myList.print();

        myNode = myList.deletaAtIndex(2);

        myList.print();
        
    }
}
