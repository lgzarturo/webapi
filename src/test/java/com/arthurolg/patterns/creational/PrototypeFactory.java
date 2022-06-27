package com.arthurolg.patterns.creational;

public class PrototypeFactory {
    public static void main(String[] args) throws CloneNotSupportedException {
        Enemy base = new Enemy("img.jpg", 10, 20, 6);
        var enemyOne = new Enemy(base);
        var enemyTwo = base.clone();
        enemyOne.setLifeSize(4);
        enemyTwo.setLifeSize(2);

        System.out.println("Enemy Base: "+base);
        System.out.println("Enemy One: "+enemyOne);
        System.out.println("Enemy Two: "+enemyTwo);
    }
}

class Enemy implements Cloneable {
    private String image;
    private int posX;
    private int posY;
    private int lifeSize;

    public Enemy(String image, int posX, int posY, int lifeSize) {
        this.image = image;
        this.posX = posX;
        this.posY = posY;
        this.lifeSize = lifeSize;
    }

    public Enemy(Enemy enemy) {
        this.setImage(enemy.getImage());
        this.setPosX(enemy.getPosX());
        this.setPosY(enemy.getPosY());
        this.setLifeSize(enemy.getLifeSize());
    }

    public Enemy clone() throws CloneNotSupportedException {
        Enemy clone = (Enemy) super.clone();
        return new Enemy(clone);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLifeSize() {
        return lifeSize;
    }

    public void setLifeSize(int lifeSize) {
        this.lifeSize = lifeSize;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "image='" + image + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                ", lifeSize=" + lifeSize +
                '}';
    }
}
