

/*

	8.	Find and display the month which has the highest average temperature       in Marmara.

9.	As the continuation of Ex. 8, find and display the city of the highest       average temperature.
	
10.	As the continuation of Ex. 9, find and display the lowest temperature and   month of the city in the Ex. 9.




//temperature[0][i][1][j]  for 8 question
//temperature[0][0][1][j]	 for 9 question

        double max =0;
        int ind_city =0 , ind_month =0;
         
//here the answer of question 8 and 9
        for (int i=0; i<9; i++){
            for (int j=0; j<12; j++)
                if(temperature[0][i][1][j]> max)
                {
                    max=temperature[0][i][1][j];
                    ind_city=i;
                    ind_month =j;
                }
        }
        
        System.out.println("The highest month in Marmara is:  -"                 +   dim1[ind_month]  +  "-   with temperature: " + max + "    And the city is: "     + dim3[0][ind_city] + "\n\n\n");
         

//here the answer of question 10
//temperature[0][0][i][j]  for 10. question

        
         for (int i=0; i<3; i++){
            for (int j=0; j<12; j++)
                if(temperature[0][0][i][j]< max)
                {
                    max=temperature[0][0][i][j];
                    ind_city=i;
                    ind_month =j;
                }
        }
         
         System.out.println("The lowest temerature is: " + max  +" And the month is: "+ dim1[ind_month]  +"  And the city is: " + dim3[0][0]);




*/


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

/*

7. Find and display the region which has the higher average maximum annual      temperature.


double sum_aegean=0, sum_marmara=0;
    
//temperature[0-1][i][0][12]
    for(int i=0;i<9;i++){
        sum_aegean=sum_aegean+temperature[1][i][0][12];
        sum_marmara=sum_marmara+temperature[0][i][0][12];
            }
    
		    if((sum_marmara/9)>(sum_aegean/9))
        System.out.printf("Marmara %.2f\n", (sum_marmara/9));
		    else
        System.out.printf("Aegean %.2f\n", (sum_aegean/9));





*/




/*

5.	Find and display the city, which has the lowest temperature in Aegean.

//temperature[1][i][2][j]
        double min =100;
        int ind_city =0 , ind_month =0;
        
        for (int i=0; i<9; i++){
            for (int j=0; j<12; j++)
                if(temperature[1][i][2][j]<min)
                {
                    min=temperature[1][i][2][j];
                    ind_city=i;
                    ind_month =j;
                }
        }
        
        System.out.println("Agean    " + dim3[1][ind_city]+ "   "  + dim1[ind_month] + "   " + min);




*/

/*

4.	Find and display the average minimum temperature of Aegean in January.

double sum =0;
        //temperature[1][j][2][0]
        for (int i=0; i <9; i++)
            sum = sum+temperature[1][i][2][0];
        
        System.out.printf("%.2f", (sum/9));

*/



/*
3.	Find and display the average maximum temperature of Marmara in July.

	double sum =0;
        //temperature[0][i][0][6]

        for (int i=0; i <9; i++)
            sum = sum+temperature[0][i][0][6];
        
        System.out.printf("%.2f", (sum/9));




*/
/*
2.	Find and display the cities which have the lowest minimum temperature in    January in their own region.



double min =100;
        int ind=0;

        for (int i =0; i<2; i++){
            System.out.print(dim4[i]+":  ");
            for (int j=0;j<9;j++){
                if(temperature[i][j][2][0] < min){
                    min = temperature[i][j][2][0];
                    ind =j;
                }
            }
             System.out.println(dim3[i][ind]+ "    "+ min);
        }

*/

