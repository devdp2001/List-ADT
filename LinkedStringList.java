package cs1302.list;
 
import cs1302.listadt.StringList;
import cs1302.listadt.StringList.Node;

/**
 * The Linkedstringlist class that implements the StringList interface.
 */
public class LinkedStringList implements StringList {
 
    StringList.Node linkedList; //instance that create the LinkedStringList Node.
    private int size; //instance variable for the size of the list.

    
    /**
     * This constructor creates a LinkedStringList object.
     */
    public LinkedStringList() {
        // creating new StringList
        linkedList = new StringList.Node();
    }

    /**
     * Constructor that takes the parameter of StringList type and creates
     * a deep copy for a LinkedStringList object.
     * 
     * @param other StringList that has String values in it.    
     */
    public LinkedStringList(StringList other) {
        String end = null;
        
        linkedList = new StringList.Node();
        StringList.Node placeHolder = linkedList;

        for (int i = 0; i < other.size(); i++) {
            String nodeValue = other.get(i);

            placeHolder.setNext(new StringList.Node(nodeValue, null));
            placeHolder = placeHolder.getNext();
        } //for loop
    } //constructor

    /**
     * Inserts the specified string at the specified position in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(int index, String s) {
        boolean add = false;

        //exception handling if statement 
        if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            if (index == 0) {
                StringList.Node listHead = new StringList.Node();
                StringList.Node temporaryNode = new StringList.Node(s, linkedList.getNext());

                listHead.setNext(temporaryNode);
                linkedList = listHead;
            } else if (index == size()) {
                add(s);
            } else {
                StringList.Node listHead = linkedList.getNext();

                for (int i = 0; i < index - 1; i++) { 
                    listHead = listHead.getNext();
                }
                StringList.Node listTail = new StringList.Node(s, listHead.getNext());
                listHead.setNext(listTail); 
            }
            add = true;
        }
        return add;
    }
    
    /**
     * Inserts the strings containefd in the specified list at the
     * specified position in this list, in the order in which they
     * appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(int index, StringList sl) {
        boolean add = false;

        //exception handling if statement
        if (sl == null) {
            throw new NullPointerException("StringList Parameter is null.");
        } else if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            if (index == size()) {
                add(sl);
            } else {
                StringList.Node listHead = linkedList.getNext();

                for (int i = 0; i < index - 1; i++) {
                    listHead = listHead.getNext();
                }
                StringList.Node listTail = listHead.getNext(); 

                for (int i = 0; i < sl.size(); i++) { 
                    listHead.setNext(new StringList.Node(sl.get(i)));
                    listHead = listHead.getNext();
                } 
                listHead.setNext(listTail);
                add = true;
            } 
        }
        return add;
    }
    
    /**
     * Appends the specified string to the end of this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(String s) {
        boolean add = false;
        String end = null;

        //exception handling if statement 
        if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            StringList.Node placeHolder = linkedList;

            while (placeHolder.getNext() != null) {
                placeHolder = placeHolder.getNext();
            }
            placeHolder.setNext(new StringList.Node(s, null));
            add = true;
        }
        return add;
    }

    /**
     * Appends the strings contained in the specified list to the end of this list,
     * in the order in which they appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(StringList sl) {
        boolean add = false;
        String end = null;

        //exception handling if statement 
        if (sl == null) {
            throw new NullPointerException("StringList Parameter is null.");
        } else {
            StringList.Node placeHolder = retrieveNode(size());
            for (int i = 0; i < sl.size(); i++) {
                placeHolder.setNext(new StringList.Node(sl.get(i), null));
                placeHolder = placeHolder.getNext();
            }
            add = true;
        }
        return add;
    }

    /**
     * Removes all of the Strings from this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public void clear() {
        StringList.Node clearedList = new StringList.Node();
        linkedList = clearedList;
    }

    /**
     * Returns true if this list contains the specified string.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean contains(String o) {
        boolean contains = false;

        //exception handling if statement 
        if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(get(i))) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    /**
     * Returns true if this list contains the specified string, ignoring case.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean containsIgnoreCase(String o) {
        boolean contains = false;

        //exception handling if statement 
        if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equalsIgnoreCase(get(i))) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    /**
     * Returns true if this list contains the specified substring.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean containsSubstring(String o) {
        boolean contains = false;

        //exception handling if statement 
        if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (get(i).contains(o)) {
                    contains = true;
                }
            }
            return contains;
        }
        
    }

    /**
     * Builds and returns a new StringList without any duplicate strings.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList distinct() {
        StringList distinctLinked = new LinkedStringList();
        StringList.Node placeHolder = linkedList.getNext();

        for (int i = 0; i < size(); i++) {
            if (distinctLinked.indexOf(placeHolder.getStr()) == -1) {
                distinctLinked.add(placeHolder.getStr());
            }
            placeHolder = placeHolder.getNext();
        }
        return distinctLinked;
    }

    /**
     * Returns the string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public String get(int index) {
        String getIndex = "";

        //exception handling if statement 
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else {
            StringList.Node placeHolder = linkedList.getNext(); 

            for (int i = 0; i < index; i++) {
                placeHolder = placeHolder.getNext();
            }
            getIndex = placeHolder.getStr();
        }
        return getIndex;        
    }

    /**
     * Returns the index of the first occurrence of the specified string in this list,
     * or -1 if this list does not contain the string.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOf(String s) {
        int indexOf = -1;

        //exception handling if statement 
        if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (s.equals(get(i))) {
                    indexOf = i;
                }
            }
        }
        return indexOf;
    }

    /**
     * Returns the index of the first occurence of the specified string, ignoring case,
     * in this list, or -1 if this does not contin the string.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOfIgnoreCase(String s) {
        int indexOfIgnoreCase = -1;

        //exception handling if statement 
        if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (s.equalsIgnoreCase(get(i))) {
                    indexOfIgnoreCase = i;
                }
            }
        }
        return indexOfIgnoreCase;
    }
    
    /**
     * Returns true if this list contains no elements.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        boolean isEmpty = false;

        //checking size to see whether list is empty or not
        if (size() == 0) {
            isEmpty = true;
        } else if (size() != 0) {
            isEmpty = false;
        }
        return isEmpty; 
    }

    /**
     * Returns a string representation of this list with every string in
     * the sequence seperated by the specified separator string.
     *
     * <p>
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        String makeString = "";
        int counter = 0;
        int counter2 = 0;
        
        if (size() == 0) {
            counter++;
        } else {
            for (int i = 0; i < size() - 1; i++) {
                makeString += get(i);
                makeString += sep;
                counter2++;
            }
            makeString += get(size() - 1);
        }
        return makeString;
    }

    /**
     * Removes the string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public String remove(int index) {
        String removedString = "";

        //exception handling if statement 
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else {
            StringList.Node listHead = linkedList.getNext();
            if (index == 0) { 
                removedString = listHead.getStr();
                linkedList = listHead;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    listHead = listHead.getNext();
                }
                removedString = listHead.getNext().getStr();
        
                StringList.Node listTail = listHead.getNext().getNext();
                listHead.setNext(listTail);
            }
        }
        return removedString;
    }

    /**
     * Builds and returns a new StringList that contains the strings
     * from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList reverse() {
        StringList reverseLinked = new LinkedStringList();

        for (int i = size() - 1; i >= 0; i--) {
            reverseLinked.add(get(i));
        }
        return reverseLinked;
    }

    /**
     * Replaces the string at the specified position in this list with the specified element.
     *
     * <p>
     * {@inheritDoc}
     */
    public String set(int index, String s) {
        String replaced = "";

        //exception handling if statement 
        if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            StringList.Node placeHolder = retrieveNode(index + 1);

            replaced = placeHolder.getStr();
            placeHolder.setStr(s);
        }
        return replaced;
    }

    /**
     * Returns the number of elements in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public int size() {
        int size = 0;
        
        StringList.Node placeHolder = linkedList.getNext();

        //checking through list, and counting non null values to find size
        while (placeHolder != null) {
            placeHolder = placeHolder.getNext();
            size++;
        }
        return size;
    }
    
    /**
     * Builds and returns a new StringList that contains the strings from this
     * list between the specified index's.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList splice(int fromIndex, int toIndex) {
        StringList spliceList = new LinkedStringList();

        //exception handling if statement 
        if ((fromIndex < 0) || (toIndex > size()) || (fromIndex > toIndex)) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            for (int i = fromIndex; i < toIndex; i++) {
                spliceList.add(get(i));
            }
        }
        return spliceList;
    }

    /**
     * Returns a new array containing all of the strings in this list in proper sequence.
     *
     * <p>
     * {@inheritDoc}
     */
    public String[] toArray() {
        String[] toArrayList = new String[size()];

        for (int i = 0; i < size(); i++) {
            toArrayList[i] = get(i);
        }
        return toArrayList;
    }
    
    /**
     * Method that returns a reference in the linked list
     * at the index from the parameter.
     *
     * @param index the index of the node
     * @return the reference to the node
     */
    private StringList.Node retrieveNode(int index) {
        StringList.Node testNode;
        
        if (size() == 0) {
            testNode = linkedList;
        } else {
            testNode = linkedList.getNext();
            for (int i = 0; i < index - 1; i++) {
                testNode = testNode.getNext();
            }
        }
        return testNode;
    }
} //LinkedStringList
