package com.example.SuViet.controller;

import com.example.SuViet.model.ResponseObject;
import com.example.SuViet.model.ResponsePaginationObject;
import com.example.SuViet.model.Video;
import com.example.SuViet.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/{offset}")
    public ResponseEntity<ResponsePaginationObject> getAllVideos(@PathVariable int offset) {
        int count = 0;
        List<Video> videoList = videoService.getAllVideos();
        for (int i = 0; i < videoList.size(); i++) {
            count++;
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponsePaginationObject("OK", "Query successfully",  offset, 6, count,
                        Math.ceil(count / 6.0), videoService.getVideosWithPagination(offset, 6))
        );
    }

    @GetMapping("/search/{title}/{offset}")
    public ResponseEntity<ResponsePaginationObject> searchVideosById(@PathVariable String title, @PathVariable int offset) {
        int count = 0;
        List<Video> videoList = videoService.searchVideosByTitle(title);
        for (int i = 0; i < videoList.size(); i++) {
            count++;
        }
        if (title.trim().isEmpty() || title.trim() == "") {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponsePaginationObject()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponsePaginationObject("OK", "Query successfully", offset, 6, count,
                        Math.ceil(count / 6.0), videoService.searchVideosByTitleWithPagination(title, offset, 6))
        );

    }

}
