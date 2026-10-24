//Q36. WAP to find Kth smallest element in unsorted 
//Array input arr[] = {7,10,4,3,20,15} K=3 Ouput=7 Input arr[] = {7,10,4,3,20,15} K=4 Ouput=10  
class KthSmallest_36
{
    static int findKthSmallest(int arr[], int k)
    {
        // Sort the array
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr[k - 1];
    }

    public static void main(String args[])
    {
        int arr[] = {7, 10, 4, 3, 20, 15};

        int k = 4;

        System.out.println("Kth Smallest Element = " +
                           findKthSmallest(arr, k));
    }
}