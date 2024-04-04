/**
 * The Test class is responsible for having the given test cases as well as additional methods that refer to
 * Reversing this list, mergeing lists, making sublists, and find occurences of specific months.
 * @author Jason Sodokoff
 * @version PKG, VSCODE, JPK, Java 11
 * @since CSE 017, April 3rd, 2024
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Iterator;

public class Test{
    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        List<String> list3 = new Stack<>();
        list1.add("August");
        list1.add("December");
        list1.add("February");
        list1.add("January");
        list1.add("May");
        
        System.out.println("list1: " + list1);

        list2.add("April");
        list2.add("May");
        list2.add("July");
        list2.add("November");
        list2.add("May");
        list2.add("July");
        list2.add("May");
        list2.add("December");
        list2.add("May");
        System.out.println("list2: " + list2);
       
        list3.add("April");
        list3.add("February");
        list3.add("July");
        list3.add("May");
        list3.add("October");
        list3.add("September");
        System.out.println("list3: " + list3);
        
        
        
        List<String> list5 = new ArrayList<>();
        reverseList(list1, list5);
        System.out.println("\nlist1: " + list1);
        System.out.println("list1 reversed: " + list5);
       
        System.out.println("\nlist1: " + list1);
        System.out.println("list3: " + list3);
        List<String> list6 = new ArrayList<>();
        merge(list1, list3, list6);
        
        System.out.println("list1 and list3 merged: " + list6);
        
        List<String> c7 = new Stack<>();
        subList(list3, 1, 5, c7);
        System.out.println("\nlist3: " + list3);
        System.out.println("subList of c3 from 1 inclusive to 5 exclusive: " + c7);
        

        int occ = findOccurrences(list2, "May");
        System.out.println("\nlist2: " + list2);
        System.out.println("Number of occurrences of the month May: " + occ);

    }
    /**
     * reverseList 
     * Time Complexity: O(n), n is the number of elements.
     *                  recursive call removes one element from list1  until empty.
     * @param list1 a list to be reversed 
     * @param list2 the list that will contain list1 reversed
     */
    public static <E> void reverseList(List<E> list1, List<E> list2) {
        reverseHelp(list1, list2, list1.size() - 1);
    }

    private static <E> void reverseHelp(List<E> list1, List<E> list2, int index) {  //helper method
        if (index < 0) {
            return;
        }
        E element = list1.get(index);
        list2.add(element);
        reverseHelp(list1, list2, index - 1);
    }

   
    /**
     * merge the two sorted lists
     *  Time Complexity: O(n1 + n2), n1 is the number of elements in list1,
     *                   n2 is elements in list2.
     *                   iterate through both lists once, time taken proportional to sum of sizes
     * @param list1 the first sorted list
     * @param list2 the second sorted list
     * @param list3 the list where list1 and list2 are merged in order
     */
    public static <E extends Comparable<? super E>> void merge(List<E> list1, List<E> list2, List<E> list3) {
        Iterator<E> iter1 = list1.iterator();
        Iterator<E> iter2 = list2.iterator();

        E elem1 = null, elem2 = null;

        if (iter1.hasNext()) {
            elem1 = iter1.next();
        }
        if (iter2.hasNext()) {
            elem2 = iter2.next();
        }

        while (elem1 != null && elem2 != null) {
            if (elem1.compareTo(elem2) <= 0) {
                list3.add(elem1);
                if (iter1.hasNext()) {
                    elem1 = iter1.next();
                } else {
                    elem1 = null;
                }
            } else {
                list3.add(elem2);
                if (iter2.hasNext()) {
                    elem2 = iter2.next();
                } else {
                    elem2 = null;
                }
            }
        }

        while (elem1 != null) {
            list3.add(elem1);
            if (iter1.hasNext()) {
                elem1 = iter1.next();
            } else {
                elem1 = null;
            }
        }

        while (elem2 != null) {
            list3.add(elem2);
            if (iter2.hasNext()) {
                elem2 = iter2.next();
            } else {
                elem2 = null;
            }
        }
    }

   
  /**
     * subList
     * Time Complexity: O(end - start), end is the ending index
     *                   start is the starting index.
     *                   The method copies elements from original list
     *                   the time taken is proportional to the difference between indices
     * @param list  the original list
     * @param start the index where the sublist should start
     * @param end   the index where the sublist should end (exclusive)
     * @param sub   the sublist
     */
    public static <E> void subList(List<E> list, int start, int end, List<E> sub) {
        if (start > end) {
            throw new IndexOutOfBoundsException("Start index cannot be greater than end index");
        }

        Iterator<E> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext() && index < end) {
            E element = iterator.next();
            if (index >= start && index < end) {
                sub.add(element);
            }
            index++;
        }

    }

   /**
     * findOccurrences
     *  Time Complexity: O(n), n is the number of elements in list
     *                   method iterates through the list once and counts
     *                   the occurrences of item
     * @param list list where to find the element
     * @param item find the occurrences for
     * @return number of times item appears in list
     */
    public static <E> int findOccurrences(List<E> list, E item) {
        int count = 0;
        Iterator<E> iter = list.iterator();
        while (iter.hasNext()) {
            E element = iter.next();
            if (element.equals(item)) {
                count++;
            }
        }
        return count;
    }
}

 