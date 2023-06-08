package com.example.SuViet.service;

import com.example.SuViet.model.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoService {
    public List<Video> getAllVideos();

    public Page<Video> getVideosWithPagination(int offset, int pagesize);

    public List<Video> searchVideosByTitle(String title);

    public Page<Video> searchVideosByTitleWithPagination(String title, int offset, int pagesize);
}
