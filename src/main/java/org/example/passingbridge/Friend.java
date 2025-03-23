package org.example.passingbridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Friend {

    private String name;
    private int passingBridgeTime;
    @Setter()
    boolean hasLantern;

    public Friend(String name, int passingBridgeTime) {
        this.name = name;
        this.passingBridgeTime = passingBridgeTime;
        this.hasLantern = false;
    }

    @Override
    public String toString() {
        return String.format("NAME: %s, HAS LANTERN: %b,  PASSING BRIDGE TIME: %d", name, hasLantern, passingBridgeTime);
    }
}
