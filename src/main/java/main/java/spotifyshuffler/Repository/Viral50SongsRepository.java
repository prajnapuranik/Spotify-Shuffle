package com.example.spotifyshuffler.Repository;
import com.example.spotifyshuffler.Model.Songs;
import com.example.spotifyshuffler.Model.SongsViral50;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Viral50SongsRepository extends MongoRepository<SongsViral50, String> {

    //Read operations
    @Query("{title:'?0'}")
    Songs findByTitle(String title);

    @Query("{artist:'?0'}")
    List<SongsViral50> findByArtist(String artist);

    @Query("{rank:'?0'}")
    List<SongsViral50> findByRank(int rank);

    @Query("{region:'?0'}")
    List<SongsViral50> findByRegion(String region);

    @Query("{streams:'?0'}")
    List<SongsViral50> findByStreams(Double streams);

    @Query(value ="{artist: ?0}", count=true)
    Integer getSongsCountByArtist(String artist);

    List<SongsViral50> findByRankGreaterThan(int rank);

    //Delete
    @Query("{title:'?0'}")
    String deleteByTitle(String title);

    @Query("{artist:'?0'}")
    void deleteByArtist(String artist);

    @Query(value = "{}", count = true)
    Long countAllDocuments();
}
