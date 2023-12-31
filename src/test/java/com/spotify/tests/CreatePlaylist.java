package com.spotify.tests;

import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import api.SpecBuilders;

import static io.restassured.RestAssured.*;

public class CreatePlaylist {
	
	
	static String playListId;
	@Test(priority = 1)
	
	public void createPlaylist()
	{
		Playlist reqPlaylist  = new Playlist();
		
		reqPlaylist.setName("14th August Playlist");
		reqPlaylist.setDescription("Create Playlist test");
		reqPlaylist.setPublic(false);
		
		Playlist playlist = given()
		
		.spec(SpecBuilders.reqSpec())
		
		.body(reqPlaylist)
		
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(SpecBuilders.resSpec())
		
		.extract()
		
		.response()
		
		.as(Playlist.class);
		
		
		 playListId= playlist.getId();
	}
	
	@Test(priority = 2)
	public void getAPlaylist()
	{
		given()
		
		.spec(SpecBuilders.reqSpec())
		
		.pathParam("pId", playListId)
		
		.when()
		
		.get("playlists/{pId}")
		
		.then()
		
		.spec(SpecBuilders.resSpec())
		
		.extract()
		
		.response();
	}
	
	
	
	
	

}
