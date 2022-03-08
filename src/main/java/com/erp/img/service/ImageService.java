package com.erp.img.service;

import com.erp.img.domain.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;
}
