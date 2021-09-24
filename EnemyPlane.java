package com.com.athdu.java;

import javax.swing.*;
import java.awt.*;

/**
 * @author kkbqn
 * @create 2021-09-23 16:04
 */
public class EnemyPlane extends Thread {

    GameFrame frame;//用于获取子弹

    //英雄机图片
    Image image = new ImageIcon("D:\\project\\java\\worksapce_idea1\\JavaSenior\\plane\\image\\10025.png").getImage();
    //坐标
    int x, y;

    //宽高
    int width, height;

    int speed = 10;//速度


    public EnemyPlane() {
    }

    public EnemyPlane(int x, int y, int width, int height, int speed,GameFrame frame) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed=speed;
        this.frame=frame;

//        this.start();
    }



    //敌机碰撞检测
    public boolean hit() {
        Rectangle MyRectangle = new Rectangle(x, y, width, height);

        Rectangle rectangle = null;
        for (int i = 0; i < frame.bullets.size(); i++) {
            Bullet bullet = frame.bullets.get(i);
            rectangle = new Rectangle(bullet.x, bullet.y, bullet.width, bullet.height);

            if (MyRectangle.intersects(rectangle)) {
                return true;
            }
        }
        return false;

    }


    //敌机线程
    @Override
    public void run() {

        while (true) {

            if (hit()) {
                image = new ImageIcon("D:\\project\\java\\worksapce_idea1\\JavaSenior\\plane\\image\\300370.png").getImage();
                speed = 0;

                try {
                    sleep(500);//延时500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                frame.enemyPlanes.remove(this);
                break;//退出循环，该敌机线程结束

            }

            if(this.y>760){
                frame.enemyPlanes.remove(this);
                break;
            }

            try {
                sleep(10);//10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




        }

    }


}
