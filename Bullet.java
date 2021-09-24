package com.com.athdu.java;

import javax.swing.*;
import java.awt.*;

/** 子弹
 * @author kkbqn
 * @create 2021-09-23 16:04
 */
public class Bullet {

    //坐标
    int x,y;

    //大小
    int width,height;

    //速度
    int speed=10;

    //子弹图片
    Image image=new ImageIcon("D:\\project\\java\\worksapce_idea1\\JavaSenior\\plane\\image\\300360.png").getImage();


    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



}
