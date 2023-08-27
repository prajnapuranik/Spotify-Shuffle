package com.example.spotifyshuffler.Controller;

import java.util.List;

import com.example.spotifyshuffler.Model.Songs;
import com.example.spotifyshuffler.Service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SongsController {

    @Autowired
    private SongsService songsService;

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    //Read operations
    @GetMapping("/findAllSongs")
    public List<Songs> getSongs() {
        return songsService.getAllSongs();
    }

    @GetMapping("/findSongByTitle")
    public Songs getSongsByTitle(@RequestParam String title, Model model) {
        return songsService.getSongsByTitle(title);
    }

    @GetMapping("/findSongByArtist")
    public List<Songs> getSongsByArtist(@RequestParam String artist, Model model) {
        System.out.println(artist);
        return songsService.getSongsByArtist(artist);
    }

    @GetMapping("/findSongByRegion")
    public List<Songs> getSongsByRegion(@RequestParam String region, Model model) {
        System.out.println(region);
        return songsService.getSongsByRegion(region);
    }

    @GetMapping("/findSongCountByArtist")
    public Integer getSongsCountByArtist(@RequestParam String artist, Model model) {
        System.out.println(artist);
        return songsService.getSongsCountByArtist(artist);
    }

    @GetMapping("/findSongRankGreaterThan")
    public List<Songs> findSongRankGreaterThan(@RequestParam int rank, Model model) {
        return songsService.getSongRankGreaterThan(rank);
    }

    @GetMapping("/findSongByRank")
    public List<Songs> getSongsByRank(@RequestParam int rank, Model model) {
        return songsService.getSongsByRank(rank);
    }

    @GetMapping("/getTotalCount")
    public Long getSongsCount() {
        return songsService.countAllDocuments();
    }

    @GetMapping("/getAllSongsInDate")
    public List<Songs> getSongsDate(@RequestParam String date, Model model) {
        return songsService.getDate(date);
    }

    @GetMapping("/checkSongExists")
    public String checkSongExists(@RequestParam String title, Model model){
        return "the song exits?" + songsService.checkSongExists(title);
    }

    @GetMapping("/getMostPopular")
    public Songs getMostPopular() {
        return songsService.getMostPopular();
    }

    //Create
    @GetMapping("/addSong")
    public Songs addSong(@RequestParam String song, Model model){
        System.out.println("Added Successfully");
        return songsService.saveSongService(createSong(song));
    }

    //Update
    @GetMapping("/updateSongArtist")
    public Songs updateSongArtist(@RequestParam String song, Model model){
        System.out.println("Updated artist successfully");
        return songsService.updateSongArtist(createSong(song));
    }

    @GetMapping("/updateSongTitle")
    public Songs updateSongTitle(@RequestParam String song, Model model){
        System.out.println("Updated title successfully");
        return songsService.updateSongTitle(createSong(song));
    }

    @GetMapping("/updateSongRegion")
    public Songs updateSongRegion(@RequestParam String song, Model model){
        System.out.println("Updated region successfully");
        return songsService.updateSongRegion(createSong(song));
    }

    @GetMapping("/updateSongChart")
    public Songs updateSongChart(@RequestParam String song, Model model){
        System.out.println("Updated chart successfully");
        return songsService.updateSongChart(createSong(song));
    }

    //Delete
    @GetMapping("/deleteSongByArtist")
    public String deleteSongByTitle(@RequestParam String artist, Model model){
        return songsService.deleteSongByTitle(artist);
    }

    @GetMapping("/deleteSongByTitle")
    public String deleteSongByArtist(@RequestParam String title, Model model){
        return songsService.deleteSongByArtist(title);
    }

    public Songs createSong(String str){
        String[] list = str.split(" ");
        Songs s = new Songs(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4], list[5], Double.parseDouble(list[6]));
        return s;
    }

}

