package cs1302.list;

import cs1302.listadt.StringList;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

/**
 * The ArrayStringList class that implements the StringList interface.
 */
public class ArrayStringList implements StringList {
    
    private String[] arrayList; //instance String Array is initialized.
    private int size = 0; //instance variable that shows size of list.
    private int initialVariable = 2; //instance variable for the initial length of the array.
    
    /**
     * The implementing class that explicitly defines a default constructor.
     */
    public ArrayStringList() {
        //initializing ArrayStringList 
        arrayList = new String[initialVariable];
    }

    /**
     * The implementing class the explicitly defines a copy constructor.
     *
     * @param other The StringList that will be set to the ArrayStringList.
     */
    public ArrayStringList(StringList other) {
        arrayList = new String[other.size()];

        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = other.get(i);
        }
    }

    /**
     * Inserts the specified string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(int index, String s) {
        boolean add = false;

        //exception handling if statement 
        if ((index < 0) || (index > arrayList.length)) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else {
            int size;

            if (size() == 0) {
                size = 1;
            } else {
                size = size();
            }
            int holder = 0;
            String[] placeHolderArrayList = new String[size + 2];

            //for loop taking in values up to the index
            for (int i = 0; i < index; i++) {
                if (arrayList[i] != null) {
                    placeHolderArrayList[i] = arrayList[i];
                    holder++;
                }
            }
            //adding in new String
            placeHolderArrayList[holder] = s;
            
            for (int i = holder + 1; i < arrayList.length; i++) {
                if (arrayList[i] != null) {
                    placeHolderArrayList[i] = arrayList[i];
                }
            }
            int anotherHolder = 0;
            
            for (int i = 0; i < placeHolderArrayList.length; i++) {
                if (placeHolderArrayList[i] != null) {
                    anotherHolder++;
                }
            }
            String[] replicatedArray = new String[anotherHolder];
            
            for (int i = 0; i < replicatedArray.length; i++) {
                replicatedArray[i] = placeHolderArrayList[i];
            }
            
            arrayList = replicatedArray;
            add = true;
        }
        return add;
    }

    /**
     * Inserts the strings contained in the specified list at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(int index, StringList sl) {
        boolean add = false;

        //exception handling if statement 
        if ((index < 0) || (index >= arrayList.length)) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else if (sl == null) {
            throw new NullPointerException("StringList Parameter is null.");
        } else {
            int holder = 0;
            String[] placeHolderArrayList = new String[sl.size() + size()];
           
            for (int i = 0; i < index; i++) {
                placeHolderArrayList[i] = arrayList[i];
                holder++;
            }
            
            for (int j = 0; j < sl.size(); j++) {
                placeHolderArrayList[holder] = sl.get(j);
                holder++;
            }
            
            for (int k = index; k < size(); k++) {
                placeHolderArrayList[holder] = arrayList[k];
                holder++;
            }
            arrayList = placeHolderArrayList;
            add = true;
        }
        return add;
    }

    /**
     * Appends the specified string to the end of the list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(String s) {
        boolean add = false;
        
        add(size(), s);
        add = true;
        return add;
    }

    /**
     * Appends the strings contained in the specified list to the end of this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean add(StringList sl) {
        boolean add = false;

        //exception handling if statement 
        if (sl == null) {
            throw new NullPointerException("StringList Parameter is null.");
        } else {
            int holder = 0;
            String[] placeHolderArrayList = new String[sl.size() + this.size()];
           
            for (int i = 0; i < size(); i++) {
                placeHolderArrayList[i] = arrayList[i];
                holder++;
            }
            for (int j = 0; j < sl.size(); j++) {
                placeHolderArrayList[holder] = sl.get(j);
                holder++;
            }
            arrayList = placeHolderArrayList;
            add = true;
        }
        return add;
    }

    /**
     * Removes all of the strings from this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public void clear() {
        String[] clearedList = new String[size()];
        arrayList = clearedList;
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
        if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (arrayList[i].equals(o)) {
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
        boolean containsIgnoreCase = false;

        //exception handling if statement 
        if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (arrayList[i].equalsIgnoreCase(o)) {
                    containsIgnoreCase = true;
                }
            }
        }
        return containsIgnoreCase;
    }

    /**
     * Returns true if any string in this list contains the specified substring.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean containsSubstring(String o) {
        boolean containsSubstring = false;

        //exception handling if statement 
        if (o.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if (o == null) {
            throw new NullPointerException("String Parameter is null.");
        } else {
            for (int i = 0; i < size(); i++) {
                if (arrayList[i].contains(o)) {
                    containsSubstring = true;
                }
            }
        }
        return containsSubstring;
    }

    /**
     * Builds and returns a new StringList from this list without any duplicate strings.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList distinct() {
        StringList distinctArray = new ArrayStringList();

        for (int i = 0; i < size(); i++) {
            if (distinctArray.indexOf(arrayList[i]) == -1) {
                distinctArray.add(arrayList[i]);
            }
        }
        return distinctArray;
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
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            getIndex = arrayList[index];
        }
        return getIndex;
    }

    /**
     * Returns the index of the first occurence of the specified string,
     * or -1 if it is not in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOf(String s) {
        int index = -1;

        //exception handling if statement
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {

            //for loop finding first instance of the String parameter
            for (int i = 0; i < size(); i++) {
                if (s.equals(get(i))) {
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Returns the index of the first occurence of the specified string,
     * ignoring case, or -1 if it is not in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOfIgnoreCase(String s) {
        int index = -1;
        
        //exception handling if statement                                                         
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
           
            //for loop finding first instance of the String parameter                             
            for (int i = 0; i < size(); i++) {
                if (s.equalsIgnoreCase(get(i))) {
                    index = i;
                }
            }
        }
        return index;
    }
    
    /**
     * Returns true if this list contains no elements.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        boolean isEmpty = false;

        //checking size of StringList to see if it is empty
        if (size() == 0) {
            isEmpty = true;
        } else if (size() != 0) {
            isEmpty = false;
        }
        return isEmpty;
    }
    
    /**
     * Returns a string representation of this list with all
     * of strings directly concatenated in order.
     *
     * <p>
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        String makeString = "";
        int holder = 0;

        //for loop making that creates the string of the StringList with a seperator
        for (int i = 0; i < size() - 1; i++) {
            makeString += arrayList[i];
            makeString +=  sep;
            holder++;
        }
        makeString += arrayList[holder];
        
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
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            removedString = arrayList[index];
            String[] placeHolderArrayList = new String[size() - 1];

            for (int i = 0; i < index; i++) {
                placeHolderArrayList[i] = arrayList[i];
            }
            for (int j = index + 1; j < arrayList.length; j++) {
                placeHolderArrayList[j - 1] = arrayList[j];
            }
            arrayList = placeHolderArrayList;
        } 
        return removedString;
    }

    /**
     * Builds and returns a new StringList that contains
     * the strings from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList reverse() {
        StringList reverseList = new ArrayStringList();

        for (int i = size() - 1; i >= 0; i--) {
            reverseList.add(arrayList[i]);
        }
        return reverseList;
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
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String Parameter is empty.");
        } else if (s == null) {
            throw new NullPointerException("String Parameter is null.");
        } else {
            replaced = arrayList[index];
            arrayList[index] = s;
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

        //finding non-null values in array length to find size of array
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * Builds and returns a new StringList that contains the strings between the index's.
     *
     * <p>
     * {@inheritDoc}
     */
    public StringList splice(int fromIndex, int toIndex) {
        StringList spliceArray = new ArrayStringList();

        //exception handling if statement
        if ((fromIndex < 0) || (toIndex > size()) || (fromIndex > toIndex)) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else {
            for (int i = fromIndex; i < toIndex; i++) {
                spliceArray.add(arrayList[i]);
            }
        }
        return spliceArray;
    }

    /**
     * Returns a new array containing all of the strings in this list in proper sequence.
     *
     * <p>
     * {@inheritDoc}
     */
    public String[] toArray() {
        String[] toArray = new String[size()];
        
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                toArray[i] = arrayList[i];
            }
        }
        return toArray;
    }                 
} //ArrayStringList 
