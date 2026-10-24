//Q37. Given an array of elements. The task is to sort the array and
 //calculate the cumulative frequency of each element of the array.
// Input arr[]={1,3,2,1,2,4}; Ouput: 1->2 2->4 3->5 4->6
//Input arr[]={1,2,1,2,1,2} output: 1->3 2->6

class CumulativeFrequency_37
{
    static void findCumulative(int arr[])
    {
        // Sort array
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

        int cumulative = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int count = 1;

            // Count frequency of current element
            while(i + 1 < arr.length && arr[i] == arr[i + 1])
            {
                count++;
                i++;
            }

            cumulative = cumulative + count;

            System.out.println(arr[i] + "->" + cumulative);
        }
    }

    public static void main(String args[])
    {
        int arr[] = {1, 3, 2, 1, 2, 4};

        findCumulative(arr);
    }
}