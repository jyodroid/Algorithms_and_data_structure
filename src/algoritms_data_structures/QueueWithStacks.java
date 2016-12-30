package algoritms_data_structures;

import java.util.Scanner;

public class QueueWithStacks {
    public static class MyQueue<T> {
        java.util.Stack<T> stackNewestOnTop = new java.util.Stack<T>();
        java.util.Stack<T> stackOldestOnTop = new java.util.Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            
            stackNewestOnTop.push(value);
        }

        public T peek() {
            
            if(stackOldestOnTop.isEmpty()){
                                   
                while(!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            
            if(!stackOldestOnTop.isEmpty()){
                return stackOldestOnTop.peek();
            }
            
            return null;
        }

        public T dequeue() {
                     
            if(stackOldestOnTop.isEmpty()){
               while(!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            if(!stackOldestOnTop.isEmpty()){
                return stackOldestOnTop.pop();
            }
           
            return null;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
