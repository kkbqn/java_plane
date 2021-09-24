package com.com.athdu.java;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

import static java.lang.Thread.sleep;

/**
 * 雷霆战机
 * @author kkbqn
 * @create 2021-09-23 16:01
 */
public class GameFrame extends JFrame{

    GameFrame frame;
    //英雄机（一）
    HeroPlane heroPlane;

    //子弹（多）
    Vector<Bullet> bullets=new Vector<>();

    //敌机(多)
    Vector<EnemyPlane> enemyPlanes=new Vector<>();

    //背景图
    Image backGround=new ImageIcon("D:\\project\\java\\worksapce_idea1\\JavaSenior\\plane\\image\\MAP02_02.png").getImage();

    //构造器
    public GameFrame() {

        frame=this;//用于传给敌机构造器，获取子弹，便于进行碰撞检测

        //英雄机
        heroPlane = new HeroPlane(250, 700, 50, 50);
        heroPlane.start();//英雄机启动


        this.setSize(500, 760);//窗口大小
        this.setTitle("雷霆战机");
        this.setResizable(false);//不可缩放
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //关闭方式
        this.setLocationRelativeTo(null);//窗口位置，默认
        this.setVisible(true);//窗口是否可见


        //画图线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    //重复画
                    repaint();

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //敌机产生线程
        new Thread(new Runnable() {
            //随机数，确定敌机产生位置
            Random random =new Random();
            @Override
            public void run() {
                while(true){
                    int i = random.nextInt(500);//敌机x坐标
                    int speed=random.nextInt(100);//敌机速度
                    EnemyPlane enemyPlane=new EnemyPlane(i,0,50,50,speed,frame);

                    enemyPlane.start();//**********启动敌机线程********

                    enemyPlanes.add(enemyPlane);


                    try {
                        sleep(500);//每500ms产生一架
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


    }


    //画
    @Override
    public void paint(Graphics g) {
//        System.out.println("绘制面板");
        //画背景
        BufferedImage image = (BufferedImage)this.createImage(this.getSize().width, this.getSize().height);

        //高效缓存画笔
        Graphics pencil = image.getGraphics();

        //画背景
        pencil.drawImage(backGround,0,0,null);

        //画英雄机
        pencil.drawImage(heroPlane.image,heroPlane.x,heroPlane.y,heroPlane.width,heroPlane.height,null);


        //发射子弹
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet=bullets.get(i);
            if(bullet.y>0) {
                //子弹位置y会变
                pencil.drawImage(bullet.image, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            }else{
                bullets.remove(bullet);
            }


        }

        //画敌机
        for (int i = 0; i < enemyPlanes.size(); i++) {
            EnemyPlane enemyPlane=enemyPlanes.get(i);
            if(enemyPlane.y<760) {
                //敌机位置y会变
                pencil.drawImage(enemyPlane.image, enemyPlane.x, enemyPlane.y += enemyPlane.speed, enemyPlane.width, enemyPlane.height, null);
            }else{
                bullets.remove(enemyPlane);
            }


        }




        //生效
        g.drawImage(image,0,0,null);


    }

    public static void main(String[] args) {

        GameFrame gameFrame = new GameFrame();
        Player player = new Player(gameFrame);
        gameFrame.addKeyListener(player);
    }

}
