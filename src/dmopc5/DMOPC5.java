/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmopc5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jihua5758
 */
public class DMOPC5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int min=0;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        ArrayList<ArrayList<Integer>> b=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<(int)Math.pow(2,n-1);i++){
            boolean[] t=new boolean[n-1];
            String s=Integer.toBinaryString(i);
            for(int j=0;j<s.length();j++){
                if(s.charAt(s.length()-1-j)=='1'){
                    t[j]=true;
                }
            }
            b.add(new ArrayList<Integer>());
            b.get(i).add(a[0]);
            for(int j=1;j<n;j++){
                if(t[j-1]){
                    b.get(i).add(0,a[j]);
                }else{
                    b.get(i).add(a[j]);
                }
            }
            int temp=0;
            for(int j=0;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(b.get(i).get(j)>b.get(i).get(k)){
                        temp++;
                    }
                }
            }
            if(i==0){
                min=temp;
            }else if(temp<min){
                min=temp;
            }
        }
        System.out.println(min);
    }
}
