package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Pojo.Page;
import com.example.dao.PagesMapper;
import com.example.service.IPagesService;
import org.springframework.stereotype.Service;


@Service
public class IPagesServiceImpl extends ServiceImpl<PagesMapper, Page> implements IPagesService {
}
