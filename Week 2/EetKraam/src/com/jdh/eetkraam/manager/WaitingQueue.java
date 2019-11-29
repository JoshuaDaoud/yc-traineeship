package com.jdh.eetkraam.manager;

import com.jdh.eetkraam.model.Customer;

final class WaitingQueue {

    WaitingQueue() { }

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Customer customer;
        Node next;
    }

    boolean isEmpty() {
        return first == null;
    }

    int size() {
        return N;
    }

    /**
     * This method puts a customer last in line
     * @param customer
     */
    void enqueue(Customer customer) {
        Node oldLast = last;
        last = new Node();
        last.customer = customer;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
        System.out.println("Number of customers in line: " + N);
    }

    /**
     * This method removes the first customer from the line
     * @return
     */
    Customer dequeue() {
        //remove first customer from the beginning of the list
        Customer firstCustomer = first.customer;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        System.out.println("===================================");
        System.out.println("Customer is served and leaves the waiting line...");
        return firstCustomer;
    }

    Customer getFirstCustomer() {
        return first.customer;
    }

}
