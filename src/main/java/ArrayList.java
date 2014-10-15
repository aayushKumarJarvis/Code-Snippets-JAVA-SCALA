import java.util.Arrays;

public class ArrayList {

    private Object[] arrayForData;
    private int specifiedSize = 0;

    private static final int DEFAULT_CAPACITY = 16;

    /*
    Construct a default array of size 16
     */
    public ArrayList() {
        arrayForData = new Object[DEFAULT_CAPACITY];
    }

    /*
    Construct array for specified size

    @params specifiedCapacity reads the input capacity of the array
    */
    public ArrayList(int specifiedCapacity) {
        if (specifiedCapacity < 0)
            throw new IllegalArgumentException();
        else
            arrayForData = new Object[specifiedCapacity];
    }

    /*
    Dynamic increase in the size of array in case the size exceeds the default capacity
     */
    public void increaseArraySize() {
        arrayForData = Arrays.copyOf(arrayForData, arrayForData.length * 2);
    }

    /*
    Returns the location of the specified element in the array

    @params e read an element as Object
     */
    public int indexOf(Object e) {
        for (int i = 0; i < specifiedSize; i++)
            if (e.equals(arrayForData[i]))
                return i;
        return -1;
    }

    /*
    Checks the presence and absence of an element

    @params e read an element as Object
     */
    public boolean containsElement(Object e) {
        return indexOf(e) != -1;
    }

    /*
    Checks if the ArrayList is empty
     */
    public boolean isEmpty() {
        return specifiedSize == 0;
    }

    /*
    Clears the ArrayList and sets the size to 0
     */
    public void clearList() {
        if (specifiedSize > 0) {
            Arrays.fill(arrayForData, 0, specifiedSize, 0);
            specifiedSize = 0;
        }
    }

    /*
    Fetches the element at given index

    @params indexOfElement specifies the position of the element
     */
    public Object getElement(int indexOfElement) {
        if (indexOfElement < specifiedSize)
            return arrayForData[indexOfElement];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    /*
    Adds the element to the ArrayList

    @Threshold is set to be size of 5 for increasing the size of Array
     */
    public void addElement(Object arrayOfData) {
        if (this.arrayForData.length - specifiedSize <= 5)
            increaseArraySize();
        this.arrayForData[specifiedSize++] = arrayOfData;

    }

    /*
    Removes Object element from the array

    @params indexOfElement specifies the position of the element
     */
    public Object removeElement(int indexOfElement) {
        if (indexOfElement < specifiedSize) {
            Object removedElement = arrayForData[indexOfElement];
            arrayForData[indexOfElement] = null;

            int temp = indexOfElement;
            while (temp < specifiedSize) {
                arrayForData[temp] = arrayForData[temp + 1];
                arrayForData[temp + 1] = null;
                temp++;
            }

            specifiedSize--;
            return removedElement;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    /*
    Check the size of the array
     */
    public int sizeOfArrayList() {
        return specifiedSize;
    }
}