/*
Example 1:
1.	Display the similar output of the temperature data with the output given at the end of this file.



    public static void main(String[] args) {
        
        
             // main data      [2] [9] [3] [13]
double [] [] [] [] temperature={{
                              {{22.4,23.4,28.6,31.2,35.4,38.9,38.6,38.1,39.6,32.4,26.7,25.0,39.6},{6.9,7.9,10.0,13.7,18.7,23.4,25.8,26.0,22.5,17.4,13.4,9.2,16.2},{-4.6,-5.1,-2.2,3.3,6.6,13.6,16.5,15.9,12.1,2.5,3.4,-1.5,-5.1}},
                              {{20.5,23.3,28.0,33.5,37.1,42.6,44.1,41.9,39.9,35.8,28.0,22.8,44.1},{2.8,4.8,8.3,13.2,18.5,22.9,25.3,25.4,20.6,14.8,9.3,4.4,14.2},{-19.5,-19.0,-12.0,-4.1,0.7,6.0,8.0,8.9,0.2,-3.7,-9.4,-14.9,-19.5}}, 
                              {{18.6,23.1,25.7,31.5,36.0,40.4,42.5,40.4,38.8,37.4,28.9,21.6,42.5},{3.3,4.5,7.5,12.4,17.6,22.1,24.6,24.6,19.9,14.6,9.5,5.0,13.8},{-15.8,-15.0,-11.8,-3.0,1.4,5.8,8.8,8.7,3.0,-3.4,-7.2,-11.1,-15.8}},
                              {{23.9,24.7,28.1,34.3,33.8,40.2,38.4,37.5,39.7,35.1,27.9,23.5,40.2},{5.2,5.8,8.1,12.0,17.1,21.8,24.4,24.8,20.7,16.1,11.4,7.1,14.5},{-13.5,-13.3,-10.4,-1.2,2.7,8.6,10.9,11.0,3.7,-1.8,-7.8,-10.9,-13.5}},
                              {{20.0,21.3,27.3,30.8,38.9,36.8,39.0,39.1,35.9,31.8,26.2,22.9,39.1},{6.5,7.0,9.1,12.8,18.0,22.9,25.8,26.0,21.6,16.8,12.3,8.3,15.6},{-11.0,-11.5,-8.5,-1.6,2.3,6.6,11.2,9.4,5.9,0.4,-7.0,-10.5,-11.5}},
                              {{23.5,25.2,29.6,33.1,37.8,42.5,43.2,43.2,40.3,38.3,29.0,26.1,43.2},{4.8,5.7,7.9,13.1,18.2,23.0,24.9,25.0,21.1,16.6,9.9,6.6,14.7},{-10.5,-18.8,-6.2,-4.0,1.1,5.0,11.0,9.4,5.4,-1.6,-7.9,-10.1,-18.8}},
                              {{25.2,26.9,32.5,36.2,37.0,41.3,43.8,42.6,40.3,37.3,31.0,27.3,43.8},{5.4,6.5,9.0,13.0,18.1,22.6,25.1,25.2,20.8,15.9,10.7,7.0,14.9},{-20.5,-19.6,-10.5,-4.2,0.8,4.0,8.3,7.6,3.3,-1.0,-8.4,-17.9,-20.5}},
                              {{24.9,26.7,30.8,35.0,37.2,40.7,44.1,42.9,40.2,36.2,29.1,27.4,44.1},{6.4,7.1,9.2,13.2,18.0,22.3,24.5,24.8,21.1,16.7,12.2,8.4,15.3},{-13.1,-18.0,-6.5,-1.0,1.8,4.0,10.1,10.9,4.9,2.4,-3.4,-8.8,-18.0}},
                              {{25.0,27.2,32.0,36.5,37.0,42.1,39.2,40.2,37.5,36.6,29.7,27.4,42.1},{6.8,7.2,9.0,12.6,17.4,21.9,24.3,24.5,20.8,16.5,12.0,8.6,15.1},{-9.6,-11.0,-7.4,-1.6,1.2,7.1,10.0,10.3,6.0,1.3,-3.2,-9.2,-11.0}}
                              },{
                              {{22.4,27.0,30.5,32.5,37.6,41.3,42.6,43.0,40.1,36.0,30.3,25.2,43.0},{9.0,9.9,12.4,16.2,21.1,26.0,28.6,28.5,24.2,19.5,14.4,10.5,18.4},{-8.2,-5.2,-3.8,0.6,4.3,9.5,15.4,11.5,10.0,3.6,-2.9,-4.7,-8.2}},
                              {{24.0,26.4,33.5,34.7,40.6,42.4,45.5,44.5,42.4,38.2,29.9,26.4,45.5},{6.3,7.9,11.0,15.2,20.7,25.7,28.6,28.5,23.7,18.2,11.9,7.8,17.1},{-17.5,-10.9,-6.7,-2.7,2.0,7.4,10.5,8.5,3.3,-0.9,-7.3,-9.9,-17.5}},
                              {{17.1,24.2,27.0,30.2,34.3,36.2,39.5,38.8,38.4,31.9,25.4,21.7,39.5},{0.6,2.3,5.8,10.2,15.0,18.8,21.6,21.6,17.4,12.4,6.6,2.4,11.2},{-26.3,-27.4,-16.6,-7.8,-2.8,0.5,2.6,-0.2,-3.9,-6.9,-11.0,-28.1,-28.1}},
                              {{18.3,23.6,27.0,30.0,34.5,36.6,40.2,38.2,36.6,32.6,26.0,21.8,40.2},{2.6,3.7,6.7,11.0,15.9,20.4,24.0,24.2,19.5,14.2,8.4,4.3,12.9},{-19.9,-15.0,-12.5,-6.2,-1.0,2.9,7.4,6.8,2.0,-4.8,-11.8,-18.9,-19.9}},
                              {{18.0,21.8,26.4,30.2,33.9,35.8,39.8,38.2,37.2,31.3,25.3,21.0,39.8},{0.4,2.2,6.0,10.5,15.3,19.4,22.8,22.8,18.5,13.0,6.9,2.5,11.7},{-27.0,-25.3,-17.0,-7.6,-3.1,1.0,4.0,2.4,-3.2,-7.9,-20.5,-24.3,-27.0}},
                              {{22.6,25.9,30.8,35.8,39.5,44.1,43.9,44.4,41.6,36.9,29.9,26.6,44.4},{6.2,7.6,10.7,15.1,20.2,25.1,28.3,28.2,23.5,17.9,11.9,7.7,16.9},{-10.5,-11.4,-7.0,-2.0,2.7,7.9,12.6,11.6,6.6,-0.8,-4.5,-10.4,-11.4}},
                              {{23.2,27.4,32.4,35.4,42.6,44.4,44.8,43.8,43.3,39.5,30.7,25.9,44.8},{8.2,9.5,12.3,16.1,21.2,26.2,28.7,28.3,24.0,19.1,13.5,9.5,18.1},{-11.0,-5.4,-5.0,-0.8,4.6,8.4,13.4,11.8,7.6,1.6,-4.7,-5.3,-11.0}},
                              {{20.9,25.5,28.8,31.2,39.4,40.8,42.1,41.2,39.2,36.8,29.0,23.8,42.1},{5.4,6.2,9.0,12.8,18.0,23.4,27.0,27.0,22.2,16.5,10.6,6.7,15.4},{-12.6,-9.9,-8.5,-3.6,1.0,6.7,10.5,9.0,5.6,0.1,-7.0,-9.0,-12.6}},
                              {{16.8,23.4,27.8,30.7,35.4,38.7,41.0,41.0,39.0,32.7,25.6,20.5,41.0},{2.5,4.0,7.4,11.7,16.7,21.5,25.2,25.1,20.5,14.8,8.5,4.1,13.5},{-16.7,-15.0,-11.6,-7.0,-0.4,3.8,9.0,8.8,3.4,-2.4,-12.0,-15.3,-16.7}} 
                              }};  

String dim1[]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Annual"},
dim2[]={"Maximum", "Average", "Minimum"},
        dim3[][]={{"Istanbul", "Edirne", "Kirklareli", "Tekirdag", "Canakkale", "Balikesir", "Bursa", "Kocaeli", "Yalova"},{"Izmir", "Manisa", "Kutahya", "Usak", "Afyon", "Denizli", "Aydin", "Mugla", "Burdur"}},
        dim4[]={"Marmara", "Aegean"};


    for (int i=0; i<2; i++){
    	System.out.println(dim4[i]+ "\n");
        for(int j=0;j<9;j++){
        	System.out.printf("%-12s",dim3[i][j]);
                    for (int k= 0; k<13;k++)
                        System.out.printf("%12s",dim1[k]);
                    System.out.println();
        	
            for (int k=0; k<3; k++){
            		 System.out.printf("%-12s",dim2[k] );

                for (int l=0; l<13; l++){
                    System.out.printf("%12.1f",temperature[i][j][k][l]);
                    
                   
                }
            	
                 System.out.println();
            }
                 System.out.println();

        }
           System.out.println("\n\n");

    }






    }
    
}




*/