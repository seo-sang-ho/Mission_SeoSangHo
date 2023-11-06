package com.ll;

import java.util.Scanner;

public class App {

    public static void run(){

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("== 명언 앱 ==");
            String command = sc.next();

            if(command.equals("종료")){
                break;
            }
        }
    }
}
