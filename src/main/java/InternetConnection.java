
public class InternetConnection {

    public static int connect(int floors,int[] connections) {

       int count = 0; //return

       int arr[] = new int[floors];

        for(int i=0;i<arr.length;i++) {
           arr[i] = 0;
       }

       for(int i = 0;i<connections.length;i++) {
           int var = connections[i];
           arr[var-1] = 1;
       }


       int a0 = arr[0];

       if(a0 == 0) {
           for(int i = 1;i<arr.length;i++) {
               if(arr[i-1] == 1 || arr[i] == 1)
                   i++;
               else {
                   arr[i] = 1;
                   count++;
                   i++;
               }
           }
       }

       else {

           for(int i = 2;i<arr.length;i++) {
               if(arr[i-1] == 1 || arr[i] == 1) {
                   i++;
               }
               else {
                   arr[i] = 1;
                   count++;
                   i++;
               }
           }

       }
        return count;
    }

    public static void main(String[] args) {

      int array[]={1,3,5,10};
      int floors = 10;

      int result = connect(floors,array);
      System.out.println(result);
    }
}


