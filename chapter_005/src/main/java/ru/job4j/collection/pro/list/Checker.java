package ru.job4j.collection.pro.list;

/**
 * Алгоритм зайца и черепахи
 */
public class Checker {
    boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) { //проверяем не достигла ли быстрая ссылка конца списка
            slow = slow.next;          // следующий элемент (черепаха)
            fast = fast.next.next;     // элемент через один (заяц)

            if (slow == fast) {    // быстрая ссылка догоняет медленную в цикле
                return true;
            }
        }
        return false;  // если быстрая ссылка достигла конца списка, то цикла нет
    }
}

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
