package org.iplteam.steps;

import org.json.JSONArray;
import org.json.JSONObject;

import files.interaction.ReadJSON;

public class TeamUtility {

	public static int getForeignPlayersCount(JSONObject testData) {
		JSONArray players = ReadJSON.getArray(testData, "player");
		int foreignPlayersCount = 0;

		for (Object playerObject : players) {
			JSONObject player = new JSONObject(playerObject.toString());
			if (!"India".equalsIgnoreCase(player.get("country").toString()))
				foreignPlayersCount++;
		}
		return foreignPlayersCount;
	}

	public static int getWicketKeeprsCount(JSONObject testData) {
		JSONArray players = ReadJSON.getArray(testData, "player");
		int wicketKeeperCount = 0;

		for (Object playerObject : players) {
			JSONObject player = new JSONObject(playerObject.toString());
			if ("Wicket-keeper".equalsIgnoreCase(player.get("role").toString()))
				wicketKeeperCount++;
		}
		return wicketKeeperCount;
	}

}
