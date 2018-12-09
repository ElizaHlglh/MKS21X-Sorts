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

  public static void bubbleSort(int[] ary){
    //one loop, no isSort!
    int count = 0;
    boolean isSorted = false;
    while (!isSorted){
      for (int i = 0; i < ary.length-1; i++){ //loop to move the largest lavue to the back every time
        if (ary[i] > ary[i+1]){
          int smaller = ary[i+1];
          ary[i+1] = ary[i];  //move the larger value to next spot
          ary[i] = smaller;  //move the smaller value to the front;
        }
      }
      count++;
      if (count >= ary.length){  //the array should be sorted after it loops for the length of itself:
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
    //System.out.println(printArray(randish));

    if(args[1].equals("selection")){
      selectionSort(randish);
      //System.out.println(printArray(randish)); TESTING PURPOSE
    }
    if(args[1].equals("bubble")){
      bubbleSort(randish);
      //System.out.println(printArray(randish));
    }
      // Google random int generator



/*TESTING SELECTIONSORT:


System.out.println("TESTING SELECTIONSORT: ");
String sorted = "";

// 8 nums, [0:10]
int[] test_a = { 3, 4, 7, 1, 6, 2, 8, 6 };
System.out.println(printArray(test_a));               // [3, 4, 7, 1, 6, 2, 8, 6]

selectionSort(test_a);

sorted = printArray(test_a);
System.out.println(sorted);               // [1, 2, 3, 4, 6, 6, 7, 8]

if(sorted.equals("[1, 2, 3, 4, 6, 6, 7, 8]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

// 12 nums, [0:20]
int[] test_b = { 17, 1, 19, 2, 18, 20, 1, 18, 11, 13, 5, 17 };
System.out.println(printArray(test_b));   // [17, 1, 19, 2, 18, 20, 1, 18, 11, 13, 5, 17]

selectionSort(test_b);

sorted = printArray(test_b);
System.out.println(sorted);               // [1, 1, 2, 5, 11, 13, 17, 17, 18, 18, 19, 20]

if(sorted.equals("[1, 1, 2, 5, 11, 13, 17, 17, 18, 18, 19, 20]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

// 20 nums, [0:100]
int[] test_c = { 14, 32, 19, 66, 61, 96, 33, 48, 30, 100, 65, 37, 15, 85, 1, 35, 9, 57, 50, 52 };
System.out.println(printArray(test_c));   // [14, 32, 19, 66, 61, 96, 33, 48, 30, 100, 65, 37, 15, 85, 1, 35, 9, 57, 50, 52]

selectionSort(test_c);

sorted = printArray(test_c);
System.out.println(sorted);               // [1, 9, 14, 15, 19, 30, 32, 33, 35, 37, 48, 50, 52, 57, 61, 65, 66, 85, 96, 100]

if(sorted.equals("[1, 9, 14, 15, 19, 30, 32, 33, 35, 37, 48, 50, 52, 57, 61, 65, 66, 85, 96, 100]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST D
int[] test_d = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
System.out.println(printArray(test_d));

selectionSort(test_d);

sorted = printArray(test_d);
System.out.println(sorted);

if(sorted.equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST E
int[] test_e = {0,0,0,0,0};
System.out.println(printArray(test_e));

selectionSort(test_e);

sorted = printArray(test_e);
System.out.println(sorted);

if(sorted.equals("[0, 0, 0, 0, 0]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST F
int[] test_f = {5,4,3,2,1};
System.out.println(printArray(test_f));

selectionSort(test_f);

sorted = printArray(test_f);
System.out.println(sorted);

if(sorted.equals("[1, 2, 3, 4, 5]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}
*/


//TESTING BUBBLESORT:


/*
System.out.println("TESTING BUBBLESORT: ");
String sorted1 = "";

// 8 nums, [0:10]
int[] test_a1 = { 3, 4, 7, 1, 6, 2, 8, 6 };
System.out.println(printArray(test_a1));               // [3, 4, 7, 1, 6, 2, 8, 6]

bubbleSort(test_a1);

sorted1 = printArray(test_a1);
System.out.println(sorted1);               // [1, 2, 3, 4, 6, 6, 7, 8]

if(sorted1.equals("[1, 2, 3, 4, 6, 6, 7, 8]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

// 12 nums, [0:20]
int[] test_b1 = { 17, 1, 19, 2, 18, 20, 1, 18, 11, 13, 5, 17 };
System.out.println(printArray(test_b1));   // [17, 1, 19, 2, 18, 20, 1, 18, 11, 13, 5, 17]

bubbleSort(test_b1);

sorted1 = printArray(test_b1);
System.out.println(sorted1);               // [1, 1, 2, 5, 11, 13, 17, 17, 18, 18, 19, 20]

if(sorted1.equals("[1, 1, 2, 5, 11, 13, 17, 17, 18, 18, 19, 20]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

// 20 nums, [0:100]
int[] test_c1 = { 14, 32, 19, 66, 61, 96, 33, 48, 30, 100, 65, 37, 15, 85, 1, 35, 9, 57, 50, 52 };
System.out.println(printArray(test_c1));   // [14, 32, 19, 66, 61, 96, 33, 48, 30, 100, 65, 37, 15, 85, 1, 35, 9, 57, 50, 52]

bubbleSort(test_c1);

sorted1 = printArray(test_c1);
System.out.println(sorted1);               // [1, 9, 14, 15, 19, 30, 32, 33, 35, 37, 48, 50, 52, 57, 61, 65, 66, 85, 96, 100]

if(sorted1.equals("[1, 9, 14, 15, 19, 30, 32, 33, 35, 37, 48, 50, 52, 57, 61, 65, 66, 85, 96, 100]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST D
int[] test_d1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
System.out.println(printArray(test_d1));

bubbleSort(test_d1);

sorted1 = printArray(test_d1);
System.out.println(sorted1);

if(sorted1.equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST E
int[] test_e1 = {0,0,0,0,0};
System.out.println(printArray(test_e1));

bubbleSort(test_e1);

sorted1 = printArray(test_e1);
System.out.println(sorted1);

if(sorted1.equals("[0, 0, 0, 0, 0]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}

//TEST F
int[] test_f1 = {5,4,3,2,1};
System.out.println(printArray(test_f1));

bubbleSort(test_f1);

sorted1 = printArray(test_f1);
System.out.println(sorted1);

if(sorted1.equals("[1, 2, 3, 4, 5]")) {
System.out.println("TEST CASE - PASS");
} else {
System.out.println("TEST CASE - FAIL");
}
*/

    }

}
