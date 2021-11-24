package a4;

public class MinHeap implements Heap {
  
  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size
  
  // ================================================
  // constructors
  // ================================================
  
  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }
  public MinHeap( ) { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }


  //==================================================
  // methods we need to grade
  //==================================================
  
  public int[] getArray() { // do not change this method
    return this.elts;
  }
  
  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //========================================================= 


  public void insert(int p){
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    /*Your code here */
    if (this.size == this.max) {
      return;
    } else {
      this.size++;
      this.elts[this.size] = p;
      moveUp(this.size);
    }

  }
  private void moveUp(int nodeIndex) {
    int parentIndex;
    int tmp;

    if(nodeIndex != 0) {
      parentIndex = (int)Math.floor((nodeIndex)/2);
      if (this.elts[parentIndex] > this.elts[nodeIndex]) {
        tmp = this.elts[parentIndex];
        this.elts[parentIndex] = this.elts[nodeIndex];
        this.elts[nodeIndex] = tmp;
        moveUp(parentIndex);
      }
    }
  }
  
  public void delFront() {
    /*Your code here */
    if (this.size == 0) {
      throw new IllegalStateException(); //Dummy return statement.  Remove (or move elsewhere) when you implement!
    }
    this.elts[1] = this.elts[size];
    this.size--;
    bubbleDown(1);
  }

  private void bubbleDown(int nodeIndex) {
    int leftChild = nodeIndex*2;
    int rightChild = nodeIndex*2 + 1;
    int tmp;
    if (leftChild <= size){
      int child = leftChild;
      if (rightChild <= size && elts[leftChild] > elts[rightChild]){
        child = rightChild;
      }
      if (elts[nodeIndex] > elts[child]){
        tmp = elts[nodeIndex];
        elts[nodeIndex] = elts[child];
        elts[child] = tmp;
        bubbleDown(child);
      }
    }
  }
 /*   if(nodeIndex != 0) {
      leftChild = nodeIndex * 2;
      rightChild = (nodeIndex * 2) + 1;
      while ((this.elts[nodeIndex] > this.elts[leftChild] || this.elts[nodeIndex] > this.elts[rightChild]) && nodeIndex <= size/2) {
        if ((this.elts[leftChild] < this.elts[rightChild]) || rightChild > this.size) {
          tmp = this.elts[nodeIndex];
          this.elts[nodeIndex] = this.elts[leftChild];
          this.elts[leftChild] = tmp;
          bubbleDown(leftChild);
        } else {
            tmp = this.elts[nodeIndex];
            this.elts[nodeIndex] = this.elts[rightChild];
            this.elts[rightChild] = tmp;
            bubbleDown(rightChild);
        }

      }
    }
  }*/

  
  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */
    if (this.size == 0) {
      throw new IllegalStateException(); //Dummy return statement.  Remove (or move elsewhere) when you implement!
    }
    return this.elts[1];
  }
  
  public boolean empty( ) {
    /*Your code here */
    return this.size == 0;
    //return true; //Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

  public int size() {
    /*Your code here */
    return size; //Dummy return statement.  Remove (or move elsewhere) when you implement!
  }
  
  public void clear() { 
    /*Your code here */
    size = 0;
  }
  
  public void build (int[] e, int ne) {
    //Hint: remember to skip slot 0 in the heap array.
    /* Your code here */
    clear();

    size = ne;
    for (int i= 0; i < ne; i++) {
      this.elts[i+1] = e[i];
    }
    for (int i = ne/2; i >= 1; i--) {
      bubbleDown(i);
    }
  }  
  
  public int[] sort() {
    int s = this.size;
    int [] y = new int[this.size];
    // Hint: the smallest element will go in slot 0
    /*Your code here */
    for (int i = 0; i < s; i++) {
      y[i] = this.elts[1];
      delFront();
    }
    return y;
    // Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

}
