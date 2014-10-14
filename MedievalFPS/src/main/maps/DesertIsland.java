/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.maps;

import com.jme3.math.Vector3f;
import main.Map;

/**
 *
 * @author MattH
 */
public class DesertIsland implements Map {
    
    Vector3f[] teamOneSpawnPoints;
    Vector3f[] teamTwoSpawnPoints;
    Vector3f[] neutralSpawnPoints;
    String terrainFilePath;
    String loadingScreenFilePath;
    String decorationFilePath;
    String boundariesFilePath;
    String waterFilterFilePath;
    String miniMapFilePath;
    String mapName;
    String mapTag;
    int playerCapacity;
    
    public String getTerrainFilePath() {
        return terrainFilePath;
    }

    public String getDecorationsFilePath() {
        return decorationFilePath;
    }

    public String getBoundriesFilePath() {
        return boundariesFilePath;
    }

    public String getWaterFilterFilePath() {
        return waterFilterFilePath;
    }

    public String getMiniMapFilePath() {
        return miniMapFilePath;
    }

    public Vector3f[] getTeamOneSpawnPoints() {
        return teamOneSpawnPoints;
    }

    public Vector3f[] getTeamTwoSpawnPoints() {
        return teamTwoSpawnPoints;
    }

    public Vector3f[] getNeutralSPawnPoints() {
        return neutralSpawnPoints;
    }

    public int getPlayerCapacity() {
        return playerCapacity;
    }

    public String getMapName() {
        return mapName;
    }
    
    public String getMapTag() {
        return mapTag;
    }
}
