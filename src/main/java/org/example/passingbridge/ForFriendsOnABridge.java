package org.example.passingbridge;

import java.util.*;


public class ForFriendsOnABridge {

    private static final  int FIRST_FRIEND_PASSING_TIME = 1;
    private static final  int SECOND_FRIEND_PASSING_TIME = 2;
    private static final  int THIRD_FRIEND_PASSING_TIME = 5;
    private static final  int FOURTH_FRIEND_PASSING_TIME = 10;

    private static final Map<String, Friend> FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE = new HashMap<>();
    private static final Map<String, Friend> FRIENDS_ON_RIGHT_SIDE_OF_THE_BRIDGE = new HashMap<>();

    public static void main(String[] args) {
        int elapsedTime = 0;

        Friend friendBryan = new Friend("Bryan", FIRST_FRIEND_PASSING_TIME);
        Friend friendJohn = new Friend("John", SECOND_FRIEND_PASSING_TIME);
        Friend friendDavid = new Friend("David", THIRD_FRIEND_PASSING_TIME);
        Friend friendPaul = new Friend("Paul", FOURTH_FRIEND_PASSING_TIME);

        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.put(friendBryan.getName(), friendBryan);
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.put(friendJohn.getName(), friendJohn);
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.put(friendDavid.getName(), friendDavid);
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.put(friendPaul.getName(), friendPaul);

        elapsedTime += passTheBridge(friendBryan, friendJohn);
        System.out.println("CURRENT TIME: " + elapsedTime + " minutes\n");

        elapsedTime += returnBack(friendBryan);
        System.out.println("CURRENT TIME: " + elapsedTime + " minutes\n");

        elapsedTime += passTheBridge(friendDavid, friendPaul);
        System.out.println("CURRENT TIME: " + elapsedTime + " minutes\n");

        elapsedTime += returnBack(friendJohn);
        System.out.println("CURRENT TIME: " + elapsedTime + " minutes\n");

        elapsedTime += passTheBridge(friendBryan, friendJohn);
        System.out.println("FINAL TIME: " + elapsedTime + " minutes\n");
    }


    private static int passTheBridge(Friend firstPassingFriend, Friend secondPassingFriend) {
        firstPassingFriend.setHasLantern(true);
        System.out.println(firstPassingFriend.getName() + " got the lantern: " + firstPassingFriend.isHasLantern());
        System.out.printf("%s and %s are passing the bridge ...%n", firstPassingFriend.getName(), secondPassingFriend.getName());

        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.remove(firstPassingFriend.getName());
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.remove(secondPassingFriend.getName());
        FRIENDS_ON_RIGHT_SIDE_OF_THE_BRIDGE.put(firstPassingFriend.getName(), firstPassingFriend);
        FRIENDS_ON_RIGHT_SIDE_OF_THE_BRIDGE.put(secondPassingFriend.getName(), secondPassingFriend);

        firstPassingFriend.setHasLantern(false);
        printFriendsOnLeftSideOfTheBridge();
        printFriendsOnRightSideOfTheBridge();
        return Math.max(firstPassingFriend.getPassingBridgeTime(), secondPassingFriend.getPassingBridgeTime());
    }

    private static int returnBack(Friend friendToReturnWithTheLantern) {
        friendToReturnWithTheLantern.setHasLantern(true);
        System.out.printf("%s is returning back ...%n", friendToReturnWithTheLantern.getName());
        FRIENDS_ON_RIGHT_SIDE_OF_THE_BRIDGE.remove(friendToReturnWithTheLantern.getName());
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.put(friendToReturnWithTheLantern.getName(), friendToReturnWithTheLantern);
        friendToReturnWithTheLantern.setHasLantern(false);

        printFriendsOnLeftSideOfTheBridge();
        printFriendsOnRightSideOfTheBridge();
        return friendToReturnWithTheLantern.getPassingBridgeTime();
    }

    private static void printFriendsOnLeftSideOfTheBridge() {
        System.out.println("\nFRIENDS ON THE LEFT SIDE OF THE BRIDGE");
        FRIENDS_ON_LEFT_SIDE_OF_THE_BRIDGE.entrySet().forEach(System.out::println);
    }

    private static void printFriendsOnRightSideOfTheBridge() {
        System.out.println("\nFRIENDS ON THE RIGHT SIDE OF THE BRIDGE");
        FRIENDS_ON_RIGHT_SIDE_OF_THE_BRIDGE.entrySet().forEach(System.out::println);
    }
}
