package com.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Collection01 {
    public static void main(String[] args) {
        News news1 = new News("新款嗯嗯大家可能接口文档就啃几口我");
        News news2 = new News("妇女能吃苦觉得你是空军的飞机看女春季看电视呢");

        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);

        Collections.sort(arrayList, new Comparator<News>() {
            @Override
            public int compare(News o1, News o2) {
                return o1.getTitle().length() - o2.getTitle().length();
            }
        });

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            News next = (News) iterator.next();
            System.out.println(next);
        }



    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        String str = "";
        if (title.length() > 15){
            str = title.substring(0,15) + "..." ;
        }else{
            str = title;
        }
        return "News{" +
                "title='" + str + '\'' +
                '}';
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}