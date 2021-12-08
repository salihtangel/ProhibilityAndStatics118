import java.io.*;

import java.util.Arrays;
import java.util.Scanner;

public class Read {
    // Java Program to illustrate reading from FileReade    r
// using BufferedReader



    public  static void main(String[] args)throws Exception
        {
            Scanner scanner = new Scanner(new File("manufacturing_defects.txt"));
            int [][] tall = new int [100][100];
            int [] my = new int [10000];
            int i = 0,j=0;
            while(scanner.hasNextInt())
            {

                //end of one line
                if(j == 16){
                    j=0;
                    i++;
                }

                //copy read
                tall[i][j] = scanner.nextInt();
                //forward on array
                j++;
            }
            //System.out.println(tall[1][15]);

            Read a = new Read();
            //a.write_file();


            a.question_one(tall);
            a.calc_lamda(tall);
            a.third_question();
            a.table();


        }
        public void question_one(int tall[][]) {

            //our Defects
            // for zero
            int num = 0;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 2; j < 16; j++) {
                    if (0 == tall[i][j])
                        num++;
                    if (1 == tall[i][j])
                        num1++;
                    if (2 == tall[i][j])
                        num2++;
                    if (3 == tall[i][j])
                        num3++;
                    if (4 == tall[i][j])
                        num4++;
                }
            }


            System.out.println(num);
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
            System.out.println(num4);


            //for one
            //for two
            //for three
            //for four


        }
    public void write_file() {

        try (FileWriter f = new FileWriter("C:\\Users\\tangel\\Desktop\\olasilik\\MATH118-HW2.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.println("appending text into file");
            p.println("Gaura");
            p.println("Bori");

        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void calc_lamda( int tall[][]){
        float val=0;
        float temp=0;
        for (int i =0;i<20;i++ ) {
            for (int j = 2; j <16 ; j++) {
                val+=tall[i][j];
            }
            val/=14.0;
            temp+=val;
            val=0;
        }

            temp/=20.0;
        System.out.println(temp);
    }

    static int factorial(int n) {
            if (n == 0)
                return 1;
            else
                return (n * factorial(n - 1));
        }


    public void third_question( ){
            int total=280;
            double e= 2.7182;
            double lamda = 0.7;
            double result;


            double y=Math.pow(e,lamda);

            for(int i=0;i<5;i++){
                double x= Math.pow(lamda,i);
                result= x/(y * factorial(i));
                result*=280;
                System.out.println(result);

            }




    }
    public void table(){

            System.out.println("# of " + "Defectss  | # of cases" + "in all company" + "between the years");
            System.out.println("0\t\t\t   | 144");
            System.out.println("1\t\t\t   | 91");
            System.out.println("2\t\t\t   | 32");
            System.out.println("3\t\t\t   | 11");
            System.out.println("4\t\t\t   | 2");

            System.out.println("# of cases" + "in all companies" + "between the years | Predicted # of cases" +  "in all companies" +  "between the years");
            System.out.println("0\t\t\t  144\t\t\t|\t\t\t 139.04");
            System.out.println("1\t\t\t   91\t\t\t|\t\t\t 97.33");
            System.out.println("2\t\t\t   32\t\t\t|\t\t\t 34.06 ");
            System.out.println("3\t\t\t   11\t\t\t|\t\t\t  7.94");
            System.out.println("4\t\t\t    2\t\t\t|\t\t\t  1.39");




    }


}
