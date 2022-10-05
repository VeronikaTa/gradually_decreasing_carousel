package com.epam.rd.autotasks;

import java.util.LinkedList;

public class DecrementingCarousel {
    LinkedList<Integer> carousel = new LinkedList<>();
    int maximumCapacity;
    boolean runCreated;

    public DecrementingCarousel(int capacity) {
        this.maximumCapacity = capacity;
    }

    public boolean addElement(int element){
        if(this.carousel.size() < this.maximumCapacity && element > 0 && !(this.runCreated)) {
            this.carousel.add(element);
            return true;
        }
        else{
            return false;
        }
    }

    public CarouselRun run(){
        if(!this.runCreated){
            this.runCreated = true;
            if(this.carousel.size() == 0){
                for(int i = 0; i < this.maximumCapacity; i++){
                    this.carousel.add(0);
                }
            }
            return new CarouselRun(this.carousel, String.valueOf(this.getClass()));
        }
        else{
            return null;
        }
    }
}
