# MyList
The MyList interface is a generic interface that specifies a collection of methods for implementing a list data structure

# Methods
size(): returns the number of elements in the list.
contains(T o): returns true if the list contains the specified element, false otherwise.
add(T item): appends the specified element to the end of the list.
addAtIndex(T item, int index): inserts the specified element at the specified position in the list, shifting the element currently at that position (if any) and any subsequent elements to the right.
remove(T item): removes the first occurrence of the specified element from the list, if it is present. Returns true if the element was successfully removed, false otherwise.
removeAtIndex(int index): removes the element at the specified position in the list, shifting any subsequent elements to the left. Returns the element that was removed.
clear(): removes all elements from the list.
get(int index): returns the element at the specified position in the list.
indexOf(T o): returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
lastIndexOf(T o): returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
sort(): sorts the elements of the list in ascending order according to their natural ordering, or according to a specified comparator.



# MyArrayList
MyArrayList is a class that implements the MyList interface using an array to store its elements.

# Methods
add(E element)
Adds the specified element to the end of the list. If the underlying array is full, a new array with double the size is created and the elements are copied over.

addAtIndex(E element, int index)
Adds the specified element at the specified index in the list. Shifts all subsequent elements to the right by one position.

contains(Object o)
Returns true if the list contains the specified element, otherwise false.

clear()
Removes all elements from the list.

get(int index)
Returns the element at the specified index in the list.

indexOf(Object o)
Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

isEmpty()
Returns true if the list contains no elements, otherwise false.

iterator()
Returns an iterator over the elements in the list, in proper sequence.

lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

remove(Object o)
Removes the first occurrence of the specified element from the list, if it is present. Shifts all subsequent elements to the left by one position.

removeAtIndex(int index)
Removes the element at the specified index from the list. Shifts all subsequent elements to the left by one position.

size()
Returns the number of elements in the list.

sort()
Sorts the elements in the list according to their natural ordering.


# MyLinkedList
MyLinkedList is a class that implements the MyList interface using a doubly-linked list to store its elements.

# Methods
add(E element)
Adds the specified element to the end of the list.

addAtIndex(E element, int index)
Adds the specified element at the specified index in the list. Shifts all subsequent elements to the right by one position.

contains(Object o)
Returns true if the list contains the specified element, otherwise false.

clear()
Removes all elements from the list.

get(int index)
Returns the element at the specified index in the list.

indexOf(Object o)
Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

isEmpty()
Returns true if the list contains no elements, otherwise false.

iterator()
Returns an iterator over the elements in the list, in proper sequence.

lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

remove(Object o)
Removes the first occurrence of the specified element from the list, if it is present.

removeAtIndex(int index)
Removes the element at the specified index from the list.

size()
Returns the number of elements in the list.

sort()
Sorts the elements in the list according to their natural ordering.


# License
This project is licensed under the AITU License

# Acknowledgements
We would like to thank Toktar Sultan for contributing code and helping to test the project.

# Contact
If you have any questions, comments, or concerns about this project, please feel free to contact us at blablaaitu@example.com. We would be happy to hear from you!
