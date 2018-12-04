public class Sorts{
  public static void selectionsort(int [] ary) {
    //loop that runs n times
    for (int i = 0; i < ary.length; i++){
      int minLoc = i;
      //loop to find the smallest first
      for (int j = i+1; j < ary.length; j++){
        if (ary[j] < ary[minLoc]){
          minLoc = j;
        }
      }
      //remove the smallest:
      int[] w  = new int[ary.length - 1];
      boolean pass = false;
      int removed = ary[minLoc];
      for (int y = 0; y < w.length; y++) {
        if (pass) {
          w[y] = ary[y+1];
          pass = true;
        }
        else if (y == minLoc){
          w[y] = removed;
          pass = true;
        }
        else {
          w[y] = ary[y];
        }
      }
      ary = w; //edited ary to the newest without smallest value
      //to add the removed smallest:
      pass = false;
      int[] k = new int[ary.length + 1];
      for (int z = 0; z <= k.length; z++) {
        if (pass) {
          k[z] = ary[z-1];
        }
        else if (z == i) {
          k[z] = removed;
          pass = true;
        }
        else {
          w[z] = ary[z];
        }
      }
      ary = k;
      //GOAL : ary.add(i, ary.remove(minLoc));
    }
  }
}
