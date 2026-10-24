//Q38. Write a java programe to get the majority element from an given array of integers
// containing duplicates. Majority element: A majority element is an element that 
// appears more than n/2 where n is the size of the array. input ayrr[]={1,1,2,3,1,5,3,1,1,1} output =1

class MajorityElement_38
{
    static int findMajority(int arr[])
    {
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            int count = 0;

            for(int j = 0; j < n; j++)
            {
                if(arr[i] == arr[j])
                {
                    count++;
                }
            }

            if(count > n / 2)
            {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 1, 2, 3, 1, 5, 3, 1, 1, 1};

        int result = findMajority(arr);

        System.out.println("Majority Element = " + result);
    }
}