package api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlaylistAPI {
	
	public static Response post(Playlist reqPlaylist, String token)
	{
	return  given()
		
		.header("Authorization", "Bearer "+token)
		
		.spec(SpecBuilders.reqSpec())
		
		.body(reqPlaylist)
		
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(SpecBuilders.resSpec())
		
		.extract()
		
		.response();
		
	}
	
	public static Response get(String playlistId, String token)
	{
		return given()
		
		.spec(SpecBuilders.reqSpec())
		
		.header("Authorization", "Bearer "+token)
		
		.pathParam("pId", playlistId)
		
		.when()
		
		.get("playlists/{pId}")
		
		.then()
		
		.spec(SpecBuilders.resSpec())
		
		.extract()
		
		.response();
		
	}
	
	public static Response update(Playlist reqPlaylist, String playlistId, String token)
	{
	return	given()
		
		.header("Authorization", "Bearer "+token)
		
		.spec(SpecBuilders.reqSpec())
		
		.body(reqPlaylist)
		
		.when()
		
		.put("playlists/"+playlistId)
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}

}
