import java.util.PriorityQueue;
/*
 Question 3
 Design a class to find the kth largest element in a stream. Note that it is the
  kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream
 */
public class Question3 {
    class KthLargest {
        private PriorityQueue<Integer> pq = new PriorityQueue<>();
        private int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                add(i); 
            }   
        }

        public int add(int val) {
            pq.offer(val); // heap.offer(val): Adds the new element val to the priority queue.
            if(pq.size() > k ){
                pq.poll();
            }
            return pq.peek();
        }
    }
    
}
