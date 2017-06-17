/**
 * This class handles disjoint sets, with path compression and union by rank
 * @author Horatiu Lazu
 * @version 1.0
 */
public class DisjointSet {
    /** This is the data array */
    private int [] arr;

    /**
     * This is the class constructor for disjoint sets
     * @param size int This is the size
     */
    public DisjointSet(int size){
        this.arr = new int[size];
    }

    /**
     * Create a new disjoint set.
     * @param num This is the index to make the new disjoint set in
     */
    public void create(int num){
        arr[num] = -2;
    }

    /**
     * This method returns the array
     * @return int []
     */
    public int [] getArr(){
        return arr;
    }

    /**
     * This method will add an item to a disjoint set
     * @param num int This is the number
     * @param head int This is the head
     */
    public void add(int num, int head){
        arr[num] = head;
        arr[find(head)]--;
    }

    /**
     * This method will find the  representative index
     * @param num int This is the index
     * @return int This is the representative index
     */
    public int find(int num){ //recursion
        while(num >= 0 && arr[num] >= 0){
            num = arr[num];
        }
        return num;
    }

    /**
     * This method does find with path compression
     * @param num int This is the index
     * @return int This is the find value
     */
    public int findPathCompression(int num){
        if (arr[num] >= -1){
            return (arr[num] = findPathCompression(arr[num]));
        }
        return num;
    }

    /**
     * This method does merge with union-by-rank, by placing smaller trees under larger trees
     * @param num1 int This is the first index
     * @param num2 int This is the second index
     */
    public void merge (int num1, int num2){
        int head1 = find(num1);
        int head2 = find(num2);

        if (arr[head1] < arr[head2]){
            arr[head2] = head1;
        }
        else{
            arr[head1] = head2;
        }
    }

}
