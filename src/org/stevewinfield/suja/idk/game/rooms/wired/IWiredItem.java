/*
 * IDK Game Server by Steve Winfield
 * https://github.com/WinfieldSteve
 */
package org.stevewinfield.suja.idk.game.rooms.wired;

import java.util.List;

import org.stevewinfield.suja.idk.communication.MessageReader;
import org.stevewinfield.suja.idk.game.rooms.RoomItem;

public interface IWiredItem {
    int getWiredType();

    int getDelay();

    List<Integer> getItems();

    RoomItem getItem();

    void set(String[] obj);

    String[] getObject(MessageReader reader);
}
