package day01;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr1 =new int[]{-1,2,4,78,12,7,9};
        Bubblesort sort = new Bubblesort();
        sort.SortArray(arr1);


    }

    public int[] SortArray(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int j:arr){
            System.out.print(j+"\t");
        }
        return arr;
    }

}
