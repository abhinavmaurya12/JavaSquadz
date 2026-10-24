class Sort 
{	
	static void sort (int x[]) {
		for(int i=0; i<x.length; i++){
			for(int j=i+1; j<x.length; j++){
				if(x[i]>x[j]){
					int temp =x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
		}
	}
	
	public static void main (String args[]){
	
     int arr[]={25, 10, 45, 95, 62};
      sort(arr); 
	
	  for(int i=0; i<arr.length; i++){
       System.out.print(arr[i] + " ");   
	  }	 
	}
	
}