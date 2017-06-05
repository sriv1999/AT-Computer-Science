package queue;
import java.util.Arrays;

public class CircularArrayQueue {
    private int head;
    private int tail;
    private int theSize;
    private Object[] elements;

    public CircularArrayQueue(int capacity) {
        elements = new Object[capacity];
        head = 0;
        tail = 0;
        theSize = 0;
    }

    public void add(Object x) {
        if (theSize == elements.length) {
            if (tail == head) {
                Object[] temp = new Object[elements.length * 2];
                int pos = 0;
                for (int count = head; count < elements.length; count++, pos++)
                    temp[pos] = elements[count];
                for (int count = 0; count < head; count++, pos++)
                    temp[pos] = elements[count];

                head = 0;
                tail = pos;
                elements = temp;
            } else{
                Object[] temp = new Object[elements.length * 2];
                for (int count = head, pos = 0; count < elements.length; count++, pos++){
                    temp[pos] = elements[count];
                }
                    elements = temp;
            }
        }

        elements[tail] = x;
        tail = (tail + 1) % elements.length;
        theSize++;
    }

    public Object remove() {
        Object toReturn = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        theSize--;
        return toReturn;
    }

    public int size() {
        return theSize;
    }

    public String toString(){
		String result = "[";
		for (Object e : elements){
			result += e + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;
    }


    public static void main(String[] args) {
        CircularArrayQueue a = new CircularArrayQueue(10);
        for (int count = 1; count < 10; count++)
            a.add(count);
        System.out.println(a);

        System.out.println("NEXT: " + a.remove());
        System.out.println("NEXT: " + a.remove());
        System.out.println("NEXT: " + a.remove());
        System.out.println(a);

        a.add(10);
        System.out.println(a);
        a.add(11);
        System.out.println(a);
        a.add(12);
        System.out.println(a);

        System.out.println("NEXT: " + a.remove());
        System.out.println(a);

        a.add(13);
        System.out.println(a);
        a.add(14);
        System.out.println(a);
        a.add(15);
        System.out.println(a);

        System.out.println("NEXT: " + a.remove());
        System.out.println(a);
    }
}