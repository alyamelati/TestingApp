package com.test.testingapp.model;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {
    public String image;
    public String soal;
    public List<String> daftarPilihan;
    public Integer jawabanBenar;

}
