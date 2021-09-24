package com.com.athdu.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** 玩家
 * @author kkbqn
 * @create 2021-09-23 16:05
 */
public class Player implements KeyListener {

//    HeroPlane heroPlane;
        GameFrame gameFrame;

    public Player( GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //按键按下
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        //上下左右 38 40 37 39
            switch (keyCode) {

                case 37:
                    gameFrame.heroPlane.left = true;
                    break;
                case 39:
                    gameFrame.heroPlane.right = true;
                    break;
                case 38:
                    gameFrame.heroPlane.up = true;
                    break;
                case 40:
                    gameFrame.heroPlane.down = true;
                    break;
                //'B'
                case 66:
                    addBullet();
                    break;

            }
            System.out.println(keyCode);



    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        //上下左右 38 40 37 39
            switch (keyCode) {

                case 37:
                    gameFrame.heroPlane.left = false;
                    break;
                case 39:
                    gameFrame.heroPlane.right = false;
                    break;
                case 38:
                    gameFrame.heroPlane.up = false;
                    break;
                case 40:
                    gameFrame.heroPlane.down= false;
                    break;

            }


    }

    //装弹
    public void addBullet(){

        gameFrame.bullets.add(new Bullet(gameFrame.heroPlane.x + 5, gameFrame.heroPlane.y, 50, 50));
    }

}
