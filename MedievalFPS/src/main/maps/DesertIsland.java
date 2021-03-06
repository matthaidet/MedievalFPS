/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.maps;

import com.jme3.math.Vector3f;

/**
 *
 * @author MattH
 */
public class DesertIsland implements Map {
    
    Vector3f[] teamOneSpawnPoints;
    Vector3f[] teamTwoSpawnPoints;
    Vector3f[] neutralSpawnPoints;
    String terrainFilePath = "Maps/desertIsland/Scenes/desertIslandTerrain.j3o";
    String loadingScreenFilePath = "";
    String decorationFilePath = "Maps/desertIsland/Scenes/desertIslandDecorations.j3o";
    String boundariesFilePath = "Maps/desertIsland/Scenes/desertIslandBoundaries.j3o";
    String teamOneBoundariesFilePath = "";
    String teamTwoBoundariesFilePath = "";
    String waterFilterFilePath = "Maps/desertIsland/desertIslandWaterFilter.j3f";
    String miniMapFilePath = "";
    String mapName = "desertIsland";
    String mapTag = "Desert Island";
    int playerCapacity = 10;
    
    void desertIsland() {
        
        
    }
    public String getTerrainFilePath() {
        return terrainFilePath;
    }

    public String getLoadingScreenFilePath() {
        return loadingScreenFilePath;
    }
    
    public String getDecorationsFilePath() {
        return decorationFilePath;
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

    public String getWaterFilePath() {
        return waterFilterFilePath;
    }

    public String getNeutralBoundariesFilePath() {
        return boundariesFilePath;
    }

    public String getTeamOneBoundariesFilePath() {
        return teamOneBoundariesFilePath;
    }

    public String getTeamTwoBoundariesFilePath() {
        return teamTwoBoundariesFilePath;
    }
}
