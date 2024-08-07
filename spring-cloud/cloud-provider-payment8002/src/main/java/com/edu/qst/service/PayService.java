package com.edu.qst.service;

import com.edu.qst.entities.Pay;

import java.util.List;

public interface PayService {
    public int pay(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();


}
