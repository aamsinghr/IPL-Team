package org.iplteam.test;

import org.iplteam.steps.TeamUtility;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import files.interaction.ReadJSON;

public class RCBTest {

	private JSONObject testData;

	@BeforeClass
	public void intializeTestData() {
		testData = new JSONObject(ReadJSON.parse("TeamRCB.json"));
	}

	@Test
	public void validateTeamHasOnlyFourForeignPlayers() {

		int foreignPlayersCount = TeamUtility.getForeignPlayersCount(testData);

		Assert.assertTrue(foreignPlayersCount == 4,
				"Foreign Player count invalid, \nExpected:4 \nActual:" + foreignPlayersCount + "\n");
	}

	@Test
	public void validateTeamHasAtleastOneWicketKeepr() {

		int wicketKeeperCount = TeamUtility.getWicketKeeprsCount(testData);

		Assert.assertTrue(wicketKeeperCount >= 1,
				"Wicket Keepers count invalid, \nExpected:>=1 \nActual:" + wicketKeeperCount + "\n");
	}

}
