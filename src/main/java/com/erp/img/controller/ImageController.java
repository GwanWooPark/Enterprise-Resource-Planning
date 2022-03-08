package com.erp.img.controller;

import com.erp.img.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
}
