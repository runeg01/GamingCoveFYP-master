package com.danny.gamingcovefyp.Review;



public class Review {

    private String title, desc, image;
    private float rating;

    public Review(){

    }

    public Review(String title, String desc, String image, float rating){
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




}
