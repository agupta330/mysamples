import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort
{
	public static void quickSort(int[] input)
	{
        recursiveQuickSort(input, 0, input.length - 1);
    }
	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) 
	{
		int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) 
        {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) 
        {
            recursiveQuickSort(array, idx, endIdx);
        }
    }
	public static int partition(int[] array, int left, int right) 
	{
        int pivot = array[left]; // taking first element as pivot

        while (left <= right)
        {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot)
            {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot)
            {
                right--;
            }

            // swap the values
            if (left <= right)
            {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
	
	
	public static void main(String args[]) throws FileNotFoundException,NumberFormatException,ArrayIndexOutOfBoundsException
	{
		int[] numbers=new int[100];	
		int row = 0, col = 0;
		int i=0;
		String csv="D:/qsortdata.csv";
		BufferedReader br= new BufferedReader(new FileReader(csv));
		String line=null;
		try
			{
				br.readLine();
				while((line = br.readLine())!=null )
				{					
					String[] input = line.split(",");
					//String[] f=line.split(",");
					numbers[i] = Integer.parseInt(input[3]);
		            i++;
		     	}
				quickSort(numbers);
				for ( i = 0; i < numbers.length; i++) 
				{
					System.out.println(numbers[i] + " ");
				}
			 }
		
		catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	


	




