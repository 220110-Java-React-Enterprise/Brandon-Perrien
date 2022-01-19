package src.main.java;

/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged.
 *
 * @param <E>
 */
//go through and comment out/delete methods that aren't used
public class MyArrayList<E> implements MyListInterface<E> {
    private Object[] array;
    private int size;
    private int maxSize;

    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public MyArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }

    /**
     * Sized constructor, creates an empty object with maxSize size
     * @param size the initial size of the underlying array
     */
    public MyArrayList(int size) {
        maxSize = size;
        size = 0;
        array = new Object[maxSize];
    }

    /**
     * Element list constructor, takes in variable number of objects and creates an underlying
     * array large enough to fit them.
     * @param e
     */
    public MyArrayList(E ...e) {
        maxSize = size = e.length;
        array = new Object[size];

        for (int i = 0; i < size; ++i) {
            array[i] = e[i];
        }
    }


    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     * @param o object to be added
     */
    @Override
    public void add(Object o) {
        // NOTE: if size >= maxSize we need to grow array
            if(size >= maxSize){
                growArray();
            }
            array[size++] = o;
    }

    /**
     * Adds object at specified index, advancing the size of the underlying array.
     * Will Shift later elements
     * @param index index location where object will be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }

        if(index < size -1){
            for(int i = size -1; i >= index; i--){
                if(i == index){
                    array[i] = e;
                }else if(array[i] != null){
                    if(array[size-1] != null){
                        growArray();
                    }
                    array[i+1]=array[i];
                    array[i] = array[i-1];
                    if(i == size -1){
                        size++;
                    }
                }
            }
        }
        if(index == size -1){
            if(array[index]==null){
                array[index]=e;
                size++;
            }else{
                growArray();
                array[index+1] = array[index];
                array[index] = e;
                size++;
            }
        }
    }




    /**
     * gets the object located at supplied index
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        if(index <= array.length - 1){
            return (E) array[index];
        }else{
            throw new IndexOutOfBoundsException("You know what you did.");
        }


    }

    /**
     * Emptys the underlying array by setting it's private reference to null and allowing
     * the old array to be garbage collected.
     */
    @Override
    public void clear() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];

    }

    /**
     * Check if object o is found within underlying array, using Object.equals() method
     * @param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public int contains(Object o) {
        for(int i = 0; i < size; i++){
            if(o.equals(array[i])){
                return i;
            }
        }
        return -1;

    }

    /**
     * Removes object at specified index from underlying array.
     * will shift array, making it smaller
     * @param index index of object to remove from array
     */
    @Override
    public void remove(int index) {
        if(index <= size) {
            array[index] = null;
            if (index < size - 1) {
                Object[] tempArray = array;
                array = new Object[maxSize];
                for (int i = 0; i < size; i++) {
                    array[i] = tempArray[i];
                    if (array[i] == null) {
                        array[i] = tempArray[i + 1];
                        tempArray[i + 1] = null;
                    }
                }
            }
            size--;
        }
    }

    /**
     * returns size of array. This is the one greater than the index of the most advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Doubles the size of the underlying array by creating a new array and copying the
     * contents of the previous array into it.
     */
    private void growArray(){
        //System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        //set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        //copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }
}