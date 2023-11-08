
package com.ll;

import java.io.*;
import java.util.List;

public class FileHandler {
    public void getListFromFile(List<Famous_Saying> Famous_Sayings) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
            String line;

            while((line = reader.readLine()) != null){
                String [] parts = line.split("/");
                int id = Integer.parseInt(parts[0]);
                String famous_Saying = parts[1];
                String author = parts[2];

                Famous_Sayings.add(new Famous_Saying(id,famous_Saying,author));
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void documentation(Famous_Saying famous_saying) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt",true));
            writer.write(famous_saying.getId()+ "/" + famous_saying.getFamous_Saying() + "/" + famous_saying.getAuthor() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void documentation2(Famous_Saying famous_saying) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myFile2.txt",true));
            writer.write(famous_saying.getId()+ "/" + famous_saying.getFamous_Saying() + "/" + famous_saying.getAuthor() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
