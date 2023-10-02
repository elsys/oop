#pragma once

#include "collection.hh"

class List : public Collection {
    class Node {
    public:
        Node* prev;
        Node* next;
        int value;

        Node(int value);
        Node(Node* prev, Node* next, int value);
    };

    Node* head;
    Node* tail;
public:
    List();
    ~List();

    void push(int value);
    int pop();
    int size();
    void clear();
};