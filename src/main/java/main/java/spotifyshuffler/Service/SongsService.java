package com.example.spotifyshuffler.Service;
import com.example.spotifyshuffler.Model.Songs;
import com.example.spotifyshuffler.Repository.SongsCustomRepository;
import com.example.spotifyshuffler.Repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongsService {

    @Autowired
    private SongsRepository songsRepo;

    @Autowired
    private SongsCustomRepository songsCustom;

    public List<Songs> getAllSongs() {
        List<Songs> songsList = new ArrayList<Songs>();
        songsRepo.findAll().forEach(songsList::add);
        return songsList;
    }

    public List<Songs> getSongsByArtist(String artist){
        List<Songs> songsList = new ArrayList<Songs>();
        for(Songs s: songsRepo.findByArtist(artist)){
            songsList.add(s);
        }
        return songsList;
    }

    public List<Songs> getSongsByRank(int rank){
        List<Songs> songsList = songsCustom.getAllSongsForRank(rank);
        return songsList;
    }


    public List<Songs> getSongsByRegion(String region){
        List<Songs> songsList= songsRepo.findByRegion(region);
        return songsList;
    }

    public Songs getSongsByTitle(String title){
        return songsRepo.findByTitle(title);
    }

    public Integer getSongsCountByArtist(String artist){
        return songsRepo.getSongsCountByArtist(artist);
    }

    public List<Songs> getSongRankGreaterThan(int rank){
        List<Songs> songsList= songsRepo.findByRankGreaterThan(rank);
        return songsList;
    }

    public List<Songs> getDate(String date){
        List<Songs> songsList= songsRepo.findByDate(date);
        return songsList;
    }

    public Songs getMostPopular(){
        Songs song= songsCustom.getMaxStreams();
        return song;
    }

    //CREATE
    public Songs saveSongService(Songs song){
        return songsRepo.save(song);
        //return "Added song successfully";
    }

    public Long countAllDocuments(){
        return songsRepo.countAllDocuments();
    }

    public boolean checkSongExists(String title) {
        return songsCustom.checkSongExists(title);
    }

    //Update
    public Songs updateSongArtist(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setArtist(song.getArtist());
        return songsRepo.save(song);
    }

    public Songs updateSongTitle(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setTitle(song.getTitle());
        return songsRepo.save(song);
    }

    public Songs updateSongRegion(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setRegion(song.getRegion());
        return songsRepo.save(song);
    }

    public Songs updateSongChart(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setChart(song.getChart());
        return songsRepo.save(song);
    }

    //DELETE
    public String deleteSongByTitle(String title){

        try {
            songsRepo.deleteByTitle(title);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return "Deleted Successfully";
    }

    public String deleteSongByArtist(String artist){
        try {
            songsRepo.deleteByArtist(artist);
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return "Deleted Successfully";
    }


}
