package com.example.spotifyshuffler.Repository;

import com.example.spotifyshuffler.Model.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public class SongsCustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean checkSongExists(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        boolean dataExists = mongoTemplate.exists(query, "top200");
        System.out.println(dataExists);
        return dataExists;
    }

    public List<Songs> getAllSongsForRank(int rank) {
        Query query = new Query();
        query.addCriteria(Criteria.where("rank").is(rank));
        List<Songs> songList = mongoTemplate.find(query, Songs.class);
        return songList;
    }

    public Songs getMaxStreams() {
        //List<Songs> songList = mongoTemplate.findAll(Sort.by(Sort.Direction.DESC, "streams"), Songs.class);

        Query query = new Query();
        query.with(Sort.by("streams").descending());
        List<Songs> songList=  mongoTemplate.find(query, Songs.class);
        return songList.get(0);
    }


}
