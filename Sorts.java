public class Sorts{

  public static void Sort(int [] ary) {
    //create a new ary to modify:
    int[] sorted = new int[ary.length];
    for (int s = 0; s < sorted.length; s++){
      sorted[s] = ary[s];
    }
    //now sorted should be same as ary
    //modify sorted
    for (int i = 0; i < sorted.length; i++){
      int minLoc = i;
      //loop to find the smallest first
      for (int j = i+1; j < sorted.length; j++){
        if (sorted[j] < sorted[minLoc]){
          minLoc = j;
        }
      }
      //remove the smallest:
      int[] w  = new int[sorted.length - 1];
      boolean pass = false;
      int removed = sorted[minLoc];
      for (int y = 0; y < w.length; y++) {
        if (y == minLoc || pass) {
          w[y] = sorted[y+1];
          pass = true;
        }
        else {
          w[y] = sorted[y];
        }
      }
      sorted = w; //edited ary to the newest without smallest value
      //to add the removed smallest:
      pass = false;
      int[] k = new int[sorted.length + 1];
      for (int z = 0; z < k.length; z++) {
        if (pass) {
          k[z] = sorted[z-1];
        }
        else if (z == i) {
          k[z] = removed;
          pass = true;
        }
        else {
          k[z] = sorted[z];
        }
      }
      sorted = k;
      //GOAL : ary.add(i, ary.remove(minLoc));
    }
    //now modify ary to sorted:
    for (int s = 0; s < sorted.length; s++){
      ary[s] = sorted[s];
    }
}

/**Selection sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */

  public static void selectionSort(int [] ary) {
    for (int i = 0; i < ary.length; i++){
      int minLoc = i;
      //loop to find the smallest first
      for (int j = i+1; j < ary.length; j++){
        if (ary[j] < ary[minLoc]){
          minLoc = j;
        }
      }
      int frontValue = ary[i]; //store the value of ary
      ary[i] = ary[minLoc]; //replace the value of ary with the smallest
      ary[minLoc] = frontValue; //switch place between the smallest and the frontValue
    }
  }

  /**Bubble sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */

  public static void bubbleSort(int[] data){
    //one loop, no isSort!
    int count = 0;
    boolean isSorted = false;
    while (!isSorted){
      for (int i = 0; i < data.length-1; i++){ //loop to move the largest lavue to the back every time
        if (data[i] > data[i+1]){
          int smaller = data[i+1];
          data[i+1] = data[i];  //move the larger value to next spot
          data[i] = smaller;  //move the smaller value to the front;
        }
      }
      count++;
      if (count >= data.length){  //the array should be sorted after it loops for the length of itself:
        isSorted = true;    // the smallest value can travel from the back to front;
      }
    }
  }

//CODE BORROW FROM Timothy So and Lauren Pehlivanian from Google Group + Inspiration from Timophy's code

  public static String printArray(int[] ary) {
      String output = "[";
      for(int i=0; i<ary.length-1; i++) {
        output += ary[i] + ", ";
      }
      return output += ary[ary.length-1] + "]";
  }

  public static void main(String[] args) {
    int[] randish = new int[Integer.parseInt(args[0])];
    for (int i = 0; i<randish.length; i++){
      randish[i] = (int)(Math.random()*100);
    }

    if(args[1].equals("selection"))selectionSort(randish);
    if(args[1].equals("bubble"))bubbleSort(randish);
      // Google random int generator

    }

}
