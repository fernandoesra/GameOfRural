package utils;

import java.util.Arrays;

/**
 * This class is used to create differents arrays of objects. Its a poor and
 * limited copy of the Arrays.list that I make during my classes to learn how to
 * manage objects.
 * 
 * <p>
 * The class have methods to add and delete objects from the list, merge lists,
 * search for objects or index and others.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */

public class ObjectsList {
	
	// Attributes
	protected Object list[];

	// Constructor
	/**
	 * Create a new empty list.
	 */
	public ObjectsList() {
		list = new Object[0];
	}

	// Get and Set
	/**
	 * 
	 * @return The actual list.
	 */
	protected Object[] getList() {
		return list;
	}
	
	/**
	 * 
	 * @return The length of the list.
	 */
	public int getLength() {
		int totalLenght = list.length;
		return totalLenght;
	}

	// Methods
	@Override
	public String toString() {
		String textToReturn = "";
		for (int i = 0; i < list.length; i++) {
			textToReturn += "Object "+(i+1)+": "+list[i].toString() + "\n";
		}
		return textToReturn;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		ObjectsList l1 = (ObjectsList) obj;
		int successNumber = list.length;
		for (int i = 0; i < list.length && i < l1.list.length; i++) {
			if (list[i].equals(obj)) {
				successNumber--;
			}
		}
		if (successNumber == 0) {
			isEqual = true;
		}
		return isEqual;
	}
	
	/**
	 * Increase in one the length of the list and add the item at the end.
	 * 
	 * @param toAddAtEnd A object to add at the end of the list.
	 */
	public void addEnd(Object toAddAtEnd) {
		list = Arrays.copyOf(list, list.length + 1);
		list[list.length - 1] = toAddAtEnd;
	}
	
	/**
	 * Create a new array with one more length, add the new object to the 0 index
	 * and copy the actual array as from the next index.
	 * 
	 * @param toAddAtBeginning A object to add at the beginning of the list.
	 */
	public void addBeginning(Object toAddAtBeginning) {
		list = Arrays.copyOf(list, list.length + 1);
		for (int i = list.length - 1; i > 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = toAddAtBeginning;
	}
	
	/**
	 * Create a new array with one more length that are a copy of the actual array.
	 * Then using System.arraycopy() copy all from the index but one position ahead.
	 * Finally add the new item tho the indicated index.
	 * 
	 * @param toAdd A object to add to the list.
	 * @param index Where to add the new object.
	 */
	public void addOnIndex(Object toAdd, int index) {
		int listLength = list.length - 1;
		if (index <= listLength) {
			list = Arrays.copyOf(list, list.length + 1);
			System.arraycopy(list, index, list, index + 1, list.length - index - 1);
			list[index] = toAdd;
		} else {
			System.out.println("Index out of range");
		}
	}

	/**
	 * Create a new array wich is a copy of the actual array but with length equal
	 * to the length of the actual array and the array in the otherObjectList. Then
	 * copy all the Objects of the otherObjectList starting from final index of the
	 * original list.
	 * <p>
	 * 
	 * <b>Important: </b>This method change the actual list, does not return
	 * anything.
	 * 
	 * @param otherObjectList A ObjectsList object.
	 */
	public void mergeLists(ObjectsList otherObjectList) {
		int originalLength = list.length;
		int otherLength = otherObjectList.list.length;
		int newLength = originalLength + otherLength;
		if (originalLength > 0 && otherLength > 0) {
			list = Arrays.copyOf(list, newLength);
			for (int i = originalLength, j = 0; i < newLength; i++, j++) {
				list[i] = otherObjectList.list[j];
			}
		} else {
			System.out.println("One of the lists is empty");
		}

	}

	/**
	 * Search if the index provided exists, if exists, delete the character by
	 * overwrite all the index, starting in the provied index, from the object that
	 * are one position ahead. Then create a copy of the array with one less length.
	 * 
	 * @param index A index to delete one object.
	 */
	public void eraseFromIndex(int index) {
		int listLength = list.length -1;
		if (index <= listLength) {
			for (int i = index; i < listLength; i++) {
				list[i] = list[i + 1];
			}
			list = Arrays.copyOf(list, listLength);
		} else {
			System.out.println("Index out of range");
		}
	}

	/**
	 * Search on the array if the index exists, if exists return the object inside
	 * the index.
	 * 
	 * @param index A index to search.
	 * @return If the index exists return the object on that index. If not, return
	 *         null.
	 */
	public Object getObjectOnIndex(int index) {
		Object objectToReturn = null;
		int listLenght = list.length - 1;
		if (index <= listLenght) {
			objectToReturn = list[index];
		} else {
			System.out.println("Index out of range");
		}
		return objectToReturn;
	}

	/**
	 * That method search if one object are inside the array.
	 * 
	 * @param toFind The object to find.
	 * @return If the object are inside the list return the index of the object. If
	 *         not, return -1.
	 */
	public int searchIndex(Object toFind) {
		int foundAtIndex = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == toFind) {
				foundAtIndex = i;
			}
		}
		return foundAtIndex;
	}

}
