package com.epam.rd.autotasks;

import java.util.LinkedList;

public class CarouselRun {
    LinkedList<Integer> carousel = new LinkedList<>();
    int index = 0;
    private int gradualDecrement = 0;
    private final String getClass;

    CarouselRun(LinkedList<Integer> carousel, String getClass){
        for(Integer element : carousel){
            this.carousel.add(element);
        }
        this.getClass = getClass;
    }
    public int next() {
        if(isFinished()){
            return -1;
        }
        int current = 0;
        boolean nextElementFound = false;

        while(!nextElementFound){
            if(this.zeroIndex()){
                this.increaseGradualDecrement();
            }
            if(this.carousel.get(this.index) > 0){
                current = this.carousel.get(this.index);
                this.carousel.set(this.index, this.changeElement(current));
                changeIndex();
                nextElementFound = true;
            }
            else{
                changeIndex();
            }
        }
        return current;
    }

    public boolean isFinished() {
            boolean finished = false;
            for(int value : this.carousel){
                if(value <= 0){
                    finished = true;
                }
                else{
                    finished = false;
                    break;
                }
            }
            return finished;
    }

    public void changeIndex(){
        if(index != (this.carousel.size() - 1)){
            this.index ++;
        }
        else{
            this.index = 0;
        }
    }
    private int changeElement(int current){
        if(this.getClass.contains("GraduallyDecreasingCarousel")){
            return current - this.gradualDecrement;
        }
        else if (this.getClass.contains("HalvingCarousel")){
            return current / 2;
        }
        else if(this.getClass.contains("DecrementingCarousel")){
            return current - 1;
        }
        else{
            return 0;
        }
    }

    private boolean zeroIndex(){
        return this.index == 0;
    }
    private void increaseGradualDecrement(){
        this.gradualDecrement ++;
    }
}
