package algoritms_data_structures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heaps {
    private static void getMedian(int[] array){
        
    	
    	Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int2-int1;
            }
		};
    	
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>(array.length/2, comparator);        
        
        PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
        
        for(int value : array){
            if(lower.isEmpty()){
                lower.add(value);
            } else {
                if (lower.size() > higher.size()){
                    if (lower.peek() > value){
                        higher.add(lower.poll());
                        lower.add(value);
                    }else{
                        higher.add(value);
                    }   
                }else{
                    Integer higherPeek = higher.peek();
                    if(higherPeek != null && higherPeek >= value){
                        lower.add(value);
                    }else{
                        lower.add(higher.poll());
                        higher.add(value);
                    }
                }
            }
            int size = higher.size() + lower.size();
            if(size % 2 != 0){
                System.out.println((float) lower.peek());
            }else{
                System.out.println((lower.peek() + higher.peek())/2.0f);
            }
            System.out.println(higher.peek());
            System.out.println(lower.peek());
        }
    }
       
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        getMedian(a);
    }
}
