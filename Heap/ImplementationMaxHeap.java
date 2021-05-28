

class MaxHeap {
      
	  int[] Heap;
	  int size;
	  int maxSize;
	  
	  MaxHeap(int maxSize){
	     
	     this.size = 0;
		 this.maxSize = size;
		 Heap = new int[this.maxSize + 1];
		 
	  }
	
	
	   public int parent(int pos) {
	          return pos/2;		  
	  } 
	  
	  public int leftChild(int pos) {
	          return 2*pos;		  
	  }
	  
	  public int rightChild(int pos) {
	          return (2*pos)+1;		  
	  } 
	  
	  public isLeaf(int pos){
	  
	      if(pos>=(size/2) && pos<=size)
		        return true;
		  return false;
		  
	  }
	  
	    private void swap(int fpos, int spos)
		{
			int tmp;
			tmp = Heap[fpos];
			Heap[fpos] = Heap[spos];
			Heap[spos] = tmp;
		}
  
	  
	  public void MaxHeapify(int pos){
	    
		 if(!isLeaf(pos)){
		       
			 if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
			   
			        if(Heap[leftChild(pos)] > Heap[pos] < Heap[rightChild(pos)]) {  
					          swap(pos,leftChild(pos));
							  MaxHeapify(leftChild(pos));
					}
					else{
							  swap(pos,rightChild(pos));
							  MaxHeapify(rightChild(pos));
					}
		 
		      }
	      }
	  }
	  
	  public void remove(){
	      int popped = Heap[1];
		  Heap[1] = Heap[size--];
		  MaxHeapify(1);
		  return popped;
	  }
	  
	  public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
  
}
