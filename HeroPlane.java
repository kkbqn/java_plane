package com.com.athdu.java;

import javax.swing.*;
import java.awt.*;

/**
 * @author kkbqn
 * @create 2021-09-23 16:04
 */
public class HeroPlane extends Thread{


    //英雄机图片
    Image image=new ImageIcon("D:\\project\\java\\worksapce_idea1\\JavaSenior\\plane\\image\\10011.png").getImage();
    //坐标
    int x,y;

    //宽高
    int width,height;

    int speed=10;//速度

    //移动
    boolean up,down,left,right;//上下左右


    public HeroPlane() {
    }

    public HeroPlane(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public HeroPlane(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }




    //飞机移动线程
    @Override
    public void run() {

        while(true){
            if(left==true&&x>=speed){
                x-=speed;
            }

            if(right==true&&x<500-this.width){
                x+=speed;
            }

            if(up==true&&y>=speed){
                y-=speed;
            }

            if(down==true&&y<=760-this.height){
                y+=speed;
            }



            //10秒检测一次
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
