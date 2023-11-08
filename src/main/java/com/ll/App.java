package com.ll;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.*;

public class App {

    private static final CommandHandler commandHandler = new CommandHandler();
    private static final FileHandler fileHandler = new FileHandler();

    public static void run(){

        Scanner sc = new Scanner(System.in);
        List<Famous_Saying> Famous_Sayings = new ArrayList<>();
        int index = 1;

        fileHandler.getListFromFile(Famous_Sayings);

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명언) ");
            String command = sc.nextLine();

            if(command.equals("등록")){
                index = commandHandler.register(sc, index, Famous_Sayings);
            }

            if(command.equals("목록")){
                commandHandler.list(Famous_Sayings);
            }

            if(command.equals("삭제")){
                commandHandler.delete(sc, Famous_Sayings);
            }

            if(command.equals("수정")){
                commandHandler.update(sc, Famous_Sayings);
            }

            if(command.equals("빌드")){
                commandHandler.buildJsonFile();
            }

            if(command.equals("종료")){
                break;
            }
        }
    }




}
