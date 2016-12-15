package com.greenfox.exams.java.retake;

import java.util.ArrayList;

/**
 * Created by aze on 2016.12.15..
 */
public class Carrier {
    private int totalAmmo;
    private int HP;
    private ArrayList<Aircraft> aircrafts;

    public Carrier(int totalAmmo) {
        this.totalAmmo = totalAmmo;
        this.HP = 3000;
    }

    public int getAllDamage() {
        int damage = 0;
        for (Aircraft a : aircrafts) {
            damage += a.getAllDamage();
        }
        return damage;
    }

    public void addAircraft(String type) {
        if (type.equals("F16")) {
            aircrafts.add(new F16());
        } else {
            aircrafts.add(new F35());
        }
    }

    public void fill() {
        for (Aircraft a : aircrafts) {
            totalAmmo = a.refill(totalAmmo);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Aircraft count: ")
                .append(aircrafts.size())
                .append(", Ammo storage: ")
                .append(totalAmmo)
                .append(", Total damage: ")
                .append(getAllDamage())
                .append(", Health remaining: ")
                .append(HP)
                .append("\n")
                .append("Aircrafts:\n");
        for (Aircraft a : aircrafts) {
            sb.append(a.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
