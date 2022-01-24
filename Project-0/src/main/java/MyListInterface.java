/**
     * Custom list interface we will use to implement our own list data structure
     */
    public interface MyListInterface<E> {

        //returning the size of the collection. We will need to maintain some int with the number of elements.
        int size();

        //adding an item to the end of the collection.
        void add(E e);

        //adding an item to some index, and shifting those items at/after the index to make room.
        void add(E e, int index);

        //return the element at the specified index
        E get(int index);
    }

