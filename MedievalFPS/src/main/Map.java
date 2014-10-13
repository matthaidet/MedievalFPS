/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.math.Vector3f;

/**
 *
 * @author MattH
 */
public interface Map {

    public String getTerrainFilePath();

    public String getDecorationsFilePath();

    public String getBoundriesFilePath();

    public String getWaterFilePath();

    public String getMiniMapFilePath();

    public Vector3f[] getTeamOneSpawnPoints();

    public Vector3f[] getTeamTwoSpawnPoints();

    public Vector3f[] getNeutralSPawnPoints();

    public int getPlayerCapacity();
}
