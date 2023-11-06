package com.ll;

import lombok.Getter;

@Getter
public class Famous_Saying {
    private int id;
    private String famous_Saying;
    private String author;

    Famous_Saying(int id, String famous_Saying, String author){
        this.id = id;
        this.famous_Saying = famous_Saying;
        this.author = author;
    }


}
