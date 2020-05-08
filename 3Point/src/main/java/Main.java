/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thebr
 */

import java.util.*;
public class Main {
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String s1, prev = "", next = "", add = "";
        boolean flag = false;
        int cnt = 0;
        int temp = 1;
        System.out.print("Ingrese la expresion: ");
        s1 = s.nextLine();
        if (s1.contains("="))
        {
            String div[] = s1.split("=");
            add = div[0];
            s1 = div[1];
            flag = true;
        }
        
        System.out.println("Codigo de 3 direcciones: - ");
        for (int i = 0; i< s1.length(); i++)
        {
            char c = s1.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/')
            {
                if (temp == 1)
                {
                    prev = "";
                    temp = temp + 1;
                    for (int j = 1 - 1; j >=0; j--)
                    {
                        char c1 = s1.charAt(j);
                        if (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/' || c1 == '=')
                        {
                            break;
                        }
                        prev = c1 + prev;
                    }
                }
                else
                {
                    prev = "t" + (cnt - 1);
                }
                next = "";
                for (int j = i + 1; j < s1.length(); j++)
                {
                    char c2 = s1.charAt(j);
                    if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/')
                    {
                        break;
                    }
                    next = next + c2;
                }
                
                System.out.println("t" + cnt + "=" + prev + " " + c + " " + next);
                cnt++;
            }
        } if (flag){
            System.err.println(add + "="+"t"+(cnt - 1));
        }
    }
}
