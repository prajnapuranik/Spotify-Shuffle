package com.example.spotifyshuffler.Repository;
import com.example.spotifyshuffler.Model.Songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongsRepository extends MongoRepository<Songs, String> {

    //Read operations
    @Query("{title:'?0'}")
    Songs  findByTitle(String title);

    @Query("{artist:'?0'}")
    List<Songs> findByArtist(String artist);

    @Query("{region:'?0'}")
    List<Songs> findByRegion(String region);

    @Query("{streams:'?0'}")
    List<Songs> findByStreams(Double streams);

    @Query(value ="{artist: ?0}", count=true)
    Integer getSongsCountByArtist(String artist);

    List<Songs> findByRankGreaterThan(int rank);

    @Query("{date:'?0'}")
    List<Songs> findByDate(String date);

    //Delete
    @Query("{title:'?0'}")
    String deleteByTitle(String title);

    @Query("{artist:'?0'}")
    void deleteByArtist(String artist);

    @Query(value = "{}", count = true)
    Long countAllDocuments();

}
