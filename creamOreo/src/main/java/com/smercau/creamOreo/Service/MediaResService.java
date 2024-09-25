package com.smercau.creamOreo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smercau.creamOreo.Repository.Oreo.MediaResRepository;
import com.smercau.creamOreo.Entity.Oreo.MediaRes;

import java.util.List;

@Service
public class MediaResService {

    @Autowired
    private MediaResRepository mediaResRepository;

    public MediaRes guardarProducto(MediaRes mediaRes) {
        return mediaResRepository.save(mediaRes);
    }

    public List<MediaRes> obtenerTodosLosRegistros() {
        return mediaResRepository.findAll();
    }
}

