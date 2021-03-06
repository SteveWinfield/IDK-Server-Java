/*
 * IDK Game Server by Steve Winfield
 * https://github.com/WinfieldSteve
 */
package org.stevewinfield.suja.idk.game.achievements;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class Achievement {

    // getters
    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getCategory() {
        return category;
    }

    public ConcurrentHashMap<Integer, AchievementLevel> getLevels() {
        return levels;
    }

    public int getLevelCount() {
        return levelCount;
    }

    public Achievement() {
        this.id = 0;
        this.groupName = "";
        this.category = "";
        this.levels = new ConcurrentHashMap<>();
    }

    public void set(final ResultSet row) throws SQLException {
        this.id = row.getInt("id");
        this.groupName = row.getString("group_name");
        this.category = row.getString("category");
    }

    public void addLevel(final int levelReward, final int levelScore, final int progressNeeded) {
        final AchievementLevel level = new AchievementLevel(++this.levelCount, levelReward, levelScore, progressNeeded);
        this.levels.put(level.getLevel(), level);
    }

    // fields
    private int id;
    private String groupName;
    private String category;
    private int levelCount;
    private final ConcurrentHashMap<Integer, AchievementLevel> levels;
}
